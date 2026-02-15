package com.gta.incident.repository;

import com.gta.incident.entity.Incident;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IncidentRepository extends MongoRepository<Incident, String> {
}
