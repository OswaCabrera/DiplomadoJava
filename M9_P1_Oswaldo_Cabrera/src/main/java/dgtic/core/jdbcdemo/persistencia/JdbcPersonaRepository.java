package dgtic.core.jdbcdemo.persistencia;

import dgtic.core.jdbcdemo.modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;
@Repository
public class JdbcPersonaRepository implements PersonaDao{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcPersonaRepository(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Persona> consulta() {
        return jdbcTemplate.query("SELECT * FROM persona;", this::mapRowToPersona);
    }

    private Persona mapRowToPersona(ResultSet rs, int row) throws java.sql.SQLException {
        Persona pr = new Persona();
        pr.setIdpersona(rs.getInt(1));
        pr.setNombre(rs.getString(2));
        pr.setEdad(rs.getInt(3));
        return pr;
    }

    @Override
    public Persona consultaId(int id) {
        return null;
    }

    @Override
    public void insertar(Persona persona) {

    }

    @Override
    public void cambiar(Persona persona) {

    }

    @Override
    public void borrar(Persona persona) {

    }

    @Override
    public Integer callSpEdad(Integer edad) {
        return null;
    }
}
