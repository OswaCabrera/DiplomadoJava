package dgtic.core.jdbcdemo.persistencia;

import dgtic.core.jdbcdemo.modelo.Persona;

import java.util.List;

public interface PersonaDao {
    public List<Persona> consulta();
    public Persona consultaId(int id);
    public void insertar(Persona persona);
    public void cambiar(Persona persona);
    public void borrar(Persona persona);
    public Integer callSpEdad(Integer edad);
}
