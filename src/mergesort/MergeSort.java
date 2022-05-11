package mergesort;

import java.io.*;

import static mergesort.Main.AUX1;
import static mergesort.Main.AUX2;
import static mergesort.Main.ENTRADA;


public class MergeSort {

    public static void ordenar(String ENTRADA) {
        boolean ordenado = false;

        try {
            ordenado = dividirSplit(ENTRADA, AUX1, AUX2);
            while (!ordenado) {

                fusionarMerge(ENTRADA, AUX1, AUX2);
                ordenado = dividirSplit(ENTRADA, AUX1, AUX2);
            }

        } catch (Exception e) {
            System.out.println("algo ha tenido que pasar");
        }


    }

    /**
     * este proceso leerá del fichero aux1 y del aux2 e irá colocando en el fichero de salida
     * el menor que se encuentre, aunque esto no quiere decir que se ordenen en la primera
     * pasada ya que los ficheros aux1 y aux2 no tienen por qué estar ordenados
     * @param ENTRADA fichero de entrada que ahora será fichero de salida se devolverá
     *                con los ficheros aux1 y aux2 fusionados con el orden que estos tengan
     * @param AUX1
     * @param AUX2
     */
    private static void fusionarMerge(String ENTRADA, String AUX1, String AUX2) throws IOException{
        BufferedWriter output = null;
        BufferedReader input1 = null, input2 = null;
        String linea1="", linea2="";

        try{
            output= new BufferedWriter(new FileWriter(ENTRADA));
            input1=new BufferedReader(new FileReader(AUX1));
            input2=new BufferedReader(new FileReader(AUX2));
            linea1=input1.readLine();
            linea2=input2.readLine();

            while (linea1!=null && linea2!=null){
                if (linea1.compareTo(linea2)<0){
                    output.write(linea1);
                    output.newLine();
                    linea1=input1.readLine();
                }else{
                    output.write(linea2);
                    output.newLine();
                    linea2=input2.readLine();
                }
            }
            while (linea1!=null ){
                output.write(linea1);
                output.newLine();
                linea1=input1.readLine();
                }
            while (linea2!=null ){
                output.write(linea2);
                output.newLine();
                linea2=input2.readLine();
            }
        }
        finally {
            output.close();
            input1.close();
            input2.close();
        }

    }

    /**
     * Este procedimiento divide en dos un fichero mientras esté desordenado, Lee cada registro y si es
     * mayor que el anterior lo mete en un fichero, cuando se encuetra un registro leido menor que el anterior
     * lo escribe en el otro fichero y así sicesivamente alternando el fichero de salida cada vez que se
     * encuentre un dato menor que el anteriormente leido
     *
     * @param ENTRADA fichero secuencial de entrada
     * @param AUX1    con una parte del archivo de entrada
     * @param AUX2    con la otra parte del archivo de entrada
     * @return devuelve true si el fichero de entrada está ordenado y no hay que seguir
     * @throws IOException
     */
    private static boolean dividirSplit(String ENTRADA, String AUX1, String AUX2) throws IOException {
        BufferedReader input = null;
        BufferedWriter out = null, outtemp = null;
        String linea = "", lineaPrevia = "";
        boolean ordenado = true;
        try {
            input = new BufferedReader(new FileReader(ENTRADA));
            out = new BufferedWriter(new FileWriter(AUX1));
            outtemp = new BufferedWriter(new FileWriter(AUX2));

            linea = input.readLine();

            while (linea != null) {
                if (linea.compareTo(lineaPrevia) < 0) {//acabo de leer un valor menor que el anterior por lo que
                    //tengo que cambiar de archivo y seguir ordenando
                    ordenado = false;
                    BufferedWriter temp = outtemp;
                    outtemp = out;
                    out = temp;
                }
                //escribo el registro leido en el fichero de salida y leo un nuevo registro
                out.write(linea);
                out.newLine();
                lineaPrevia = linea;

                linea = input.readLine();
            }
        } finally {
            input.close();
            out.close();
            outtemp.close();
        }
        return ordenado;
    }
}
