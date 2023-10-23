package dgtic.core.jdbcdemo.persistencia;

import dgtic.core.jdbcdemo.modelo.Persona;
import dgtic.core.jdbcdemo.modelo.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcProductoRepository implements ProductoDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcProductoRepository(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Persona> consulta() {
        return null;
    }

    @Override
    public Persona consultaId(int id) {
        return null;
    }

    @Override
    public void insertar(Producto producto) {

    }

    @Override
    public void cambiar(Producto producto) {

    }

    @Override
    public void borrar(Producto producto) {

    }
}
