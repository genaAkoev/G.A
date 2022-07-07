package ru.akoev.telegrambot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.akoev.telegrambot.Entities.ClientOrder;

@RepositoryRestResource (collectionResourceRel = "client_orders", path = "client_orders")
public interface ClientOrderRepository extends JpaRepository<ClientOrder, Long> {
}
