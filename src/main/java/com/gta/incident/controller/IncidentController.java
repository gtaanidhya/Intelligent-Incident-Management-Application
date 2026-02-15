package com.gta.incident.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.gta.incident.entity.Incident;
import com.gta.incident.service.IncidentService;


import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/incident")
public class IncidentController {

    @Autowired
    private IncidentService incidentService;

    @GetMapping
    public List<Incident> getAllIncidents(){
        return incidentService.getAllIncidents();
    }

    @PostMapping
    public Incident postIncident(@RequestBody Incident incidentRecord){
        incidentRecord.setCreated(LocalDateTime.now());
        incidentService.createIncident(incidentRecord);
        return incidentRecord;
    }

    @GetMapping("/number/{incidentNumber}")
    public Incident getIncidentByNumber(@PathVariable String incidentNumber){
        return incidentService.getIncidentByNumber(incidentNumber).orElse(null);
    }

    @DeleteMapping("/number/{incidentNumber}")
    public boolean DeleteIncidentByNumber(@PathVariable String incidentNumber){
        incidentService.deleteIncidentByNumber((incidentNumber));
        return true;
    }

    @PutMapping("/number/{incidentNumber}")
    public Incident updateIncident(@PathVariable String incidentNumber, @RequestBody Incident incidentRecord){
//        return incidentService.updateIncident(incidentNumber,incidentRecord);
        incidentService.createIncident(incidentRecord);
        return incidentRecord;
    }

}
