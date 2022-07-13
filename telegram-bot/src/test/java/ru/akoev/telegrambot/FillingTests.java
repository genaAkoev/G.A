package ru.akoev.telegrambot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.akoev.telegrambot.entities.*;
import ru.akoev.telegrambot.repositories.*;

import java.util.Arrays;

@SpringBootTest
public class FillingTests {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientOrderRepository clientOrderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderProductRepository orderProductRepository;


    @Test
    public void createClients(){
        Client henryOsbornClient = new Client();
        henryOsbornClient.setExternalId(1L);
        henryOsbornClient.setFullName("Henry Osborn");
        henryOsbornClient.setPhoneNumber("+1(432)54-32-12");
        henryOsbornClient.setAddress("2719 Grant Street Chandler, TX 75758");

        Client anthonyRobbinsClient = new Client();
        anthonyRobbinsClient.setExternalId(2L);
        anthonyRobbinsClient.setFullName("Anthony Robbins");
        anthonyRobbinsClient.setPhoneNumber("+1(419)79-91-29");
        anthonyRobbinsClient.setAddress("1897 Hill Street Bowling Green, OH 43402");

        Client kevinJacksonClient = new Client();
        kevinJacksonClient.setExternalId(3L);
        kevinJacksonClient.setFullName("Kevin Jackson");
        kevinJacksonClient.setPhoneNumber("502-329-0525");
        kevinJacksonClient.setAddress("1134 Radford Street Louisville, KY 40242");

        clientRepository.saveAll(Arrays.asList(henryOsbornClient, anthonyRobbinsClient, kevinJacksonClient));
    }

    @Test
    public void createMainCategories(){
        // NOTICE: Constructor params order: [name: String, parent: Category]
        Category pizza = new Category("Пицца", null);
        Category rolls = new Category("Роллы", null);
        Category burgers = new Category("Бургеры", null);
        Category drinks = new Category("Напитки", null);

        categoryRepository.saveAll(Arrays.asList(pizza, rolls, burgers, drinks));
    }

    @Test
    public void createSubCategories(){
        // NOTICE: Constructor params order: [name: String, parent: Category]
        // Подкатегории "Роллы"
        Category category;
        category = categoryRepository.findByName("Роллы");
        Category classicRolls = new Category("Классические роллы", category);
        Category backedRolls = new Category("Запеченные роллы", category);
        Category sweetRolls = new Category("Сладкие роллы", category);
        Category sets = new Category("Наборы", category);

        // Подкатегории "Бургеры"
        category = categoryRepository.findByName("Бургеры");
        Category classicBurgers = new Category("Классические бургеры", category);
        Category spicyBurgers = new Category("Острые бургеры", category);

        // Подкатегории "Напитки"
        category = categoryRepository.findByName("Напитки");
        Category carbonatedDrinks = new Category("Газированные напитки", category);
        Category energyDrinks = new Category("Энергетические напитки", category);
        Category juices = new Category("Соки", category);
        Category other = new Category("Другие", category);

        categoryRepository.saveAll(Arrays.asList(classicRolls, backedRolls, sweetRolls, sets,
                classicBurgers, spicyBurgers, carbonatedDrinks, energyDrinks, juices, other));
    }

