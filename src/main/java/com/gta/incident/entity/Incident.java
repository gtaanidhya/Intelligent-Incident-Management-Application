package com.gta.incident.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "incident_records")
public class Incident {
    @Id
    private String number;
    private String title;
    private String description;
    private String source;
    private String opened_by;
    private String category;
    private Priority priority;
    private IncidentStatus status;
    private LocalDateTime created;
    private LocalDateTime updated;

    public LocalDateTime getResolution_time() {
        return resolution_time;
    }

    public void setResolution_time(LocalDateTime resolution_time) {
        this.resolution_time = resolution_time;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public IncidentStatus getStatus() {
        return status;
    }

    public void setStatus(IncidentStatus status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    private LocalDateTime resolution_time;


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {

        this.created = created;
    }

    public String getOpened_by() {
        return opened_by;
    }

    public void setOpened_by(String opened_by) {
        this.opened_by = opened_by;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
