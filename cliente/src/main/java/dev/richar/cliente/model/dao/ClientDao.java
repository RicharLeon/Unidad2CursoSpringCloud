package dev.richar.cliente.model.dao;

import dev.richar.cliente.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDao extends JpaRepository<Client, Long> {
    // This interface will automatically inherit CRUD operations from JpaRepository
    // You can add custom query methods here if needed
}
