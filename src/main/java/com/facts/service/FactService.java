package com.facts.service;

import com.facts.entities.Fact;
import com.facts.entities.Schema;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FactService {
    private final List<Fact> facts = new ArrayList<>();
    private SchemaService schemaService = new SchemaService();

    public List<Fact> getCurrentFacts(List<Fact> facts, List<Schema> schemas) {
        return facts.stream()
                .filter(fact -> fact.isAdded() && schemaService.isValidFact(fact, schemas))
                .collect(Collectors.toList());
    }


    public void addFact(Fact fact) {
        facts.add(fact);
    }

    public List<Fact> getAllFacts() {
        return facts;
    }

}
