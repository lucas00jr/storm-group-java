package com.facts;

import com.facts.entities.Fact;
import com.facts.entities.Schema;
import com.facts.service.FactService;
import com.facts.service.SchemaService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactUnitTest {
	private final FactService factService = new FactService();

	private final Schema schema = new Schema("idade", "one");

	@Test
	void testGetCurrentFacts_WithSingleFactAdded() {
		List<Fact> facts = List.of(new Fact("João", "idade", "18", true));
		List<Fact> currentFacts = factService.getCurrentFacts(facts, List.of(schema));

		assertEquals(1, currentFacts.size());
	}

	@Test
	void testGetCurrentFacts_WithSingleFactNotAdded() {
		List<Fact> facts = List.of(new Fact("João", "idade", "18", false));
		List<Fact> currentFacts = factService.getCurrentFacts(facts, List.of(schema));

		assertEquals(0, currentFacts.size());
	}

	@Test
	void testGetCurrentFacts_WithMultipleFactsMixed() {
		Schema schema1 = new Schema("telefone","one" );
		List<Fact> facts = List.of(
				new Fact("João", "idade", "18", true),
				new Fact("Gabriel", "endereço", "av rio branco, 109", false),
				new Fact("Maria", "telefone", "91234-5555", true)
		);

		List<Fact> currentFacts = factService.getCurrentFacts(facts, List.of(schema, schema1));

		assertEquals(2, currentFacts.size());
	}

	@Test
	void testGetCurrentFacts_WithEmptyFacts() {
		List<Fact> currentFacts = factService.getCurrentFacts(List.of(), List.of(schema));
		assertEquals(0, currentFacts.size());
	}
}
