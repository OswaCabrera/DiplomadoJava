package dgtic.core.modelo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Scope("prototype")
public class ListaProductos {
    @Autowired
    private List<Producto> listaProductos;

    @Autowired
    private Map<String, Producto> mapaProducto;

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public Map<String, Producto> getMapaProducto() {
        return mapaProducto;
    }

    public void setMapaProducto(Map<String, Producto> mapaProducto) {
        this.mapaProducto = mapaProducto;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
}
