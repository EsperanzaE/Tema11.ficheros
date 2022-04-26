package ficherobinarioatablaentero;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class BinarioATablaEnteros {
    static final String FILE_NAME = "datos_int.dat";
    static final String FILE_NAME2 = "datos2_intObject.dat";
    static final String FILE_NAME3 = "datos3_ArrayList.dat";

    static int[] tabla = new int[10];
    static int[] tabla2 = new int[10];
    static List<Integer> tabla3 = new ArrayList<>();

    public static void run() {
        int numero = 0;
        FileInputStream archivo = null;
        ObjectInputStream input = null;
        ObjectInputStream input2 = null;
        ObjectInputStream input3 = null;
        try {

            input = new ObjectInputStream(new FileInputStream(FILE_NAME));
            input2 = new ObjectInputStream(new FileInputStream(FILE_NAME2));
            input3 = new ObjectInputStream(new FileInputStream(FILE_NAME3));

            //leemos cada tabla con el objeto que le corresponde según el fichero
            numero = (int) input.read();
            while (numero != -1) {
                //System.out.println(numero);
                tabla[numero]=numero;
                numero = (int) input.read();
            }
            tabla2= (int[]) input2.readObject();
            tabla3= (List<Integer>) input3.readObject();
            System.out.print("la tabla1 es ");
            for (int i = 0; i < tabla.length; i++) {
                System.out.print(" " +tabla[i]);
            }
            System.out.println("");
            System.out.print("la tabla2 es " );
            for (int i = 0; i < tabla2.length; i++) {
                System.out.print(" " +tabla2[i]);
            }
            System.out.println("");
            System.out.println("la tabla3 es " + tabla3.toString());
        } catch (EOFException eofException) {
            System.out.println("se ha llegado al final del fichero");
            System.out.println("vamos a ver qué tiene la tabla");
        } catch (IOException ioException) {
            System.out.println("error en la apertura del fichero");
        } catch (Exception exception) {
            System.out.println("error general");
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException ioException) {
                System.out.println("error en el cierre del fichero de entrada");
            }
        }
    }



}



