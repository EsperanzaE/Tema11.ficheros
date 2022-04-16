package tablaenterosafichbinario;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

//este programa creará una tabla de enteros del 0 al 9 que la rellenará con un bucle for
//creará el fichero binario de salida que lo llama archivo y lo asociará al fichero físico "datos.dat"
//que será el fichero físico de salida de este programa.
//por otra parte, creará el elemento objectOutùt que será el objeto para poder serializar nuestra tabla de
//enteros
public class EnterosABinario {
    static final String FILE_NAME = "datos.dat";//
    static final String FILE_OBJ = "Stream Object";
    static int[] tabla = new int[10];//tabla de enteros

    public static void run() {
        tabla = llenarTabla();
        String fichError = "";
        FileOutputStream archivo = null;
        ObjectOutputStream output = null;

        try {
            fichError = FILE_NAME;
            archivo = new FileOutputStream(FILE_NAME);
            fichError = FILE_OBJ;
            output = new ObjectOutputStream(archivo);
            //escribimos el fichero dato a dato
            for (int i = 0; i < tabla.length; i++) {
                System.out.println(tabla[i]);
                output.write(tabla[i]);//escribimos en el fichero de salida
            }
//vamos a escribirlo otra vez pero todo el objeto de una vez ya que es serializable
// para leerlo luego en el otro ejercicio como objeto
            /*          output.writeObject(tabla);*/
        } catch (IOException ioException) {
            System.out.println("error en la creación del fichero " + fichError);
        } catch (Exception ex) {
            System.out.println("Problems reading " + FILE_NAME);
        } finally {
            try {//cerramos solo el segundo archivo, si cerramos el primero falla el cierre del segundo
                /*if (archivo != null) {
                    fichError = FILE_NAME;
                    archivo.close();
                }*/
                if (output != null) {
                    fichError = FILE_OBJ;
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
}
