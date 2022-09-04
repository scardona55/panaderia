package vista;

import java.util.InputMismatchException;
import java.util.Scanner;

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
        System.out.println("+++Bievenido a Panaderia Pancita+++");
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        while(!salir){
            System.out.println("Menu: ");
            System.out.println("1.Cargar Datos");
            System.out.println("2.Hacer recorrido");
            System.out.println("3.Cargar productos");
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
                    case 3:
                        System.out.println("Carga de productos");
                        break;
                    default:
                        System.out.println("Por favor ingrse una opcion valida");
                }
            }catch (InputMismatchException e){
                System.out.println("Se debe insertar un numero");
                sc.next();

            }
        }

    }

    /**
     * Es el ciclo de control general del programa,
     * para saber si hay más ordenes o termina.
     */
    public void hacerRecorrido() {
        Scanner consola = new Scanner(System.in);
        String respuesta = "S";
        while (respuesta.equals("S")) {
            System.out.println("¿Desea crear orden de pedido (S/N)?");
            respuesta = consola.next();
            if (respuesta.equals("S")) {
                this.procesarUnaOrden();
            }
        }
        System.out.println("Fin del programa. Muchas gracias.");
        consola.close();
    }

    /**
     * Coordina el proceso para poder crear una orden
     * de pedido, mostrarla y pedir la aceptación
     * del usuario.
     */
    private void procesarUnaOrden() {
        // COMPLETAR:

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