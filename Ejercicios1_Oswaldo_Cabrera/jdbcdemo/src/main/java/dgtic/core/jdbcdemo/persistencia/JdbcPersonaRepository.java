package dgtic.core.jdbcdemo.persistencia;

import dgtic.core.jdbcdemo.modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

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
        return jdbcTemplate.queryForObject("SELECT * FROM persona where idpersona =?",
                this::mapRowToPersona,id);
    }

    @Override
    public void insertar(Persona persona) {
        jdbcTemplate.update("INSERT INTO persona(nombre, edad) VALUES(?,?);",
                persona.getNombre(),
                persona.getEdad());
    }

    @Override
    public void cambiar(Persona persona) {
        jdbcTemplate.update("UPDATE persona SET nombre=?, edad=? WHERE idpersona =?",
                persona.getNombre(),
                persona.getEdad(),
                persona.getIdpersona());
    }

    @Override
    public void borrar(Persona persona) {
        jdbcTemplate.update("DELETE FROM persona WHERE idpersona =?",
                persona.getIdpersona());
    }

    @Override
    public Integer callSpedad(Integer edad) {
        // representa la llamada de procedimiento almacenado
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).
                withProcedureName("total_rango_edad");
        // configurar elementos de entrada y salida
        SqlParameterSource entrada = new MapSqlParameterSource().addValue("edad",edad);
        // se usa object porq no regresa datos específicos
        Map<String, Object> salida = jdbcCall.execute(entrada);
        return (Integer) salida.get("total");
    }
}
