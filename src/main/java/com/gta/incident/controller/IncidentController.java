package com.gta.incident.controller;

import org.springframework.web.bind.annotation.*;
import com.gta.incident.entity.Incident;
import com.gta.incident.service.IncidentService;


import java.util.List;


@RestController
@RequestMapping("/incident")
public class IncidentController {

    private final IncidentService incidentService;
    public IncidentController(IncidentService incidentService){
        this.incidentService = incidentService;
    }

    @GetMapping
    public List<Incident> getAllIncidents(){
        return incidentService.getAllIncidents();
    }

    @PostMapping
    public boolean postIncident(@RequestBody Incident incidentRecord){
        incidentService.createIncident(incidentRecord);
        return true;
    }

    @GetMapping("/number/{incidentNumber}")
    public Incident getIncidentByNumber(@PathVariable String incidentNumber){
        return incidentService.getIncidentByNumber(incidentNumber);
    }

    @DeleteMapping("/number/{incidentNumber}")
    public Incident DeleteIncidentByNumber(@PathVariable String incidentNumber){
        return incidentService.deleteIncidentByNumber((incidentNumber));
    }

    @PutMapping("/number/{incidentNumber}")
    public Incident updateIncident(@PathVariable String incidentNumber, @RequestBody Incident incidentRecord){
        return incidentService.updateIncident(incidentNumber,incidentRecord);
    }
}
