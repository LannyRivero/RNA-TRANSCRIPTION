package dev.lanny.rna_transcription.model;

public class DnaStrand {
    private final String sequence;

    public DnaStrand(String sequence) {
        if (sequence == null) {
            throw new IllegalArgumentException("La cadena de ADN proporcionada no puede ser nula.");
        }

        if (!sequence.isEmpty()) {
            for (char nucleotide : sequence.toCharArray()) {
                if (!Nucleotide.isValidDnaNucleotide(String.valueOf(nucleotide))) {
                    throw new IllegalArgumentException(
                            "Se detectó un nucleótido inválido en la secuencia: " + nucleotide);
                }
            }
        }

        this.sequence = sequence;
    }

    public String getSequence() {
        return sequence;
    }
}
