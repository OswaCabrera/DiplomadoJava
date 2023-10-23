package dgtic.core.jdbcdemo.persistencia;

import dgtic.core.jdbcdemo.modelo.Persona;
import dgtic.core.jdbcdemo.modelo.Producto;

import java.util.List;

public interface ProductoDAO {
    public List<Persona> consulta();
    public Persona consultaId(int id);
    public void insertar(Producto producto);
    public void cambiar(Producto producto);
    public void borrar(Producto producto);
}
