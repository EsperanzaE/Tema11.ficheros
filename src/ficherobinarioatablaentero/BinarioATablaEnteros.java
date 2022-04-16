package ficherobinarioatablaentero;

import java.io.*;
import java.util.ArrayList;

public class BinarioATablaEnteros {
    static final String FILE_NAME = "datos.dat";
    static ArrayList<Integer> tabla = new ArrayList<>();
    public static void run() {
        int numero=0;
        FileInputStream archivo = null;
        ObjectInputStream input = null;
        try {
            archivo = new FileInputStream(FILE_NAME);
            input = new ObjectInputStream(archivo);
            numero=(int)input.read();
            while (numero!=-1) {
                System.out.println(numero);
                tabla.add(numero);
                numero=(int)input.read();
            }

        } catch (EOFException eofException) {
            System.out.println("se ha llegado al final del fichero");
            System.out.println("vamos a ver qué tiene la tabla");
            System.out.println("longitud de la tabla " +tabla.size());
            for (Integer elemento : tabla) {
                System.out.println(elemento);
            }
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

    public static void run2() {
        int[] tabla = new int[10];
        int numero=0, indice=0;
        FileInputStream archivo = null;
        ObjectInputStream input = null;
        try {
            archivo = new FileInputStream(FILE_NAME);
            input = new ObjectInputStream(archivo);
            //cuando el archivo datos.dat lo escribimos con writeObject usamos readObject para leerlo
            tabla= (int[]) input.readObject();
            for (int elemento : tabla) {
                System.out.println(elemento);
            }

        } catch (EOFException eofException) {
            System.out.println("se ha llegado al final del fichero");
            System.out.println("vamos a ver qué tiene la tabla");
            System.out.println("longitud de la tabla " +tabla.length);
            for (Integer elemento : tabla) {
                System.out.println(elemento);
            }
        }
        //si  no se lee con readObject, no se puede poner la siguiente excepcion
       /* catch (ClassNotFoundException classNotFoundException) {
            System.out.println("la clase no se corresponde con el objeto leido");
        }*/catch (IOException ioException) {
            System.out.println("error en la lectura del fichero");
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



