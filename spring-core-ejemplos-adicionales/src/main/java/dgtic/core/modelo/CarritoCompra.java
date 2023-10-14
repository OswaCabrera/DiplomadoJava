package dgtic.core.modelo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarritoCompra {
    private List<Producto> articulos = new ArrayList<>();

    public List<Producto> getArticulos() {
        return articulos;
    }

    public void agregarArticulos(Producto articulo){
        articulos.add(articulo);
    }
}