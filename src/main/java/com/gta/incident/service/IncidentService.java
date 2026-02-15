package com.gta.incident.service;

import com.gta.incident.entity.Incident;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IncidentService {
    private Map<String, Incident> incidents = new HashMap<>();

    public List<Incident> getAllIncidents(){
        return new ArrayList<>(incidents.values());
    }

    public boolean createIncident(Incident incidentRecord){
        incidents.put(incidentRecord.getNumber(),incidentRecord);
        return true;
    }

    public Incident getIncidentByNumber(String incidentNumber){
        return incidents.get(incidentNumber);
    }

    public Incident deleteIncidentByNumber(String incidentNumber){
        return incidents.remove(incidentNumber);
    }

    public Incident updateIncident(String incidentNumber, Incident incidentRecord){
        incidents.put(incidentNumber, incidentRecord);
        return incidentRecord;
    }
}
