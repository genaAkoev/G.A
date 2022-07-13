package ru.akoev.telegrambot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.akoev.telegrambot.entities.Client;
import ru.akoev.telegrambot.entities.ClientOrder;
import ru.akoev.telegrambot.entities.Product;
import ru.akoev.telegrambot.repositories.ClientOrderRepository;
import ru.akoev.telegrambot.repositories.ClientRepository;
import ru.akoev.telegrambot.repositories.ProductRepository;
import java.util.List;

@Service
@Transactional
public class EntitiesServiceImpl implements EntitiesService{
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientOrderRepository clientOrderRepository;

    @Autowired
    private ProductRepository productRepository;


    public EntitiesServiceImpl(ClientRepository clientRepository,
                               ClientOrderRepository clientOrderRepository,
                               ProductRepository productRepository) {
        this.clientRepository = clientRepository;
        this.clientOrderRepository = clientOrderRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Client getClientByName(String name) {
        return clientRepository.findByFullName(name);
    }

    @Override
    public List<ClientOrder> getOrdersByStatus(Integer status) {
        return clientOrderRepository.findClientOrdersByStatus(status);
    }

    @Override
    public Product getProductByName(String name) {
        return productRepository.findProductByName(name);
    }

    @Override
    public List<Product> getProductsByCategoryId(Long id) {
        return productRepository.getByCategoryId(id);
    }

    @Override
    public List<ClientOrder> getClientOrdersByName(String name) {
        return clientOrderRepository.findClientOrdersByName(name);
    }

    @Override
    public List<Product> getProductsByClientId(Long id) {
        return productRepository.getAllByClientId(id);
    }

    @Override
    public List<Product> getTopPopularProducts(Integer top) {
        List<Product> productList = productRepository.getTopPopular();
        return productList.subList(0, top);
    }
}
