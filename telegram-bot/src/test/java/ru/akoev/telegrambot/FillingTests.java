package ru.akoev.telegrambot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.akoev.telegrambot.entities.Category;
import ru.akoev.telegrambot.entities.Client;
import ru.akoev.telegrambot.entities.Product;
import ru.akoev.telegrambot.repositories.CategoryRepository;
import ru.akoev.telegrambot.repositories.ClientRepository;
import ru.akoev.telegrambot.repositories.ProductRepository;
import java.util.Arrays;

@SpringBootTest
public class FillingTests {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void createClients(){
        Client client1 = new Client();
        client1.setExternalId(1L);
        client1.setFullName("FullName1");
        client1.setPhoneNumber("Phone1");
        client1.setAddress("Address1");

        Client client2 = new Client();
        client2.setExternalId(2L);
        client2.setFullName("FullName2");
        client2.setPhoneNumber("Phone2");
        client2.setAddress("Address2");

        Client client3 = new Client();
        client3.setExternalId(3L);
        client3.setFullName("FullName3");
        client3.setPhoneNumber("Phone3");
        client3.setAddress("Address3");

        clientRepository.saveAll(Arrays.asList(client1, client2, client3));
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
        Category category = new Category();
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
}
