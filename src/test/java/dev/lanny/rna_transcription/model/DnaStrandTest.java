package dev.lanny.rna_transcription.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class DnaStrandTest {

    DnaStrand dna;

    @BeforeEach
    void setUp() throws Exception {
        dna = new DnaStrand("GCTA");

    }

    @Test
    @DisplayName("VAlidamos que se pueda almacenar correctamente la secuencia de ADN")
    void test_shouldStore_Valid_DnaSequence() {

        assertEquals("GCTA", dna.getSequence());
    }

    @Test
    @DisplayName("Validamos que se pueda permitir una cadena de ADN vacía sin lanzar excepción")
    void test_should_Allow_EmptySequence() {
        assertDoesNotThrow(() -> new DnaStrand(""));
        assertEquals("", new DnaStrand("").getSequence());
    }

    @Test
    @DisplayName("VAlidamos que se pueda lanzar un error si la secuencia de ADN es nula")
    void test_should_ThrowError_For_NullSequence() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new DnaStrand(null));
        assertEquals("La cadena de ADN proporcionada no puede ser nula.", exception.getMessage());
    }

    @Test
    @DisplayName("VAlidamos que se pueda lanzar un error si la secuencia de ADN contiene caracteres inválidos")
    void test_should_ThrowError_For_InvalidCharacters() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new DnaStrand("AGTX"));
        assertEquals("Se detectó un nucleótido inválido en la secuencia: X", exception.getMessage());
    }
}
