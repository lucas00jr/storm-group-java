package com.facts.controller;


import com.facts.entities.Fact;
import com.facts.entities.Schema;
import com.facts.service.FactService;
import com.facts.service.SchemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class FactController {

    private final FactService factService;
    private final SchemaService schemaService;

    @Autowired
    public FactController(FactService factService, SchemaService schemaService) {
        this.factService = factService;
        this.schemaService = schemaService;
    }

    @GetMapping()
    public String index(Model model) {
        List<Fact> facts = factService.getAllFacts();
        List<Schema> schemas = schemaService.getAllSchemas();
        List<Fact> currentFacts = factService.getCurrentFacts(facts, schemas);

        model.addAttribute("facts", facts);
        model.addAttribute("schemas", schemas);
        model.addAttribute("currentFacts", currentFacts);

        return "index";
    }

    @GetMapping("/addFact")
    public String showAddFactForm(Model model) {
        model.addAttribute("fact", new Fact());
        return "addFact";
    }

    @PostMapping("/addFact")
    public String addFact(Fact fact) {
        factService.addFact(fact);
        return "redirect:/";
    }

    @GetMapping("/addSchema")
    public String showAddSchemaForm(Model model) {
        model.addAttribute("schema", new Schema());
        return "addSchema";
    }

    @PostMapping("/addSchema")
    public String addSchema(Schema schema) {
        schemaService.addSchema(schema);
        return "redirect:/";
    }
}
