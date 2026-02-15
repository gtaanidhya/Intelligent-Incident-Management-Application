package com.gta.incident.service;

import com.gta.incident.entity.Incident;
import com.gta.incident.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class IncidentService {

    @Autowired
    private IncidentRepository incidentRepository;

    public List<Incident> getAllIncidents(){
        return incidentRepository.findAll();
    }

    public void createIncident(Incident incidentRecord){
        incidentRepository.save(incidentRecord);
    }

    public Optional<Incident> getIncidentByNumber(String incidentNumber){
        return incidentRepository.findById(incidentNumber);
    }

    public void deleteIncidentByNumber(String incidentNumber){
        incidentRepository.deleteById(incidentNumber);
    }

//    public Incident updateIncident(String incidentNumber, Incident incidentRecord){
//        incidents.put(incidentNumber, incidentRecord);
//        return incidentRecord;
//    }
}
