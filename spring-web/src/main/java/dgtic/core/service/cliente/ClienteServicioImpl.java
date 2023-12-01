package dgtic.core.service.cliente;

import dgtic.core.model.entity.ClienteEntity;
import dgtic.core.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicioImpl implements ClienteService{
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Page<ClienteEntity> findAll(Pageable pageable) {

        return clienteRepository.findAll(pageable);
    }

    @Override
    public void guardar(ClienteEntity cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void borrar(Integer id) {
        clienteRepository.deleteById(id);

    }

    @Override
    public ClienteEntity buscarClienteId(Integer id) {
        Optional<ClienteEntity> op=clienteRepository.findById(id);
        return op.get();

    }

    @Override
    public List<ClienteEntity> buscarClientes() {
        return null;
    }

    @Override
    @Transactional(readOnly=true)
    public List<ClienteEntity> buscarClientePatron(String patron) {
        return clienteRepository.findByNombre(patron);
    }
}
