package contador_caracteres;

public class Registro implements Comparable<Registro> {
    private final char vocal;
    private int contVocal;

    public Registro(char vocal, int contVocal) {
        this.vocal = vocal;
        this.contVocal = contVocal;
    }


    public void incrementa(char c) {
        this.contVocal++;

    }

    public String toString() {
        return "\nCarácter " + this.vocal + " aparece " + this.contVocal + " veces";

    }

    @Override
    public int compareTo(Registro registro) {
        Character caracter= this.vocal;
      Character caracter2=registro.vocal;
      return caracter.toString().toLowerCase().compareTo(caracter2.toString());

    }
}
