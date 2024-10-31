package com.facts.repository;

import com.facts.entities.Fact;
import com.facts.entities.Schema;
import com.facts.service.FactService;
import com.facts.service.SchemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer {

    private final FactService factService;
    private final SchemaService schemaService;

    @Autowired
    public DataInitializer(FactService factService, SchemaService schemaService) {
        this.factService = factService;
        this.schemaService = schemaService;
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        List<Fact> facts = Arrays.asList(
                new Fact("gabriel", "endereço", "av rio branco, 109", true),
                new Fact("joão", "endereço", "rua alice, 10", true),
                new Fact("joão", "endereço", "rua bob, 88", true),
                new Fact("joão", "telefone", "234-5678", true),
                new Fact("joão", "telefone", "91234-5555", true),
                new Fact("joão", "telefone", "234-5678", false),
                new Fact("gabriel", "telefone", "98888-1111", true),
                new Fact("gabriel", "telefone", "56789-1010", true)
        );

        List<Schema> schemas = Arrays.asList(
                new Schema("endereço", "one"),
                new Schema("telefone", "many")
        );

        facts.forEach(factService::addFact);
        schemas.forEach(schemaService::addSchema);
    }
}

