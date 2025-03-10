package dev.lanny.rna_transcription.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RnaConverterTest {

    @Test
    @DisplayName("Debe convertir correctamente una secuencia corta de ADN")
    void shouldConvertShortDnaSequence() {
        DnaStrand dna = new DnaStrand("GCTA");
        assertEquals("CGAU", RnaConverter.transcribe(dna));
    }

    @Test
    @DisplayName("Debe convertir correctamente una secuencia larga de ADN")
    void shouldConvertLongDnaSequence() {
        DnaStrand dna = new DnaStrand("ACGTGGTCTTAA");
        assertEquals("UGCACCAGAAUU", RnaConverter.transcribe(dna));
    }

    @Test
    @DisplayName("Debe devolver una cadena vacía si la entrada es vacía")
    void shouldReturnEmptyStringForEmptyDna() {
        DnaStrand dna = new DnaStrand("");
        assertEquals("", RnaConverter.transcribe(dna));
    }
}
