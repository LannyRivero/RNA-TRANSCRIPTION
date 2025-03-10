package dev.lanny.rna_transcription.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class NucleotideTest {

    @Test
    @DisplayName("Validamos que se puedan convertir correctamente los nucleótidos de ADN a ARN")
    void test_shouldConvert_Dna_To_Rna() {
        assertThat(Nucleotide.G.toRna(), is("C"));
        assertThat(Nucleotide.C.toRna(), is("G"));
        assertThat(Nucleotide.T.toRna(), is("A"));
        assertThat(Nucleotide.A.toRna(), is("U"));
    }

    @Test
    @DisplayName("VAlidamos que se pueda obtener un Nucleotide válido desde un String")
    void test_shouldReturn_ValidNucleotide_FromString() {
        assertThat(Nucleotide.fromString("G"), is(Nucleotide.G));
        assertThat(Nucleotide.fromString("C"), is(Nucleotide.C));
        assertThat(Nucleotide.fromString("T"), is(Nucleotide.T));
        assertThat(Nucleotide.fromString("A"), is(Nucleotide.A));
    }

    @Test
    @DisplayName("VAlidamos que se pueda lanzar una excepción para un nucleótido inválido")
    void test_shouldThrowException_For_Invalid_Nucleotide() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Nucleotide.fromString("X"));
        assertThat(exception.getMessage(), containsString("Nucleótido no reconocido: X"));
    }

    @Test
    @DisplayName("Validamos  correctamente los nucleótidos de ADN")
    void test_shouldValidate_Dna_Nucleotide_Correctly() {
        assertTrue(Nucleotide.isValidDnaNucleotide("A"));
        assertTrue(Nucleotide.isValidDnaNucleotide("C"));
        assertTrue(Nucleotide.isValidDnaNucleotide("G"));
        assertTrue(Nucleotide.isValidDnaNucleotide("T"));
        assertFalse(Nucleotide.isValidDnaNucleotide("X"));
        assertFalse(Nucleotide.isValidDnaNucleotide("1"));
        assertFalse(Nucleotide.isValidDnaNucleotide(" "));
    }
}
