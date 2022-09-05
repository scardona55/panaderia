package datos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import  java.util.Scanner;


public class LectorArchivo implements IFuenteDatos {
    private String nombreArchivo = ("D:\\Nueva carpeta\\Desktop\\clases 2022-2\\Ing de software\\archivosPrueba\\tiendas.txt");

    public LectorArchivo(String nombreArchivo){
        FileReader archivo;
        BufferedReader lector;
        try {
            archivo = new FileReader(nombreArchivo);
            if (archivo.ready()){
                lector = new BufferedReader(archivo);
                String cadena;
                while ((cadena = lector.readLine()) != null){
                    String[] datos = cadena.split(",");
                    System.out.println(datos);
                }
            }else{
                System.out.println("Hay un error con el archivo ");
            }
        }catch (Exception e){
            System.out.println("Error= "+e.getMessage());
        }
    }

    @Override
    public List<String[]> obtenerDatosBase() {
        System.out.println("Los datos cargados son de tiendas o de productos");
        Scanner sc = new Scanner(System.in);
        String opc = sc.nextLine();
        if(opc =="tienda"){
            List<String[]> tiendas = new ArrayList<>();


        }
        String[] producto1 = {"1512","Cicharon dulce","15000"};
        String[] producto2 = {"1513","Pan dulce", "18000"};
        String[] producto3 = {"15-14","Pan agridulce", "1200"};
        List<String[]> productos = new ArrayList<>();
        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        return productos;

    }
}
