package logica;

import datos.DatosPruebaTiendas;
import datos.EscritorArchivoOrdenes;
import datos.LectorArchivo;
import entidades.base.Producto;
import entidades.base.Recorrido;
import entidades.base.Tienda;
import entidades.pedido.OrdenPedido;
import java.util.Arrays;
import java.util.List;

/**
 * Lógica del programa de un recorrido de un vendedor,
 * para crear las órdenes de pedido de las tiendas.
 *
 * @version 1.0
 */
public class ControlRecorrido {
    private Recorrido recorrido;
    private OrdenPedido ordenEnproceso;
    private OrdenPedido ordenEnProceso;

    DatosPruebaTiendas t1 = new DatosPruebaTiendas();
    List<String[]> h= t1.obtenerDatosBase();

    public ControlRecorrido() {
        this.recorrido = new Recorrido();
        this.ordenEnProceso = null;
    }

    public void cargarDatosIniciales() {
        CargadorDatos cargador = new CargadorDatos(recorrido);
        cargador.cargarDatosIniciales();
    }

    /**public void cargarDatosArchivo(){
        CargadorDatos cargador = new CargadorDatos(recorrido);
    }

     **/


    public boolean existeTienda(String codigoTienda){

        /** Esta función recibe el codigo de una tienda
         * y  buscará si existe una coincidencia entre lo ingresado y la lista
         * de tiendas lo cual nos devolverá verdadero o falso
         */
        int coincidencia=0;

        for (String[] strings : h) {
            if(codigoTienda.equals(strings[0])){
                coincidencia++;
            }else{
                coincidencia=coincidencia;
            }
        }
        return coincidencia>0;
    }



    public String obtenerDatosTienda(String codigoTienda) throws Exception{
        /**
         * Primero busca si existe la tienda, si no devuelve una excepcion
         * si existe la encuentra, pasa la información a String y la retorna
         * en la variable data
         */
        String data = null;
        if(existeTienda(codigoTienda)==true){
            for (String[] strings : h) {
                if(codigoTienda.equals(strings[0])){
                    data=Arrays.toString(strings);
                }else{
                    continue;
                }
            }
        }else{
            //tirar error
            throw new Exception("Tienda no encontrada");
        }
        return data;
    }

    public void crearOrden(String nombreArchivoProducto, String codigoTienda){
        Tienda tienda = recorrido.buscarTienda(codigoTienda);
        ordenEnProceso = new OrdenPedido(tienda);
        /**
         * asignamos los valores y leemos el archivo
         */
        LectorArchivo archivo = new LectorArchivo(nombreArchivoProducto);
        List<String[]> productos = archivo.obtenerDatosBase();
        for(String[] producto:productos){
            System.out.println("Codigo: "+ producto[0]+" Cantidad: "+producto[1]);
            crearDetalle(this.ordenEnProceso, producto);
        }


    }

    private void crearDetalle(OrdenPedido orden, String[] datosBaseDetalle){
        Producto producto =  recorrido.buscarProducto(datosBaseDetalle[0]);
        if(producto!= null){
            OrdenPedido.addDetalle(producto, Integer.parseInt(datosBaseDetalle[1]));
        }

    }

    public  List<String> obtenerDetallerOrdenados(){
        List<String> detalles = ordenEnProceso.getDetallesOrdenados();
        return detalles;
    }

    // COMPLETAR LOS MÉTODOS QUE FALTAN

    /**
     * Envía la orden para que su información
     * se guarde en un archivo, y luego
     * deja el atributo en null para que se
     * pueda procesar una nueva orden.
     */
    public void guardarOrden() {
        EscritorArchivoOrdenes escritor = new EscritorArchivoOrdenes();
        escritor.escribirOrden(ordenEnProceso);
        ordenEnProceso = null;
    }
}