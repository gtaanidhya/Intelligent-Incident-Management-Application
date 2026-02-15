package com.gta.incident.entity;

import java.util.Date;

public class Incident {
    private String number;
    private String title;
    private String description;
    private String source;
    private String opened_by;
    private Date created;
    private String logs;

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

    public String getLogs() {
        return logs;
    }

    public void setLogs(String logs) {
        this.logs = logs;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
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
