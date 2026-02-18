package com.gta.incident.service;

import com.gta.incident.entity.DatabaseSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
public class SequenceGeneratorService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public long generateSequence(String sequenceName) {

        Query query = new Query(where("_id").is(sequenceName));
        Update update = new Update().inc("sequenceValue", 1);

        FindAndModifyOptions options =
                FindAndModifyOptions.options().returnNew(true).upsert(true);

        DatabaseSequence counter = mongoTemplate.findAndModify(
                query,
                update,
                options,
                DatabaseSequence.class
        );

        return counter != null ? counter.getSequenceValue() : 1;
    }
}