    @Test
    public void addProducts(){

        // Товары категории "Пицца"
        Product salmonPizza = new Product();
        salmonPizza.setCategory(categoryRepository.findByName("Пицца"));
        salmonPizza.setName("Пицца с лососем");
        salmonPizza.setDescription("Филе лосося, сыры моцарелла и креметта, соусы Песто и сливочный, томаты черри");
        salmonPizza.setPrice(549.0);

        Product asianChickPizza = new Product();
        asianChickPizza.setCategory(categoryRepository.findByName("Пицца"));
        asianChickPizza.setName("Пицца \"Азиатский цыпленок\"");
        asianChickPizza.setDescription("Копченый цыпленок, моцарелла, соусы томатный и кисло-сладкий");
        asianChickPizza.setPrice(389.0);

        Product caesarPizza = new Product();
        caesarPizza.setCategory(categoryRepository.findByName("Пицца"));
        caesarPizza.setName("Пицца \"Цезарь\"");
        caesarPizza.setDescription("Отборные креветки, сыры моцарелла и пармезан, томаты черри, соусы цезарь и сливочный");
        caesarPizza.setPrice(549.0);

        Product italianPizza = new Product();
        italianPizza.setCategory(categoryRepository.findByName("Пицца"));
        italianPizza.setName("Итальянская пицца");
        italianPizza.setDescription("Запеченная пепперони, шампиньоны, моцарелла, маслины, томаты и итальянские травы");
        italianPizza.setPrice(439.0);

        Product carbonaraPizza = new Product();
        carbonaraPizza.setCategory(categoryRepository.findByName("Пицца"));
        carbonaraPizza.setName("Пицца \"Карбонара\"");
        carbonaraPizza.setDescription("Бекон, моцарелла, томаты, креметта, сыр пармезан, лук и чеснок");
        carbonaraPizza.setPrice(499.0);



        // Товары категории "Роллы"
        // Подкатегория "Классические роллы"
        Product macRolls = new Product();
        macRolls.setCategory(categoryRepository.findByName("Классические роллы"));
        macRolls.setName("Мак-роллы");
        macRolls.setDescription("500г риса, 150г тунца, 150г лосося и 1 огурец");
        macRolls.setPrice(220.0);

        Product philadelphiaRolls = new Product();
        philadelphiaRolls.setCategory(categoryRepository.findByName("Классические роллы"));
        philadelphiaRolls.setName("Филадельфия роллы");
        philadelphiaRolls.setDescription("500г риса, 150г красной рыбы, 100г икры тобико, 135г сыра Филадельфия и 1 крупный огурец");
        philadelphiaRolls.setPrice(210.0);

        Product californiaRolls = new Product();
        californiaRolls.setCategory(categoryRepository.findByName("Классические роллы"));
        californiaRolls.setName("Калифорния роллы");
        californiaRolls.setDescription("450г риса, 250г мяса краба, 120г японского майонеза, 125г икры тобико и 1 огурец");
        californiaRolls.setPrice(175.0);

        Product inYanRolls = new Product();
        inYanRolls.setCategory(categoryRepository.findByName("Классические роллы"));
        inYanRolls.setName("Инь-янь роллы");
        inYanRolls.setDescription("550г риса, 230г куриного филе, 150г сливочного сыра, 200г кунжута и 1 огурец");
        inYanRolls.setPrice(160.0);

        // Подкатегория "Запеченные роллы"
        Product chickenTempura = new Product();
        chickenTempura.setCategory(categoryRepository.findByName("Запеченные роллы"));
        chickenTempura.setName("Темпура с курицей");
        chickenTempura.setDescription("450г риса, 180г крабового мяса, 240г лосося, 120г огурцов");
        chickenTempura.setPrice(225.0);

        Product musselsTempura = new Product();
        musselsTempura.setCategory(categoryRepository.findByName("Запеченные роллы"));
        musselsTempura.setName("Темпура с мидиями");
        musselsTempura.setDescription("420г риса, 150г творожного сыра, 300г мидий, 3 яйца, 3ст.л. молока");
        musselsTempura.setPrice(240.0);

        Product tofu = new Product();
        tofu.setCategory(categoryRepository.findByName("Запеченные роллы"));
        tofu.setName("Тофу");
        tofu.setDescription("300г риса, 400г тофу, 120г майонеза, 40г соус чили, 200мл соевого соуса");
        tofu.setPrice(235.0);


        // Подкатегория "Сладкие роллы"
        Product bountyRolls = new Product();
        bountyRolls.setCategory(categoryRepository.findByName("Сладкие роллы"));
        bountyRolls.setName("Баунти роллы");
        bountyRolls.setDescription("6шт блинов, 280г сливочного сыра,0.5 шоколад молочный, 0.5 шоколад темный, 1шт манго");
        bountyRolls.setPrice(210.0);

        Product marmaladeRolls = new Product();
        marmaladeRolls.setCategory(categoryRepository.findByName("Сладкие роллы"));
        marmaladeRolls.setName("Мармеладные роллы");
        marmaladeRolls.setDescription("6шт тонких блинов, 180г сыр Филадельфия, 80г сахарной пудры, 100г фруктового мармелада");
        marmaladeRolls.setPrice(230.0);

        Product fruitRolls = new Product();
        fruitRolls.setCategory(categoryRepository.findByName("Сладкие роллы"));
        fruitRolls.setName("Фруктовые роллы");
        fruitRolls.setDescription("100г банана, 120г вишни, 80г киви, 90г ананаса, 100г клубники, 75г яблока");
        fruitRolls.setPrice(215.0);

        Product creamRolls = new Product();
        creamRolls.setCategory(categoryRepository.findByName("Сладкие роллы"));
        creamRolls.setName("Сливочные роллы");
        creamRolls.setDescription("4порц. тонкого сладкого омлета, 800г сливочного сыра, 90г сахарной пудры, 0.25ст.л. клубничного сиропа");
        creamRolls.setPrice(180.0);


        // Подкатегория "Наборы"
        Product weekendSet = new Product();
        weekendSet.setCategory(categoryRepository.findByName("Наборы"));
        weekendSet.setName("Сет \"Вечеринка\"");
        weekendSet.setDescription("Вес: 800г, Состав: Темпура с мидиями, Инь-Янь и Калифорния");
        weekendSet.setPrice(699.0);

        Product bombasticSet = new Product();
        bombasticSet.setCategory(categoryRepository.findByName("Наборы"));
        bombasticSet.setName("Сет \"Бомбический\"");
        bombasticSet.setDescription("Вес: 1000г, Состав: Тофу, Мак-роллы и Темпура с курицей");
        bombasticSet.setPrice(1090.0);

        Product sweetGourmetSet = new Product();
        sweetGourmetSet.setCategory(categoryRepository.findByName("Наборы"));
        sweetGourmetSet.setName("Сет \"Сладкий гурман\"");
        sweetGourmetSet.setDescription("Вес: 1450, Состав: Баунти, Мармеладные, Фруктовые и Сливочные");
        sweetGourmetSet.setPrice(1110.0);


        // Товары категории "Бургеры"
        // Подкатегория "Классические бургеры"
        Product fishBurger = new Product();
        fishBurger.setCategory(categoryRepository.findByName("Классические бургеры"));
        fishBurger.setName("Бургер с рыбой");
        fishBurger.setDescription("Рыба в кляре с маринованным огурчиком, листом салата под соусом Терияки в пшеничной булочке");
        fishBurger.setPrice(259.0);

        Product porkBurger = new Product();
        porkBurger.setCategory(categoryRepository.findByName("Классические бургеры"));
        porkBurger.setName("Бургер со свининой");
        porkBurger.setDescription("Свинина жареная на гриле с маринованным огурчиком, листом салата и сыром чеддер, под фирменным соусом в пшеничной булочке");
        porkBurger.setPrice(259.0);

        Product vealBurger = new Product();
        vealBurger.setCategory(categoryRepository.findByName("Классические бургеры"));
        vealBurger.setName("Бургер с телятиной");
        vealBurger.setDescription("Телятина жареная на гриле со свежим томатом, листом салата под пикантным соусом Свит-Чили в пшеничной булочке");
        vealBurger.setPrice(329.0);

        Product chickenBurger = new Product();
        chickenBurger.setCategory(categoryRepository.findByName("Классические бургеры"));
        chickenBurger.setName("Бургер с курицей");
        chickenBurger.setDescription("Куриное филе жареное на гриле со свежим томатом, листом салата и сыром чеддер под Медово-Горчичным соусом в пшеничной булочке.");
        chickenBurger.setPrice(249.0);


        // Подкатегория "Острые бургеры"
        Product bigTastyBurger = new Product();
        bigTastyBurger.setCategory(categoryRepository.findByName("Острые бургеры"));
        bigTastyBurger.setName("Бургер \"Биг Тейсти\"");
        bigTastyBurger.setDescription("Острый с бифштексом из 100% рубленой говядины, сыром Эмменталь, пикантным соусом Чураско и знаменитым соусом с дымком");
        bigTastyBurger.setPrice(259.0);

        Product hamBurger = new Product();
        hamBurger.setCategory(categoryRepository.findByName("Острые бургеры"));
        hamBurger.setName("Бургер \"ГАМ\"");
        hamBurger.setDescription("Сочная куриная котлета в хрустящей панировке, зеленые листья салата Айсберг и новый пикантный острый соус.");
        hamBurger.setPrice(115.0);

        Product cheeseBurger = new Product();
        cheeseBurger.setCategory(categoryRepository.findByName("Острые бургеры"));
        cheeseBurger.setName("Бургер \"ЧИЗ\"");
        cheeseBurger.setDescription("Рубленый бифштекс из натуральной говядины, с ломтиком сыра «Чеддер», острым кетчупом, горчицей, перцом чили, луком и маринованными огурчиками");
        cheeseBurger.setPrice(168.0);


        // Товары категории "Напитки"
        // Подкатегория "Газированные напитки"
        Product cocaCola = new Product();
        cocaCola.setCategory(categoryRepository.findByName("Газированные напитки"));
        cocaCola.setName("Coca-cola");
        cocaCola.setDescription("Объем: 2 л, Энергетическая ценность: 42 ккал/100г, Углеводы: 11 г/100г");
        cocaCola.setPrice(74.0);

        Product sprite = new Product();
        sprite.setCategory(categoryRepository.findByName("Газированные напитки"));
        sprite.setName("Sprite");
        sprite.setDescription("Объем: 1.5 л, Энергетическая ценность: 10 ккал/100г, Углеводы: 2 г/100г");
        sprite.setPrice(119.0);

        Product fanta = new Product();
        fanta.setCategory(categoryRepository.findByName("Газированные напитки"));
        fanta.setName("Fanta");
        fanta.setDescription("Объем: 1.5 л, Энергетическая ценность: 33 ккал/100г, Углеводы: 8 г/100г");
        fanta.setPrice(89.0);

        Product pepsi = new Product();
        pepsi.setCategory(categoryRepository.findByName("Газированные напитки"));
        pepsi.setName("Pepsi");
        pepsi.setDescription("Объем: 2 л, Энергетическая ценность: 45 ккал/100г, Углеводы: 12 г/100г");
        pepsi.setPrice(69.0);

        Product mirinda = new Product();
        mirinda.setCategory(categoryRepository.findByName("Газированные напитки"));
        mirinda.setName("Mirinda");
        mirinda.setDescription("Объем: 1.5 л, Энергетическая ценность: 27 ккал/100г, Углеводы: 7 г/100г");
        mirinda.setPrice(80.0);

        Product sevenUp = new Product();
        sevenUp.setCategory(categoryRepository.findByName("Газированные напитки"));
        sevenUp.setName("7Up");
        sevenUp.setDescription("Объем: 2 л, Энергетическая ценность: 30 ккал/100г, Углеводы: 8 г/100г");
        sevenUp.setPrice(100.0);


        // Подкатегория "Энергетические напитки"
        Product originalBurn = new Product();
        originalBurn.setCategory(categoryRepository.findByName("Энергетические напитки"));
        originalBurn.setName("Burn оригинал");
        originalBurn.setDescription("Объем: 449 мл, Пищевая ценность: 55 ккал/100г");
        originalBurn.setPrice(85.0);

        Product appleKiwiBurn = new Product();
        appleKiwiBurn.setCategory(categoryRepository.findByName("Энергетические напитки"));
        appleKiwiBurn.setName("Burn яблоко-киви");
        appleKiwiBurn.setDescription("Объем: 449 мл, Пищевая ценность: 50 ккал/100г");
        appleKiwiBurn.setPrice(106.0);

        Product adrenaline = new Product();
        adrenaline.setCategory(categoryRepository.findByName("Энергетические напитки"));
        adrenaline.setName("Adrenaline");
        adrenaline.setDescription("Объем: 250 мл, Пищевая ценность: 52 ккал/100г");
        adrenaline.setPrice(74.0);


        // Подкатегория "Соки"
        Product rich = new Product();
        rich.setCategory(categoryRepository.findByName("Соки"));
        rich.setName("Rich");
        rich.setDescription("Объем: 1 л, Вкус: Ананас, Энергетическая ценность: 52 ккал/100г");
        rich.setPrice(126.0);

        Product dobriy = new Product();
        dobriy.setCategory(categoryRepository.findByName("Соки"));
        dobriy.setName("Добрый");
        dobriy.setDescription("Объем: 2 л, Вкус: Яблоко, Энергетическая ценность: 46 ккал/100г");
        dobriy.setPrice(109.0);

        Product j7 = new Product();
        j7.setCategory(categoryRepository.findByName("Соки"));
        j7.setName("J-7");
        j7.setDescription("Объем: 0.97 л, Вкус: Апельсин, Энергетическая ценность: 44 ккал/100г");
        j7.setPrice(85.0);


        // Подкатегория "Другие"
        Product coffee = new Product();
        coffee.setCategory(categoryRepository.findByName("Другие"));
        coffee.setName("Кофе");
        coffee.setDescription("Доппио");
        coffee.setPrice(110.0);

        Product beer = new Product();
        beer.setCategory(categoryRepository.findByName("Другие"));
        beer.setName("Пиво");
        beer.setDescription("Светлое, пастеризованное. 4,7% алкоголя");
        beer.setPrice(125.0);

        Product stillWater = new Product();
        stillWater.setCategory(categoryRepository.findByName("Другие"));
        stillWater.setName("Святой источник");
        stillWater.setDescription("Вода, негазированная");
        stillWater.setPrice(60.0);

        productRepository.saveAll(Arrays.asList(salmonPizza, asianChickPizza, caesarPizza, italianPizza, carbonaraPizza,
                macRolls, philadelphiaRolls, californiaRolls, inYanRolls, chickenTempura, musselsTempura, tofu,
                bountyRolls, marmaladeRolls, fruitRolls, creamRolls, weekendSet, bombasticSet, sweetGourmetSet,
                bigTastyBurger, hamBurger, cheeseBurger, fishBurger, porkBurger, vealBurger, chickenBurger,
                cocaCola, sprite, fanta, pepsi, mirinda, sevenUp, originalBurn, appleKiwiBurn, adrenaline, rich,
                dobriy, j7, coffee, beer, stillWater));

    }

