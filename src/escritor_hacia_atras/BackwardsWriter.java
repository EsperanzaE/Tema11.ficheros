package escritor_hacia_atras;

import java.io.Console;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BackwardsWriter {
    private static String FILE_NAME = "backwards.txt";//para enlazar el fichero
    private static Scanner scanner = new Scanner(System.in);


    public static void run() {

        String text="";
        try {
            System.out.println("escriba una cadena de caracteres");
            text=scanner.nextLine();
            FileWriter output = new FileWriter(FILE_NAME);//abrimos el fichero de escritura
            for (int i = text.length() - 1; i >= 0; i--) {//lo recorremos de atrás a adelante y lo escribimos
                output.write(text.charAt(i));
            }
            output.close();
        } catch (IOException ex) {
            System.out.println("\nSomething bad has happended :-)");
        }
    }

}
