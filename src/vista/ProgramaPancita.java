package vista;

import java.util.InputMismatchException;
import java.util.Scanner;

import entidades.base.Tienda;
import logica.ControlRecorrido;

/**
 * Realiza la interacción con el usuario
 * para poder iniciar el programa y procesar
 * las órdenes de pedido de un recorrido de ventas.
 *
 *
 *
 * Listo
 *
 * @version 1.0
 */
public class ProgramaPancita {
    private ControlRecorrido control;

    public ProgramaPancita() {
        this.control = new ControlRecorrido();
    }

    /**
     * Permite cargar los datos iniciales necesarios
     * para hacer el recorrido.
     */
    public void iniciar() {
        /**
         * Creamos el menu de usuario para el progrma pancia
         * con sus respectivas opciones para ser mas facil e intuitivo para los usuarios
         */
        System.out.println("+++Bievenido a Panaderia Pancita+++");
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        while(!salir){
            System.out.println("Menu: ");
            System.out.println("1.Cargar Datos Tiendas");
            System.out.println("2.Hacer recorrido");
            System.out.println("3.Cargar Datos productos");
            System.out.println("0. Salir");

            try{
                System.out.println("Por favor ingrese la opcion que desea realizar: ");
                int opcion = sc.nextInt();
                switch (opcion){
                    case 0:
                        System.out.println("Muchas gracias, vuelva pronto");
                        salir = true;
                        break;
                    case 1:
                        System.out.println("Carga de datos");
                        this.control.cargarDatosIniciales();
                        System.out.println("Se han cargado los datos");
                        break;
                    case 2:
                        System.out.println();
                        this.hacerRecorrido();
                        break;
                    case 3:
                        System.out.println("Carga de productos");
                        break;
                    case 4:
                        this.procesarUnaOrden();
                    default:
                        System.out.println("Por favor ingrese una opcion valida");
                }
            }catch (InputMismatchException e){
                System.out.println("Se debe insertar un numero");
                sc.next();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

    /**
     * Es el ciclo de control general del programa,
     * para saber si hay más ordenes o termina.
     */
    public void hacerRecorrido() throws Exception {
        Scanner consola = new Scanner(System.in);
        String respuesta = "S";
            System.out.println("¿de verdad desea crear una orden de pedido (S/N)?");
            respuesta = consola.next();
            if (respuesta.equals("S")) {
                this.procesarUnaOrden();
            }else{
                System.out.println("Gracias");

        }
        //System.out.println("Fin del programa. Muchas gracias.");
        //consola.close();
    }

    /**
     * Coordina el proceso para poder crear una orden
     * de pedido, mostrarla y pedir la aceptación
     * del usuario.
     */
    private void procesarUnaOrden() throws Exception {
        // COMPLETAR:
        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor ingrese el codigo de la tienda: ");
        String codigo = sc.nextLine();
        System.out.println("Codigo de la tienda: " + codigo);
        boolean tienda = this.control.existeTienda(codigo);
        String nombreArchivoProductos = null;
        if (tienda == true) {
            System.out.println("Existe");
            //System.out.println("Ingrese el nombre del archivo de los productos ");
            //nombreArchivoProductos = sc.nextLine();
            //this.control.crearOrden(nombreArchivoProductos, codigo);

            System.out.println(this.control.obtenerDatosTienda(codigo));
        } else {
            System.out.println("NO existe");

        }
        // PRIMERO PEDIR EL CÓDIGO DE LA TIENDA
        // Y VERIFICAR SI EXISTE.

        // SI EXISTE:
        // PEDIR LA RUTA CON LOS PRODUCTOS DEL PEDIDO
        // Y SOLICITAR AL CONTROL CREAR LA ORDEN.

        // LUEGO: PEDIR AL CONTROL LOS DATOS DE LA TIENDA
        // Y LOS DETALLES ORDENADOS, PARA MOSTRAR AL USUARIO.

        // PREGUNTAR SI DESEA ACEPTAR. SI ACEPTA:
        // INFORMAR AL CONTROL PARA QUE GUARDE LA ORDEN.
    }
}