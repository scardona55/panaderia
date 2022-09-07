package logica;

import datos.DatosPruebaTiendas;
import datos.EscritorArchivoOrdenes;
import entidades.base.Recorrido;
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

    }

    private void crearDetalle(OrdenPedido orden, String[] datosBaseDetalle){

    }


    /**public obtenerDetallesOrdenados <List<String>> getObjectType(){

    }
    **/



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