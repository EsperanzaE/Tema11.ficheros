package bufferscanner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

//vamos a leer un fichero de números reales con la clase BufferReader y lo vamos a procesar con un Scanner
//la salida es la suma de los números reales
public class BufferScanner {
    static final String FILE_NAME = "Scanner.txt";

    public static void proceso() {
        //creamos los fichero fuera de try para poder usarlos posteriormente si fuera necesario
        BufferedReader input = null;
        Scanner scanner = null;
        String registro = "";
        Double acumulador = 0.0;

        try {
            input = new BufferedReader(new FileReader(FILE_NAME));
            registro = input.readLine();

            while (registro != null) {
                //scanner = new Scanner(registro).useLocale(Locale.US);//si los decimales se delimitan por puntos
                scanner = new Scanner(registro);
                if (scanner.hasNextDouble()) {
                    acumulador += scanner.nextDouble();
                }
                registro = input.readLine();
            }


        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("no se encuentra el fichero " + FILE_NAME);
        } catch (IOException ioEx) {
            System.out.println("error lectura fichero " + FILE_NAME);
        } catch (NumberFormatException numberFormatException) {
            System.out.println("el dato leido no es un double");
        } catch (Exception Ex) {
            System.out.println("error general");
        } finally {
            try {
                if (input != null) {//el fichero de entrada no está cerrado
                    input.close();
                    System.out.println("la suma es " + acumulador);
                }
            } catch (IOException exception) {
                System.out.println("error al cerrar el fichero de entrada");
            }
        }
    }
}
