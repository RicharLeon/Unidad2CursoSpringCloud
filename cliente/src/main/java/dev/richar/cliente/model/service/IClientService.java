package dev.richar.cliente.model.service;

import dev.richar.cliente.model.entity.Client;

public interface IClientService {

    Client save(Client client);

    Iterable<Client> findAll();
}
