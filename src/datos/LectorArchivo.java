package datos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import  java.util.Scanner;


public class LectorArchivo implements IFuenteDatos {
    ArrayList<String> datos1 = new ArrayList<String>();
    /**
     * Cramos un string donde nos llevara a la ubicacion de nuestro
     * archivo
     */

    public ArrayList<String> LectorArchivo(String nombreArchivo) {
        /**
         * Nuestra funcion que nos permite cargar el archivo,
         * separar los datos que esten por una coma
         * e informarnos si hay un error en el archivo.
         */
        FileReader archivo;
        BufferedReader lector;
        ArrayList<String> datos = new ArrayList<String>();
        try {
            archivo = new FileReader(nombreArchivo);
            if (archivo.ready()) {
                lector = new BufferedReader(archivo);
                String cadena;
                while ((cadena = lector.readLine()) != null) {
                    datos.add(cadena);
                }
            } else {
                System.out.println("Hay un error con el archivo ");
            }
        } catch (Exception e) {
            System.out.println("Error= " + e.getMessage());
        }
        datos1 = datos;
        return datos;

    }




    public List<String[]> obtenerDatosBase() {
        /**
         * segun lo que decida el usuario, el programa cargará tiendas
         * o productos
         */

        System.out.println("Los datos cargados son de tiendas o de productos");
        Scanner sc = new Scanner(System.in);
        String opc = sc.nextLine();
        /**
         * si es de tiendas se crea una lista de tiendas,se crea una variable
         * que traiga los datos y la convertimos en un array por cada coma,
         * luego recorre ese array para almacenar los dos primeros datos que
         * son un codigo y un nombre de tienda en una tienda que luego añade
         * en la lista de tiendas
         */
        if(opc =="tienda"){
            List<String[]> tiendas = new ArrayList<>();
            for (int i = 0; i < datos1.size(); i++) {
                String subdata=datos1.get(i);
                subdata = subdata.substring(1, subdata.length() - 1);
                String[] subdatap= subdata.split(",");
                for (int j=0; j<(subdatap.length)/2; j++){
                    String[] tienda1 = {subdatap[(i*2)],subdatap[(i*2)+1]};
                    tiendas.add(tienda1);
                }
            }
            return tiendas;

        }else{
            /**
             * si es de productos se crea una lista de productos,se crea una variable
             * que traiga los datos y la convertimos en un array por cada coma,
             * luego recorre ese array para almacenar los tres primeros datos que
             * son un codigo y un nombre y el precio en un producto que luego añade
             * en la lista de tiendas
             */
            List<String[]> productos = new ArrayList<>();
            for (int i = 0; i < datos1.size(); i++) {
                String subdata=datos1.get(i);
                subdata = subdata.substring(1, subdata.length() - 1);
                String[] subdatap= subdata.split(",");
                for (int j=0; j<(subdatap.length)/3; j++){
                    String[] producto1 = {subdatap[(i*3)],subdatap[(i*3)+1],subdatap[(i*3)+2]};
                    productos.add(producto1);
                }
            }
            return productos;
        }


    }
}
