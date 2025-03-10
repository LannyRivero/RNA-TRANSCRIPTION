package dev.lanny.rna_transcription.model;

public enum Nucleotide {
    G("C"),
    C("G"),
    T("A"),
    A("U");

    private final String rnaComplement;

    Nucleotide(String rnaComplement) {
        this.rnaComplement = rnaComplement;
    }

    public String toRna() {
        return rnaComplement;
    }

    public static boolean isValidDnaNucleotide(String nucleotide) {
        for (Nucleotide n : values()) {
            if (n.name().equals(nucleotide)) {
                return true;
            }
        }
        return false;
    }

    public static Nucleotide fromString(String nucleotide) {
        for (Nucleotide n : values()) {
            if (n.name().equals(nucleotide)) {
                return n;
            }
        }
        throw new IllegalArgumentException(" Nucleótido no reconocido: " + nucleotide);
    }
}
