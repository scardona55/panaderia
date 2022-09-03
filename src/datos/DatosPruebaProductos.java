package datos;

import java.util.ArrayList;
import java.util.List;

public class DatosPruebaProductos implements IFuenteDatos {
    @Override
    public List<String[]> obtenerDatosBase() {
        String[] producto1 = {"1512","Cicharon dulce","15000"};
        String[] producto2 = {"1513","Pan dulce", "18000"};
        String[] producto3 = {"15-14","Pan agridulce", "1200"};
        List<String[]> productos = new ArrayList<>();
        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        return productos;
    }
}
