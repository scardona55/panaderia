package logica;
import java.util.List;

import datos.DatosPruebaProductos;
import datos.DatosPruebaTiendas;
import datos.IFuenteDatos;
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
        // SE DEBE CAMBIAR ESTA FUENTE, QUE ES DE PRUEBA
        // POR UNA QUE LEA LOS DATOS DE UN ARCHIVO.
        IFuenteDatos fuenteDatosTiendas = new DatosPruebaTiendas();

        List<String[]> datosBaseTiendas = fuenteDatosTiendas.obtenerDatosBase();
        this.cargarDatosTiendas(datosBaseTiendas);

        // FALTA CARGAR LOS DATOS DE LOS PRODUCTOS:
        // PRIMERO HACERLO CON LA CLASE DE PRUEBA,
        // Y LUEGO CON LA QUE LEE DE UN ARCHIVO.
        IFuenteDatos fuenteDatosProductos = new DatosPruebaProductos(); // CAMBIAR POR EL OBJETO CORRESPONDIENTE
        List<String[]> datosBaseProductos = fuenteDatosProductos.obtenerDatosBase();
        this.cargarDatosProductos(datosBaseProductos);
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