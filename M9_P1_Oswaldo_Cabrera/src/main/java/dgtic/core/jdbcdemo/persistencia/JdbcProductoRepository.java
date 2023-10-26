package dgtic.core.jdbcdemo.persistencia;

import dgtic.core.jdbcdemo.modelo.Persona;
import dgtic.core.jdbcdemo.modelo.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository

public class JdbcProductoRepository implements ProductoDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcProductoRepository(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    private Producto mapRowtoProducto(ResultSet rst, int row) throws SQLException{
        Producto producto = new Producto();
        producto.setId(rst.getInt(1));
        producto.setDescripcion(rst.getString(2));
        producto.setPrecio(rst.getInt(3));
        producto.setStock(rst.getInt(4));
        return producto;
    }


    @Override
    public List<Producto> findAll() {
        return jdbcTemplate.query("select * from productos", this::mapRowtoProducto);
    }

    @Override
    public Producto consultaId(int id) {
        return jdbcTemplate.queryForObject("select * from productos where id = ?", this::mapRowtoProducto, id);
    }

    @Override
    public Producto consultaNombre(String nombre) {
        return jdbcTemplate.queryForObject("select * from productos where descripcion = ?", this::mapRowtoProducto, nombre);
    }

    @Override
    public void insertar(Producto producto) {
        jdbcTemplate.update("insert into productos ( descripcion, precio, stock) values (?, ?, ?);",
                 producto.getDescripcion(), producto.getPrecio(), producto.getStock());
    }

    @Override
    public void cambiar(Producto producto) {
        jdbcTemplate.update("update productos set descripcion = ?, precio = ?, stock = ? where id = ?",
                producto.getDescripcion(), producto.getPrecio(), producto.getStock(), producto.getId());
    }

    @Override
    public void borrar(Producto producto) {
        jdbcTemplate.update("delete from productos where id = ?", producto.getId());
    }
}
