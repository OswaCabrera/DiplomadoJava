package dgtic.core.service.cliente;

import dgtic.core.model.entity.ClienteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClienteService {
    Page<ClienteEntity> findAll(Pageable pageable);
    void guardar(ClienteEntity cliente);
    void borrar(Integer id);
    ClienteEntity buscarClienteId(Integer id);
    List<ClienteEntity> buscarClientes();
    List<ClienteEntity> buscarClientePatron(String patron);
}
