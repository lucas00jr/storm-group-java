package com.facts.service;

import com.facts.entities.Fact;
import com.facts.entities.Schema;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchemaService {
    private final List<Schema> schemas = new ArrayList<>();
    public boolean isValidFact(Fact fact, List<Schema> schemas) {
        return schemas.stream()
                .anyMatch(schema -> schema.getAttribute().equals(fact.getAttribute()));
    }


    public void addSchema(Schema schema) {
        schemas.add(schema);
    }
    public List<Schema> getAllSchemas() {
        return schemas;
    }
}
