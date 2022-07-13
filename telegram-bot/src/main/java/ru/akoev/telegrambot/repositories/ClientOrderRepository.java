package ru.akoev.telegrambot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.akoev.telegrambot.entities.ClientOrder;
import java.util.List;

@RepositoryRestResource (collectionResourceRel = "clientOrders", path = "clientOrders")
public interface ClientOrderRepository extends JpaRepository<ClientOrder, Long> {
    List<ClientOrder> findClientOrdersByStatus(Integer status);

    @Query("from ClientOrder as co where co.client.fullName = :fullName")
    List<ClientOrder> findClientOrdersByName(@Param("fullName") String fullName);
}
