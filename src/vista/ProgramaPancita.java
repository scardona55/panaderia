package vista;

import java.util.InputMismatchException;
import java.util.Scanner;
import datos.LectorArchivo;
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

    private LectorArchivo lector;

    public ProgramaPancita() {
        this.control = new ControlRecorrido();
        this.lector = new LectorArchivo();
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
            System.out.println("1.Cargar Datos Iniciales");
            System.out.println("2.Verificar existencia tienda");
            System.out.println("3.Hacer recorrido");
            System.out.println("0. Salir");

            try{
                System.out.println("Por favor ingrese la opcion que desea realizar: ");
                int opcion = sc.nextInt();
                switch (opcion){
                    case 0:
                        System.out.println("Muchas gracias, vuelva pronto");
                        salir = true;
                        break;
                    /**
                     * Opcion para salir del sistema
                     */
                    case 1:
                        System.out.println("Carga de datos iniciales");
                        this.control.cargarDatosIniciales();
                        System.out.println("Se han cargado los datos iniciales con exito");
                        break;
                    /**
                     * Opcion para cargar los datos de los archivos de prueba
                     */
                    case 2:
                        System.out.println("Por favor ingrese el codigo de la tienda para verificar si existe");
                        String tieCod = sc.nextLine();
                        boolean exist = this.control.existeTienda(tieCod);
                        if(exist == true){
                            System.out.println("La tienda ingresada: "+ tieCod+" existe ");
                        }else{
                            System.out.println("La tienda ingresada: "+ tieCod+" no existe");
                        }
                        break;
                        //System.out.println("Carga de archivos ");
                        //this.control.cargarDatosArchivo();
                        //System.out.println("Se han cargado los datos con exito");
                    case 3:
                        System.out.println();
                        this.hacerRecorrido();
                        break;
                    /**
                     * Opcion para hacer un recorrido cuando ya esten los datos
                     */
                    case 4:
                        this.procesarUnaOrden();
                    case 5:
                        String nombreArcivo = ("D:\\Nueva carpeta\\Desktop\\clases 2022-2\\Ing de software\\archivosPrueba\\tiendas.txt");
                        this.lector.LectorArchivo(nombreArcivo);
                        break;
                    case 6:
                        this.lector.LectorArchivo("D:\\Nueva carpeta\\Desktop\\clases 2022-2\\Ing de software\\archivosPrueba\\tiendas.txt");
                        this.lector.obtenerDatosBase();
                        break;
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
        while (respuesta.equals("S")){
            System.out.println("¿desea ingresar una orden de pedido (S/N)?");
            respuesta = consola.next();
            if (respuesta.equals("S")) {
                this.procesarUnaOrden();
            }else{
                System.out.println("Gracias");
                consola.close();
        }

        }
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
        if (tienda == true) {
            System.out.println("Existe");
            System.out.println(control.obtenerDatosTienda(codigo));
            System.out.println("Ingrese la ruta del archivo de los productos a pedir");
            String ruta = sc.next();
            control.crearOrden(ruta, codigo);
            System.out.println("¿Desea realizar la orden?       S/N");
            String ord = sc.nextLine();
            if(ord.equals("S")){
                control.guardarOrden();
            }else{
                System.out.println("Orden Cancelada.");
            }
        } else {
            System.out.println("No existe una tienda con dicho codigo, por favor revise");
            System.out.println("Volviendo al menu principal");
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