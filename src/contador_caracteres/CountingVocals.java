package contador_caracteres;

import java.io.FileReader;
import java.io.IOException;

public class CountingVocals {
    private static String FILE_NAME = "input.txt";
    private static String VOCALS = "aefikopuwá";


    public static void run() {
        try {
            CharCounter counters = new CharCounter(VOCALS, false);
            FileReader input = new FileReader(FILE_NAME);
            int c = input.read();
            while (c != -1) {
                counters.countIfTargeted((char) c);
                c = input.read();
            }
            input.close();
            System.out.println(counters.toString());
//añadimos esta sentencia para que no se duplique la tabla cuando ejecutemos CountingVocals2
            CharCounter.tablaCaracteres.clear();
        } catch (IOException ex) {
            System.out.println("Something bad has happended :--‐(");
        }
    }
}


