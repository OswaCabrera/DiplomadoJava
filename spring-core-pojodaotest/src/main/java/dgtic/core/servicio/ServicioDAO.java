package dgtic.core.servicio;

import dgtic.core.repositorio.intf.BaseDeDatosDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ServicioDAO {

    @Autowired
    @Qualifier("baseDeDatosDaoExtra")
    private BaseDeDatosDao servicioDAO;

    public BaseDeDatosDao getServicioDAO() {
        return servicioDAO;
    }

    public void setServicioDAO(BaseDeDatosDao servicioDAO) {
        this.servicioDAO = servicioDAO;
    }

    /*
    @Autowired
    public ServicioDAO(@Qualifier("baseDeDatosDao") BaseDeDatosDao servicioDAO) {
        this.servicioDAO = servicioDAO;
    }
    /*
    @Autowired
    public ServicioDAO(BaseDeDatosDao servicioDAO) {
        this.servicioDAO = servicioDAO;
    }
    /*
    @Autowired(required = true)
    public void setServicioDAO(BaseDeDatosDao servicioDAO) {
        this.servicioDAO = servicioDAO;
    }

     */

    public String archivoCSV(String carrera) {
        return servicioDAO.getEstudiantes(carrera).stream()
                .map(alm->alm.getMatricula()+";"+
                        (alm.getMaterias().stream()
                                .map(mat->(mat.getNombre()+";"+mat.getCreditos()))
                                .collect(Collectors.joining(";")))+";"+alm.getNombre())
                .collect(Collectors.joining("\n"));
    }
}
