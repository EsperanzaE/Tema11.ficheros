package mergesort;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Utilidades {

    public static FileReader montarFichero(String ENTRADA) {
        FileReader fichero= null;
        try{
            fichero =new FileReader(ENTRADA);

        }catch (FileNotFoundException fileNotFoundException){
            System.out.println("fichero de entrada no existe");
        }
        return fichero;
    }
}
