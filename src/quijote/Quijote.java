package quijote;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

//para escribir la primera línea nos recorreremos el String caracter a carácter como si de un array se tra-
//tara,  la segunda línea la escribiremos directamente
public class Quijote {
    static final String FILE_NAME = "Quijote.txt";
    static String cadena = "";

    public static void escribir() {
        BufferedWriter output = null;
        try {
            output = new BufferedWriter(new FileWriter(FILE_NAME));
            cadena = "En un lugar de La Mancha";
            for (int i = 0; i < cadena.length(); i++) {
                output.write(cadena.charAt(i));
            }
            cadena = "de cuyo nombre no quiero acordarme";
            output.newLine();//metemos el salto de linea
            output.write(cadena);
        } catch (IOException ioException) {
            System.out.println("error de escritura");
        } catch (Exception Exception) {
            System.out.println("error general");
        } finally {
            try {
                if (output != null) {//el fichero está abierto
                    output.close();
                }
            } catch (Exception exception) {
                System.out.println("problemas al cerrar el fichero");
            }
        }
    }
}
