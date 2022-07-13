package ru.akoev.telegrambot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.akoev.telegrambot.entities.Product;
import java.util.List;

@RepositoryRestResource (collectionResourceRel = "products", path = "products")
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findProductByName(String name);

    List<Product> getByCategoryId(Long id);

    @Query("select distinct op.product from OrderProduct as op where op.clientOrder in " +
            "(select co from ClientOrder as co where co.client.id = :id)")
    List<Product> getAllByClientId(@Param("id") Long id);

    @Query("select op.product from OrderProduct as op group by op.product.id order by sum(op.countProduct) desc")
    List<Product> getTopPopular();
}
