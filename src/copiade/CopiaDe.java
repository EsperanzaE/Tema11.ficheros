package copiade;

import java.io.*;
import java.util.Scanner;

//en este proceso voy a pedir al usuario que introduzca por pantalla el nombre de un fichero que tiene que existir
// una vez introducido el nombre, se creará otro fichero con el mismo nombre pero con el prefijo "copia_de_"
public class CopiaDe {
    static final String TXT = ".txt";//habrá que añadir la extensión al fichero

    public static void proceso() {
        String ficheroError="Scanner";//voy a meter en esta variable el nombre del fichero que estoy procesando
        //en cada momento para mostrarlo en los mensajes de excepciones si se diera el caso
        String fileName = "";
        String fileNameCopia = "copia_de_";//prefijo del fichero de salida
        Scanner scanner = null;
        BufferedReader input = null;
        BufferedWriter output = null;
        String registro = null;
        try {
            scanner = new Scanner(System.in);
            System.out.println("introduzca el nombre del fichero");
            fileName = scanner.nextLine();
            fileName += TXT;//hemos leido el nombre del fichero y añadido la extensión
            //ahora vamos a abrirlo para poder procesarlo
            ficheroError=fileName;
            input = new BufferedReader(new FileReader(fileName));
            //si el programa sigue por aquí es porque ha encontrado el archivo y puede abrirlo sin problemas
            registro = input.readLine();
            //si el programa sigue por aquí es porque ha podido leerlo --> voy a crear el archivo de salida
            // si el archivo tiene registros claro...
            if (registro != null) {
                fileNameCopia += fileName;//monto el nombre del fichero de salida
                ficheroError=fileNameCopia;
                output = new BufferedWriter(new FileWriter(fileNameCopia));
                while (registro != null) {
                    ficheroError=fileNameCopia;
                    output.write(registro);
                    output.newLine();
                    ficheroError=fileName;
                    registro = input.readLine();
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Problems opening " + ficheroError);
        } catch (IOException ex) {
            System.out.println("Problems reading " + ficheroError);
        }
        catch (Exception exception) {
            System.out.println("Problems en general " + ficheroError);
        }finally {
            try {
                ficheroError=fileName;
                input.close();
                ficheroError=fileNameCopia;
                output.close();
            } catch (IOException ex) {
                System.out.println("Problems closing " + ficheroError);
            }
        }
    }
}
