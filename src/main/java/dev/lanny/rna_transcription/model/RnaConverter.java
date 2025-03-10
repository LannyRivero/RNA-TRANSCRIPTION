package dev.lanny.rna_transcription.model;

import java.util.stream.Collectors;

public class RnaConverter {
    public static String transcribe(DnaStrand dna) {
        return dna.getSequence()
                .chars()
                .mapToObj(c -> Nucleotide.fromString(String.valueOf((char) c)).toRna())
                .collect(Collectors.joining());
    }
}
