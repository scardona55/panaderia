package datos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import  java.util.Scanner;


public class LectorArchivo implements IFuenteDatos {

    /**
     * Cramos un string donde nos llevara a la ubicacion de nuestro
     * archivo
     */
    //private String nombreArchivo = ("D:\\Nueva carpeta\\Desktop\\clases 2022-2\\Ing de software\\archivosPrueba\\tiendas.txt");

    public String[] LectorArchivo(String nombreArchivo) {
        /**
         * Nuestra funcion que nos permite cargar el archivo,
         * separar los datos que esten por una coma
         * e informarnos si hay un error en el archivo.
         */
        FileReader archivo;
        BufferedReader lector;
        String[] datos = new String[0];
        try {
            archivo = new FileReader(nombreArchivo);
            if (archivo.ready()) {
                lector = new BufferedReader(archivo);
                String cadena;
                while ((cadena = lector.readLine()) != null) {
                    datos = cadena.split(",");
                }
            } else {
                System.out.println("Hay un error con el archivo ");
            }
        } catch (Exception e) {
            System.out.println("Error= " + e.getMessage());
        }
        System.out.println(datos);
        return datos;

    }

    @Override
    public List<String[]> obtenerDatosBase() {

        System.out.println("Los datos cargados son de tiendas o de productos");
        Scanner sc = new Scanner(System.in);
        String opc = sc.nextLine();
        if(opc =="tienda"){
            List<String[]> tiendas = new ArrayList<>();



        }else{

        }
        List<String[]> productos = new ArrayList<>();
        /**productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);**/
        return productos;

    }
}
