package ru.akoev.telegrambot.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.akoev.telegrambot.entities.Client;
import ru.akoev.telegrambot.entities.ClientOrder;
import ru.akoev.telegrambot.entities.Product;
import ru.akoev.telegrambot.services.EntitiesServiceImpl;

import java.util.List;

@RestController
public class ApplicatonRestController {
    private final EntitiesServiceImpl entitiesService;

    public ApplicatonRestController(EntitiesServiceImpl entitiesService) {
        this.entitiesService = entitiesService;
    }


    @GetMapping(value = "/rest/clients", params = "name")
    public Client getClientByName(@RequestParam String name) {
        return entitiesService.getClientByName(name);
    }

    @GetMapping(value = "/rest/orders", params = "status")
    public List<ClientOrder> getOrdersByStatus(@RequestParam Integer status) {
        return entitiesService.getOrdersByStatus(status);
    }

    @GetMapping(value = "/rest/products", params = "name")
    public Product getProductByName(@RequestParam String name) {
        return entitiesService.getProductByName(name);
    }

    @GetMapping(value = "/rest/products", params = "categoryId")
    public List<Product> getProductsByCategoryId(@RequestParam Long categoryId) {
        return entitiesService.getProductsByCategoryId(categoryId);
    }

    @GetMapping(value = "/rest/listClientOrders", params = "clientName")
    public List<ClientOrder> getClientOrdersByName(@RequestParam String clientName) {
        return entitiesService.getClientOrdersByName(clientName);
    }

    @GetMapping(value = "/rest/listClientProducts", params = "clientId")
    public List<Product> getProductsByClientId(@RequestParam Long clientId) {
        return entitiesService.getProductsByClientId(clientId);
    }

    @GetMapping(value = "/rest/topPopularProducts", params = "top")
    public List<Product> getTopPopularProducts(@RequestParam Integer top) {
        return entitiesService.getTopPopularProducts(top);
    }
}
