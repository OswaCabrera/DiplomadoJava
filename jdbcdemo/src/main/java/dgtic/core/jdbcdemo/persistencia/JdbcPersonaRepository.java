package dgtic.core.jdbcdemo.persistencia;

import dgtic.core.jdbcdemo.modelo.Persona;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class JdbcPersonaRepository implements PersonaDao{

    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Persona> findAll() {
        return null;
    }

    @Override
    public Persona findById(int id) {
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
