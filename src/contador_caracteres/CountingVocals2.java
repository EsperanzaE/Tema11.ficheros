package contador_caracteres;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CountingVocals2 {
    private static String FILE_NAME = "input.txt";
    private static String VOCALS = "aefikopuwá";


    public static void run() {
        FileReader input = null;
        try {
            CharCounter counters = new CharCounter(VOCALS, false);
            input = new FileReader(FILE_NAME);
            int c;
            while (( c = input.read() ) != -1) {
                counters.countIfTargeted((char) c);
            }
			System.out.println(counters);
        } catch (FileNotFoundException ex) {
			System.out.println("Problems opening " + FILE_NAME);
        } catch (IOException ex) {
			System.out.println("Problems reading " + FILE_NAME);
        } finally {
            try {
                input.close();
            } catch (IOException ex) {
				System.out.println("Problems closing " + FILE_NAME);
            }
        }
    }
}




