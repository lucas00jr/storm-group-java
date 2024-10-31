package com.facts;

import com.facts.entities.Fact;
import com.facts.entities.Schema;
import com.facts.service.SchemaService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SchemaUnitTest {
	private final SchemaService schemaService = new SchemaService();


	@Test
	void testIsValidFact_WhenFactHasValidAttribute_ReturnsTrue() {
		// Arrange
		Fact fact = new Fact("João", "endereço", "rua alice, 10", true);
		List<Schema> schemas = List.of(new Schema("endereço", "one"));

		// Act
		boolean result = schemaService.isValidFact(fact, schemas);

		// Assert
		assertTrue(result, "O fact deveria ser considerado válido.");
	}

	@Test
	void testIsValidFact_WhenFactHasInvalidAttribute_ReturnsFalse() {
		// Arrange
		Fact fact = new Fact("Gabriel", "telefone", "234-5678", true);
		List<Schema> schemas = List.of(new Schema("endereço", "one"));

		// Act
		boolean result = schemaService.isValidFact(fact, schemas);

		// Assert
		assertFalse(result, "O fact não deveria ser considerado válido.");
	}

	@Test
	void testIsValidFact_WhenSchemasListIsEmpty_ReturnsFalse() {
		// Arrange
		Fact fact = new Fact("Ana", "idade", "30", true);
		List<Schema> schemas = List.of(); // Lista vazia

		// Act
		boolean result = schemaService.isValidFact(fact, schemas);

		// Assert
		assertFalse(result, "Um fact não deveria ser válido sem schemas.");
	}
}
