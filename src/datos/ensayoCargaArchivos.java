package datos;
import java.io.FileReader;
import java.io.BufferedReader;

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
                    System.out.println(cadena);
                }
            }else{
                System.out.println("Hay un error con el archivo ");
            }
        }catch (Exception e){
            System.out.println("Error= "+e.getMessage());
        }
    }
}
