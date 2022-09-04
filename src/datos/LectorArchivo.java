package datos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
                    System.out.println(cadena);
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

        return null;
    }
}
