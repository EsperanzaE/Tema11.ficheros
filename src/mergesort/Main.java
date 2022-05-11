package mergesort;

import java.io.FileReader;
import java.io.IOException;


public class Main {

    public static final String ENTRADA = "datos.txt", AUX1 = "aux1.txt", AUX2 = "aux2.txt";

    public static void main(String[] args) throws IOException {
        FileReader fichero=null;
        fichero= Utilidades.montarFichero(ENTRADA);
        if (fichero!= null) {
            MergeSort.ordenar(ENTRADA);
        }
    }
}
