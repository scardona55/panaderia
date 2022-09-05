package datos;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ensayoCargaArchivos {
    public static void main (String[] args){
        FileReader archivo;
        BufferedReader lector;
        try {
            archivo = new FileReader("D:\\Nueva carpeta\\Desktop\\clases 2022-2\\Ing de software\\archivosPrueba\\tiendas.txt");
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

}
