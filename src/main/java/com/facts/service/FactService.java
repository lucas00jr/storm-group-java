package com.facts.service;

import com.facts.entities.Fact;
import com.facts.entities.Schema;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FactService {
    private final List<Fact> facts = new ArrayList<>();
    private SchemaService schemaService = new SchemaService();

    public List<Fact> getCurrentFacts(List<Fact> facts, List<Schema> schemas) {
        Map<String, Fact> uniqueFacts = new HashMap<>();
        List<Fact> resultFacts = new ArrayList<>();

        for (Fact fact : facts) {
            if (!fact.isAdded()) {
                uniqueFacts.remove(fact.getEntity() + "-" + fact.getAttribute() + "-" + fact.getValue());
            } else if (schemaService.isValidFact(fact, schemas)) {
                Schema schema = schemas.stream()
                        .filter(s -> s.getAttribute().equals(fact.getAttribute()))
                        .findFirst()
                        .orElse(null);

                if (schema != null && "one".equalsIgnoreCase(schema.getCardinality())) {
                    uniqueFacts.put(fact.getEntity() + "-" + fact.getAttribute(), fact);
                } else {
                    uniqueFacts.put(fact.getEntity() + "-" + fact.getAttribute() + "-" + fact.getValue(), fact);
                }
            }
        }

        resultFacts.addAll(uniqueFacts.values());

        return resultFacts;
    }


    public void addFact(Fact fact) {
        facts.add(fact);
    }

    public List<Fact> getAllFacts() {
        return facts;
    }

}
