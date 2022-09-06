package logica;
import java.util.List;
import java.util.Scanner;

import datos.DatosPruebaProductos;
import datos.DatosPruebaTiendas;
import datos.IFuenteDatos;
import datos.LectorArchivo;
import entidades.base.Producto;
import entidades.base.Recorrido;
import entidades.base.Tienda;

/**
 * Se encarga de crear los objetos a partir
 * de arreglos de cadenas de texto con la información
 * (esas cadenas pueden provenir de diferentes
 *  fuentes, por eso usa una interfaz,
 *  para que se puedan cambiar fácilmente).
 *
 * @version  1.0
 */
public class CargadorDatos {
    private Recorrido recorrido;

    public CargadorDatos(Recorrido recorrido) {
        this.recorrido = recorrido;
    }

    /**
     * Carga los datos iniciales que necesita el programa:
     * tiendas y productos.
     */
    public void cargarDatosIniciales() {
        System.out.println("Se cargaran los datos iniciales del sistema ");
        System.out.println("Cargando datos de tienda....");
        IFuenteDatos datosInicialesTienda = new DatosPruebaTiendas();
        List<String[]> datosBaseTienda = datosInicialesTienda.obtenerDatosBase();
        if (datosBaseTienda == null){
            System.out.println("Error al cargar los archivos de tienda");
        }else{
            System.out.println("Los datos de tienda han sido cargados con exito  ");
            this.cargarDatosTiendas(datosBaseTienda);
            System.out.println("..........");
        }
        System.out.println("Cargando los datos de productos...");
        IFuenteDatos datosInicialesProductos = new DatosPruebaProductos();
        List<String[]> datosBaseProductos = datosInicialesProductos.obtenerDatosBase();
        if(datosBaseProductos == null){
            System.out.println("Error al cargar los datos de productos ");
        }else{
            System.out.println("Los datos de productos han sido cargados con exito");
            System.out.println("......");
            this.cargarDatosProductos(datosBaseProductos);
        }
    }

    public void cargarDatosArchivo(){
        System.out.println("Dea cargar datos en tienda o en producto");
        Scanner sc = new Scanner(System.in);
        String opcion = sc.nextLine();
        if(opcion == "T"){
            IFuenteDatos datosTienda = new LectorArchivo();
            List<String[]> datosT = datosTienda.obtenerDatosBase();
        }else if (opcion == "P"){

        }else{
            System.out.println("ingrese una opcion valida");
        }
    }

    /**
     * A partir de los datos base (cadenas de texto),
     * obtiene los datos de las tiendas,
     * crea los objetos y los guarda en el objeto recorrido.
     */
    private void cargarDatosTiendas(List<String[]> datosBaseTiendas) {
        for (String[] datoBaseTienda: datosBaseTiendas) {
            String codigo = datoBaseTienda[0];
            String nombre = datoBaseTienda[1];
            Tienda tienda = new Tienda(codigo, nombre);
            this.recorrido.addTienda(tienda);
        }
    }

    /**
     * A partir de los datos base (cadenas de texto),
     * obtiene los datos de los productos,
     * crea los objetos y los guarda en el objeto recorrido.
     */
    private void cargarDatosProductos(List<String[]> datosBaseProductos) {
        for(String[] datosBaseProducto: datosBaseProductos ){
            String codigo = datosBaseProducto[0];
            String nombre = datosBaseProducto[1];
            Double valorUnitario = Double.parseDouble(datosBaseProducto[2]);
            Producto producto = new Producto(codigo, nombre, valorUnitario);
            this.recorrido.addProducto(producto);
        }
        // FALTA COMPLETAR EL CÓDIGO
    }
}