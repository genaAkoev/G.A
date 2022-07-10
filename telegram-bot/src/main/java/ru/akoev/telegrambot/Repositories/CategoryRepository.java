package ru.akoev.telegrambot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.akoev.telegrambot.Entities.Category;
import ru.akoev.telegrambot.Entities.Client;

@RepositoryRestResource (collectionResourceRel = "categories", path = "categories")
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}
