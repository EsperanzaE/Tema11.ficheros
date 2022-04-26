package tablaenterosafichbinario;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

//este programa creará una tabla de enteros del 0 al 9 que la rellenará con un bucle for
//creará el fichero binario de salida que lo llama archivo y lo asociará al fichero físico "datos.dat"
//que será el fichero físico de salida de este programa.
//por otra parte, creará el elemento objectOutùt que será el objeto para poder serializar nuestra tabla de
//enteros
public class EnterosABinario {
    static final String FILE_NAME = "datos_int.dat";// aquí vamos a escribir una tabla de enteros dato a dato
    static final String FILE_NAME2 = "datos2_intObject.dat";//aquí vamos a escribir la misma tabla de enteros pero como un objeto
    static final String FILE_NAME3 = "datos3_ArrayList.dat";//aquí vamos a escribir un list<integer> también como un objeto
    static final String FILE_OBJ = "Stream Object";//como he llamado al ObjectStream

    static int[] tabla = new int[10];//tabla de enteros
    static List<Integer> tabla2 = new ArrayList<>();// ArrayList de Integer

    public static void run() {
        tabla = llenarTabla();//llenamos el array de enteros
        tabla2 = llenarTabla2();//llenamos el arrayList de enteros
        String fichError = "";//creo esta variable para que si sale una excepción me diga el fichero que ha dado
                                //realmente el error
        //FileOutputStream archivo = null;
        ObjectOutputStream output = null;
        ObjectOutputStream output2 = null;
        ObjectOutputStream output3 = null;

        try {
            fichError = FILE_NAME;
            output = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            fichError = FILE_NAME2;
            output2 = new ObjectOutputStream(new FileOutputStream(FILE_NAME2));
            fichError = FILE_NAME3;
            output3 = new ObjectOutputStream(new FileOutputStream(FILE_NAME3));
            //escribimos el fichero dato a dato
            for (int i = 0; i < tabla.length; i++) {
                System.out.println(tabla[i]);
                output.write(tabla[i]);//escribimos en el fichero de salida
            }

//vamos a escribir el segundo archivo con la misma tabla de enteros pero todo el objeto de una vez
// ya que es serializable para leerlo luego en el otro ejercicio como objeto
                  output2.writeObject(tabla);
//vamos a escribir el tercer archivo con el arrayList de enteros y también como un objeto de una vez

            output3.writeObject(tabla2);
        } catch (IOException ioException) {
            System.out.println("error en la creación del fichero " + fichError);
        } catch (Exception ex) {
            System.out.println("Problems reading " + fichError);
        } finally {
            try {//cerramos solo el segundo archivo, si cerramos el primero falla el cierre del segundo
                /*if (archivo != null) {
                    fichError = FILE_NAME;
                    archivo.close();
                }*/
                if (output != null) {
                    fichError = FILE_NAME;
                    output.close();
                }
                if (output2 != null) {
                    fichError = FILE_NAME2;
                    output.close();
                }
                if (output3 != null) {
                    fichError = FILE_NAME3;
                    output.close();
                }
            } catch (IOException ex) {
                System.out.println("Problems closing " + fichError);
            }
        }
    }

    //metodo para llenar la tabla de enteros. la tabla es estática por lo que no hay que declararla dentro
//del método
    private static int[] llenarTabla() {
        for (int i = 0; i < tabla.length; i++) {
            tabla[i] = i;
        }
        return tabla;
    }


    private static List<Integer> llenarTabla2() {
        int i=0;
        while (i <10){
            tabla2.add(i);
            i++;
        }
        return tabla2;

    }
}
