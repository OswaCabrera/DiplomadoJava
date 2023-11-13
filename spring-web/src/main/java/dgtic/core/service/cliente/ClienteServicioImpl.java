package dgtic.core.service.cliente;

import dgtic.core.model.entity.ClienteEntity;
import dgtic.core.repository.ClienteRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicioImpl implements ClienteService {

    @Autowired
    private ClienteRepository clieteRepository;

    @Override
    public Page<ClienteEntity> findAll(Pageable pageable) {
        return clieteRepository.findAll(pageable);
    }

    @Override
    public void guardar(ClienteEntity clienteEntity) {
        clieteRepository.save(clienteEntity);
    }

    @Override
    public void borrar(Integer id) {
        clieteRepository.deleteById(id);
    }

    @Override
    public ClienteEntity buscarClienteId(Integer id) {

        Optional<ClienteEntity> clienteEntityOptional = clieteRepository.findById(id);
        return clienteEntityOptional.get();
    }

    @Override
    public List<ClienteEntity> buscarClientes(String nombre) {

        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClienteEntity> buscarClientePatron(String patron) {
        return null;
    }
}
