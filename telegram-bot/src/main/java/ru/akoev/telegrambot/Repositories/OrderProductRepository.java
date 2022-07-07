package ru.akoev.telegrambot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.akoev.telegrambot.Entities.OrderProduct;

@RepositoryRestResource (collectionResourceRel = "orders_products", path = "orders_products")
public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {
}
