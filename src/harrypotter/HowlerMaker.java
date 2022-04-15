package harrypotter;

import java.io.*;

public class HowlerMaker {
    private static String MAIL_NAME = "mail.txt";
	private static String HOWLER_NAME = "howler.txt";

    public static void run(){
        String FILE_NAME="";
        BufferedReader input=null;
                BufferedWriter output=null;
        try {
             input= new BufferedReader(new FileReader(MAIL_NAME));
             output= new BufferedWriter(new FileWriter(HOWLER_NAME));
            String texto=input.readLine();
            while (texto!=null){
                output.write(texto.toUpperCase(),0,texto.length());
                output.newLine();
                //output.write("\n\r");
                texto=input.readLine();
            }

        }
        catch (FileNotFoundException fileNotfound) {
            System.out.println("fichero de entrada no encontrado :-)");
        }
        catch (IOException ex) {
            System.out.println("MAybe you know who has come :-)");
        }
        finally {
            try {
                if (input!=null){
                    FILE_NAME=MAIL_NAME;
                input.close();}
                if (output!=null){
                    FILE_NAME=HOWLER_NAME;
                    input.close();}

            } catch (IOException ex) {
                System.out.println("Problems closing " + FILE_NAME);
            }
        }
        }
    }


