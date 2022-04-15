package bufferscanner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BufferScannerEnteros {
    static final String FILE_NAME="Enteros.txt";
    public static void proceso() {
        BufferedReader input = null;
        Scanner scanner=null;
        String registro="";
        int acumulador=0, contador=0;

//abro el fichero de enteros
        try{
            input=new BufferedReader(new FileReader(FILE_NAME));
            registro=input.readLine();
            while (registro!=null){
                scanner=new Scanner(registro);
                 while (scanner.hasNextInt()){
                    acumulador+=scanner.nextInt();
                    contador++;
                }
                registro=input.readLine();
            }

        }
        catch (FileNotFoundException fileNotFoundException) {
            System.out.println("no se encuentra el fichero " + FILE_NAME);
        } catch (IOException ioEx) {
            System.out.println("error lectura fichero " + FILE_NAME);
        } catch (NumberFormatException numberFormatException) {
            System.out.println("el dato leido no es un entero");
        } catch (Exception Ex) {
            System.out.println("error general");
        } finally {
            try {
                if (input != null) {//el fichero de entrada no está cerrado
                    input.close();
                    System.out.println("la suma es " + acumulador);
                    System.out.println("la cantidad de números leídos es " + contador);
                }
            } catch (IOException exception) {
                System.out.println("error al cerrar el fichero de entrada");
            }
        }

    }
}
