package com.gta.incident.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "database_sequences")
public class DatabaseSequence {

    @Id
    private String id;

    private long sequenceValue;

    public DatabaseSequence() {}

    public DatabaseSequence(String id, long sequenceValue) {
        this.id = id;
        this.sequenceValue = sequenceValue;
    }

    public String getId() {
        return id;
    }

    public long getSequenceValue() {
        return sequenceValue;
    }

    public void setSequenceValue(long sequenceValue) {
        this.sequenceValue = sequenceValue;
    }
}