    @Test
    public void createClientOrdersAndOrderProducts(){
        // ЗАКАЗЫ
        // Заказ 1 от Генри Осборна
        ClientOrder henryOsbornOrder = new ClientOrder();
        henryOsbornOrder.setClient(clientRepository.findByFullName("Henry Osborn"));
        henryOsbornOrder.setStatus(100);
        henryOsbornOrder.setTotal(938.0);

        // Заказ 1 от Энтони Роббинса
        ClientOrder anthonyRobbinsOrder = new ClientOrder();
        anthonyRobbinsOrder.setClient(clientRepository.findByFullName("Anthony Robbins"));
        anthonyRobbinsOrder.setStatus(100);
        anthonyRobbinsOrder.setTotal(460.0);

        // Заказ 1 от Кевина Джексона
        ClientOrder kevinJacksonOrder1 = new ClientOrder();
        kevinJacksonOrder1.setClient(clientRepository.findByFullName("Kevin Jackson"));
        kevinJacksonOrder1.setStatus(100);
        kevinJacksonOrder1.setTotal(1509.0);

        // Заказ 2 от Кевина Джексона
        ClientOrder kevinJacksonOrder2 = new ClientOrder();
        kevinJacksonOrder2.setClient(clientRepository.findByFullName("Kevin Jackson"));
        kevinJacksonOrder2.setStatus(100);
        kevinJacksonOrder2.setTotal(460.0);

        clientOrderRepository.saveAll(Arrays.asList(henryOsbornOrder, anthonyRobbinsOrder,
                kevinJacksonOrder1, kevinJacksonOrder2));


        // ПОЗИЦИИ В ЗАКАЗЕ
        // Позиции заказа 1 от Генри Осборна
        OrderProduct henryOsbornOrder1Product1 = new OrderProduct();
        henryOsbornOrder1Product1.setClientOrder(henryOsbornOrder);
        henryOsbornOrder1Product1.setCountProduct(1);
        henryOsbornOrder1Product1.setProduct(productRepository.findProductByName("Пицца с лососем"));

        OrderProduct henryOsbornOrder1Product2 = new OrderProduct();
        henryOsbornOrder1Product2.setClientOrder(henryOsbornOrder);
        henryOsbornOrder1Product2.setCountProduct(1);
        henryOsbornOrder1Product2.setProduct(productRepository.findProductByName("Пицца \"Азиатский цыпленок\""));


        //Позиции заказа 1 от Энтони Роббинса
        OrderProduct anthonyRobbinsOrder1Product1 = new OrderProduct();
        anthonyRobbinsOrder1Product1.setClientOrder(anthonyRobbinsOrder);
        anthonyRobbinsOrder1Product1.setCountProduct(4);
        anthonyRobbinsOrder1Product1.setProduct(productRepository.findProductByName("Бургер \"ГАМ\""));


        // Позиции заказа 1 от Кевина Джексона
        OrderProduct kevinJacksonOrder1Product1 = new OrderProduct();
        kevinJacksonOrder1Product1.setClientOrder(kevinJacksonOrder1);
        kevinJacksonOrder1Product1.setCountProduct(1);
        kevinJacksonOrder1Product1.setProduct(productRepository.findProductByName("Пицца \"Карбонара\""));

        OrderProduct kevinJacksonOrder1Product2 = new OrderProduct();
        kevinJacksonOrder1Product2.setClientOrder(kevinJacksonOrder1);
        kevinJacksonOrder1Product2.setCountProduct(1);
        kevinJacksonOrder1Product2.setProduct(productRepository.findProductByName("Мак-роллы"));

        OrderProduct kevinJacksonOrder1Product3 = new OrderProduct();
        kevinJacksonOrder1Product3.setClientOrder(kevinJacksonOrder1);
        kevinJacksonOrder1Product3.setCountProduct(1);
        kevinJacksonOrder1Product3.setProduct(productRepository.findProductByName("Филадельфия роллы"));

        OrderProduct kevinJacksonOrder1Product4 = new OrderProduct();
        kevinJacksonOrder1Product4.setClientOrder(kevinJacksonOrder1);
        kevinJacksonOrder1Product4.setCountProduct(1);
        kevinJacksonOrder1Product4.setProduct(productRepository.findProductByName("Калифорния роллы"));

        OrderProduct kevinJacksonOrder1Product5 = new OrderProduct();
        kevinJacksonOrder1Product5.setClientOrder(kevinJacksonOrder1);
        kevinJacksonOrder1Product5.setCountProduct(1);
        kevinJacksonOrder1Product5.setProduct(productRepository.findProductByName("Инь-янь роллы"));

        OrderProduct kevinJacksonOrder1Product6 = new OrderProduct();
        kevinJacksonOrder1Product6.setClientOrder(kevinJacksonOrder1);
        kevinJacksonOrder1Product6.setCountProduct(1);
        kevinJacksonOrder1Product6.setProduct(productRepository.findProductByName("Темпура с курицей"));

        OrderProduct kevinJacksonOrder1Product7 = new OrderProduct();
        kevinJacksonOrder1Product7.setClientOrder(kevinJacksonOrder1);
        kevinJacksonOrder1Product7.setCountProduct(1);
        kevinJacksonOrder1Product7.setProduct(productRepository.findProductByName("Темпура с мидиями"));

        OrderProduct kevinJacksonOrder1Product8 = new OrderProduct();
        kevinJacksonOrder1Product8.setClientOrder(kevinJacksonOrder1);
        kevinJacksonOrder1Product8.setCountProduct(1);
        kevinJacksonOrder1Product8.setProduct(productRepository.findProductByName("Тофу"));

        OrderProduct kevinJacksonOrder1Product9 = new OrderProduct();
        kevinJacksonOrder1Product9.setClientOrder(kevinJacksonOrder1);
        kevinJacksonOrder1Product9.setCountProduct(1);
        kevinJacksonOrder1Product9.setProduct(productRepository.findProductByName("Coca-cola"));


        // Позиции заказа 2 от Кевина Джексона
        OrderProduct kevinJacksonOrder2Product1 = new OrderProduct();
        kevinJacksonOrder2Product1.setClientOrder(kevinJacksonOrder2);
        kevinJacksonOrder2Product1.setCountProduct(1);
        kevinJacksonOrder2Product1.setProduct(productRepository.findProductByName("Темпура с мидиями"));

        OrderProduct kevinJacksonOrder2Product2 = new OrderProduct();
        kevinJacksonOrder2Product2.setClientOrder(kevinJacksonOrder2);
        kevinJacksonOrder2Product2.setCountProduct(1);
        kevinJacksonOrder2Product2.setProduct(productRepository.findProductByName("Мак-роллы"));

        orderProductRepository.saveAll(Arrays.asList(henryOsbornOrder1Product1, henryOsbornOrder1Product2,
                anthonyRobbinsOrder1Product1, kevinJacksonOrder1Product1, kevinJacksonOrder1Product2,
                kevinJacksonOrder1Product3, kevinJacksonOrder1Product4, kevinJacksonOrder1Product5,
                kevinJacksonOrder1Product6, kevinJacksonOrder1Product7, kevinJacksonOrder1Product8,
                kevinJacksonOrder1Product9, kevinJacksonOrder2Product1, kevinJacksonOrder2Product2));
    }


}
