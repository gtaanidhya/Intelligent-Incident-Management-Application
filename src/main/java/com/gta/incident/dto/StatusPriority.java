package com.gta.incident.dto;

import com.gta.incident.entity.IncidentStatus;
import com.gta.incident.entity.Priority;

public class StatusPriority {
    private IncidentStatus incidentStatus;
    private Priority priority;

    public IncidentStatus getIncidentStatus() {
        return incidentStatus;
    }

    public void setIncidentStatus(IncidentStatus incidentStatus) {
        this.incidentStatus = incidentStatus;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
