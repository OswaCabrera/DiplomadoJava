package dgtic.core.repositorio.impl;

import dgtic.core.modelo.Estudiante;
import dgtic.core.repositorio.BaseDeDatos;
import dgtic.core.repositorio.intf.EstudianteRepositorio;

import java.util.List;
import java.util.Optional;

public class EstudianteRepositorioImpl {
    /*
    @Override
    public List<Estudiante> findAll() {
        return BaseDeDatos.estudiantes;
    }

    @Override
    public Estudiante findById(String matricula) {
        Optional<Estudiante> estudianteOptional=BaseDeDatos.estudiantes.stream()
                .filter(e->e.getMatricula().contains(matricula))
                .findFirst();
        Estudiante estudiante=null;
        if(estudianteOptional.isPresent()){
            estudiante=estudianteOptional.orElseThrow();
        }
        return estudiante;
    }

    @Override
    public void save(Estudiante estudiante) {

    }

     */
}
