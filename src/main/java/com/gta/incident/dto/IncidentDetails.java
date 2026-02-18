package com.gta.incident.dto;


import jakarta.validation.constraints.NotBlank;

public class IncidentDetails {
    @NotBlank(message = "Title is Blank")
    private String title;
    @NotBlank(message = "Description is Blank")
    private String description;
    @NotBlank(message = "Source is Blank")
    private  String source;
    @NotBlank(message = "Opened By is Blank")
    private String opened_by;
    @NotBlank(message = "Category is Blank")
    private String category;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getOpened_by() {
        return opened_by;
    }

    public void setOpened_by(String opened_by) {
        this.opened_by = opened_by;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
