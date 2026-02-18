package com.gta.incident.controller;

import com.gta.incident.dto.StatusPriority;
import com.gta.incident.dto.IncidentDetails;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.gta.incident.entity.Incident;
import com.gta.incident.service.IncidentService;


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
    public Incident postIncident(@Valid @RequestBody IncidentDetails incidentDetails){
        return incidentService.createIncident(incidentDetails);
    }

    @GetMapping("/number/{incidentNumber}")
    public Incident getIncidentByNumber(@PathVariable String incidentNumber){
        return incidentService.getIncidentByNumber(incidentNumber);
    }

    @DeleteMapping("/number/{incidentNumber}")
    public boolean DeleteIncidentByNumber(@PathVariable String incidentNumber){
        incidentService.deleteIncidentByNumber((incidentNumber));
        return true;
    }

    @PatchMapping("/number/{incidentNumber}")
    public Incident updatePriorityStatus(@PathVariable String incidentNumber, @RequestBody StatusPriority statusPriority){
        return incidentService.updateIncidentState(incidentNumber,statusPriority);
    }



}
