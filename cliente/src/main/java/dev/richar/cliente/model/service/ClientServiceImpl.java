package dev.richar.cliente.model.service;

import dev.richar.cliente.model.dao.ClientDao;
import dev.richar.cliente.model.entity.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements IClientService {

    private final ClientDao clientDao;

    @Override
    public Client save(Client client) {
        return clientDao.save(client);
    }

    @Override
    public Iterable<Client> findAll() {
        throw new RuntimeException("Fallo simulado: no se pudo acceder a la base de datos H2");
        //return clientDao.findAll();
    }
}
