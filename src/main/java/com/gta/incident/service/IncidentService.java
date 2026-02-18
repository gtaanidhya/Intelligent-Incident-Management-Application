package com.gta.incident.service;

import com.gta.incident.dto.StatusPriority;
import com.gta.incident.entity.Incident;
import com.gta.incident.dto.IncidentDetails;
import com.gta.incident.entity.IncidentStatus;
import com.gta.incident.entity.Priority;
import com.gta.incident.repository.IncidentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class IncidentService {

    @Autowired
    private IncidentRepository incidentRepository;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    public List<Incident> getAllIncidents(){
        return incidentRepository.findAll();
    }

    public Incident createIncident(IncidentDetails incidentDetails){
        Incident incident = new Incident();
        //Coming from client
        incident.setTitle(incidentDetails.getTitle());
        incident.setDescription(incidentDetails.getDescription());
        incident.setSource(incidentDetails.getSource());
        incident.setOpened_by(incidentDetails.getOpened_by());
        incident.setCategory(incidentDetails.getCategory());
        //Automatically set
        incident.setCreated(LocalDateTime.now());
        incident.setUpdated(LocalDateTime.now());
        incident.setStatus(IncidentStatus.OPEN);
        incident.setPriority(Priority.Low);
        //Generate INC number
        incident.setNumber(generateINCnumber());
        return incidentRepository.save(incident);
    }

    public Incident getIncidentByNumber(String incidentNumber){
        return incidentRepository.findById(incidentNumber).orElseThrow(()->new RuntimeException("Incident not Found"));
    }

    public void deleteIncidentByNumber(String incidentNumber){
        incidentRepository.deleteById(incidentNumber);
    }

    public Incident updateIncidentState(String number, StatusPriority statusPriority){
        Priority newPriority = statusPriority.getPriority();
        IncidentStatus newStatus = statusPriority.getIncidentStatus();
        Incident incident = incidentRepository.findById(number).orElseThrow(()->new RuntimeException("Incident not found"));
        IncidentStatus currentStatus = incident.getStatus();
        Priority currentPriority = incident.getPriority();
        boolean statusChanged = newStatus != null && !newStatus.equals(currentStatus);
        boolean priorityChanged = newPriority != null && !newPriority.equals((currentPriority));
        if(statusChanged){
            if(!isValidTransition(currentStatus,newStatus)){
                throw new RuntimeException("Invalid Status Transition");
            }
            incident.setStatus(newStatus);
            if(newStatus==IncidentStatus.RESOLVED){
                incident.setResolution_time(LocalDateTime.now());
            }
        }
        if(priorityChanged){
            incident.setPriority(newPriority);
        }
        if(!statusChanged && !priorityChanged){
            throw new RuntimeException("No Changes Made");
        }
        else {
            incident.setUpdated(LocalDateTime.now());
            return incidentRepository.save(incident);
        }
    }

    private boolean isValidTransition(IncidentStatus current, IncidentStatus next) {

        switch (current) {
            case OPEN:
                return next == IncidentStatus.ASSIGNED;
            case ASSIGNED:
                return next == IncidentStatus.IN_PROGRESS;
            case IN_PROGRESS:
                return next == IncidentStatus.RESOLVED;
            case RESOLVED:
                return next == IncidentStatus.CLOSED;
            default:
                return false;
        }
    }

    private String generateINCnumber() {
        long seq = sequenceGeneratorService.generateSequence("incident_sequence");
        return String.format("INC%05d", seq);
    }



}
