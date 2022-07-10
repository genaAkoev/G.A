package ru.akoev.telegrambot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.akoev.telegrambot.Entities.Category;
import ru.akoev.telegrambot.Entities.Client;
import ru.akoev.telegrambot.Entities.Product;
import ru.akoev.telegrambot.Repositories.CategoryRepository;
import ru.akoev.telegrambot.Repositories.ClientRepository;
import ru.akoev.telegrambot.Repositories.ProductRepository;
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
        Category classic_rolls = new Category("Классические роллы", category);
        Category backed_rolls = new Category("Запеченные роллы", category);
        Category sweet_rolls = new Category("Сладкие роллы", category);
        Category sets = new Category("Наборы", category);

        // Подкатегории "Бургеры"
        category = categoryRepository.findByName("Бургеры");
        Category classic_burgers = new Category("Классические бургеры", category);
        Category spicy_burgers = new Category("Острые бургеры", category);

        // Подкатегории "Напитки"
        category = categoryRepository.findByName("Напитки");
        Category carbonated_drinks = new Category("Газированные напитки", category);
        Category energy_drinks = new Category("Энергетические напитки", category);
        Category juices = new Category("Соки", category);
        Category other = new Category("Другие", category);

        categoryRepository.saveAll(Arrays.asList(classic_rolls, backed_rolls, sweet_rolls, sets,
                classic_burgers, spicy_burgers, carbonated_drinks, energy_drinks, juices, other));
    }

    @Test
    public void addProducts(){

        // Товары категории "Пицца"
        Product salmon_pizza = new Product();
        salmon_pizza.setCategory(categoryRepository.findByName("Пицца"));
        salmon_pizza.setName("Пицца с лососем");
        salmon_pizza.setDescription("Филе лосося, сыры моцарелла и креметта, соусы Песто и сливочный, томаты черри");
        salmon_pizza.setPrice(549.0);

        Product asian_chick_pizza = new Product();
        asian_chick_pizza.setCategory(categoryRepository.findByName("Пицца"));
        asian_chick_pizza.setName("Пицца \"Азиатский цыпленок\"");
        asian_chick_pizza.setDescription("Копченый цыпленок, моцарелла, соусы томатный и кисло-сладкий");
        asian_chick_pizza.setPrice(389.0);

        Product caesar_pizza = new Product();
        caesar_pizza.setCategory(categoryRepository.findByName("Пицца"));
        caesar_pizza.setName("Пицца \"Цезарь\"");
        caesar_pizza.setDescription("Отборные креветки, сыры моцарелла и пармезан, томаты черри, соусы цезарь и сливочный");
        caesar_pizza.setPrice(549.0);

        Product italian_pizza = new Product();
        italian_pizza.setCategory(categoryRepository.findByName("Пицца"));
        italian_pizza.setName("Итальянская пицца");
        italian_pizza.setDescription("Запеченная пепперони, шампиньоны, моцарелла, маслины, томаты и итальянские травы");
        italian_pizza.setPrice(439.0);

        Product carbonara_pizza = new Product();
        carbonara_pizza.setCategory(categoryRepository.findByName("Пицца"));
        carbonara_pizza.setName("Пицца \"Карбонара\"");
        carbonara_pizza.setDescription("Бекон, моцарелла, томаты, креметта, сыр пармезан, лук и чеснок");
        carbonara_pizza.setPrice(499.0);



        // Товары категории "Роллы"
        // Подкатегория "Классические роллы"
        Product mac_rolls = new Product();
        mac_rolls.setCategory(categoryRepository.findByName("Классические роллы"));
        mac_rolls.setName("Мак-роллы");
        mac_rolls.setDescription("500г риса, 150г тунца, 150г лосося и 1 огурец");
        mac_rolls.setPrice(220.0);

        Product philadelphia_rolls = new Product();
        philadelphia_rolls.setCategory(categoryRepository.findByName("Классические роллы"));
        philadelphia_rolls.setName("Филадельфия роллы");
        philadelphia_rolls.setDescription("500г риса, 150г красной рыбы, 100г икры тобико, 135г сыра Филадельфия и 1 крупный огурец");
        philadelphia_rolls.setPrice(210.0);

        Product california_rolls = new Product();
        california_rolls.setCategory(categoryRepository.findByName("Классические роллы"));
        california_rolls.setName("Калифорния роллы");
        california_rolls.setDescription("450г риса, 250г мяса краба, 120г японского майонеза, 125г икры тобико и 1 огурец");
        california_rolls.setPrice(175.0);

        Product in_yan_rolls = new Product();
        in_yan_rolls.setCategory(categoryRepository.findByName("Классические роллы"));
        in_yan_rolls.setName("Инь-янь роллы");
        in_yan_rolls.setDescription("550г риса, 230г куриного филе, 150г сливочного сыра, 200г кунжута и 1 огурец");
        in_yan_rolls.setPrice(160.0);

        // Подкатегория "Запеченные роллы"
        Product chicken_tempura = new Product();
        chicken_tempura.setCategory(categoryRepository.findByName("Запеченные роллы"));
        chicken_tempura.setName("Темпура с курицей");
        chicken_tempura.setDescription("450г риса, 180г крабового мяса, 240г лосося, 120г огурцов");
        chicken_tempura.setPrice(225.0);

        Product mussels_tempura = new Product();
        mussels_tempura.setCategory(categoryRepository.findByName("Запеченные роллы"));
        mussels_tempura.setName("Темпура с мидиями");
        mussels_tempura.setDescription("420г риса, 150г творожного сыра, 300г мидий, 3 яйца, 3ст.л. молока");
        mussels_tempura.setPrice(240.0);

        Product tofu = new Product();
        tofu.setCategory(categoryRepository.findByName("Запеченные роллы"));
        tofu.setName("Тофу");
        tofu.setDescription("300г риса, 400г тофу, 120г майонеза, 40г соус чили, 200мл соевого соуса");
        tofu.setPrice(235.0);


        // Подкатегория "Сладкие роллы"
        Product bounty_rolls = new Product();
        bounty_rolls.setCategory(categoryRepository.findByName("Сладкие роллы"));
        bounty_rolls.setName("Баунти роллы");
        bounty_rolls.setDescription("6шт блинов, 280г сливочного сыра,0.5 шоколад молочный, 0.5 шоколад темный, 1шт манго");
        bounty_rolls.setPrice(210.0);

        Product marmalade_rolls = new Product();
        marmalade_rolls.setCategory(categoryRepository.findByName("Сладкие роллы"));
        marmalade_rolls.setName("Мармеладные роллы");
        marmalade_rolls.setDescription("6шт тонких блинов, 180г сыр Филадельфия, 80г сахарной пудры, 100г фруктового мармелада");
        marmalade_rolls.setPrice(230.0);

        Product fruit_rolls = new Product();
        fruit_rolls.setCategory(categoryRepository.findByName("Сладкие роллы"));
        fruit_rolls.setName("Фруктовые роллы");
        fruit_rolls.setDescription("100г банана, 120г вишни, 80г киви, 90г ананаса, 100г клубники, 75г яблока");
        fruit_rolls.setPrice(215.0);

        Product cream_rolls = new Product();
        cream_rolls.setCategory(categoryRepository.findByName("Сладкие роллы"));
        cream_rolls.setName("Сливочные роллы");
        cream_rolls.setDescription("4порц. тонкого сладкого омлета, 800г сливочного сыра, 90г сахарной пудры, 0.25ст.л. клубничного сиропа");
        cream_rolls.setPrice(180.0);


        // Подкатегория "Наборы"
        Product set_weekend = new Product();
        set_weekend.setCategory(categoryRepository.findByName("Наборы"));
        set_weekend.setName("Сет \"Вечеринка\"");
        set_weekend.setDescription("Вес: 800г, Состав: Темпура с мидиями, Инь-Янь и Калифорния");
        set_weekend.setPrice(699.0);

        Product set_bombastic = new Product();
        set_bombastic.setCategory(categoryRepository.findByName("Наборы"));
        set_bombastic.setName("Сет \"Бомбический\"");
        set_bombastic.setDescription("Вес: 1000г, Состав: Тофу, Мак-роллы и Темпура с курицей");
        set_bombastic.setPrice(1090.0);

        Product set_sweet_gourmet = new Product();
        set_sweet_gourmet.setCategory(categoryRepository.findByName("Наборы"));
        set_sweet_gourmet.setName("Сет \"Сладкий гурман\"");
        set_sweet_gourmet.setDescription("Вес: 1450, Состав: Баунти, Мармеладные, Фруктовые и Сливочные");
        set_sweet_gourmet.setPrice(1110.0);


        // Товары категории "Бургеры"
        // Подкатегория "Классические бургеры"
        Product burger_fish = new Product();
        burger_fish.setCategory(categoryRepository.findByName("Классические бургеры"));
        burger_fish.setName("Бургер-рыба");
        burger_fish.setDescription("Рыба в кляре с маринованным огурчиком, листом салата под соусом Терияки в пшеничной булочке");
        burger_fish.setPrice(259.0);

        Product burger_pork = new Product();
        burger_pork.setCategory(categoryRepository.findByName("Классические бургеры"));
        burger_pork.setName("Бургер-свинина");
        burger_pork.setDescription("Свинина жареная на гриле с маринованным огурчиком, листом салата и сыром чеддер, под фирменным соусом в пшеничной булочке");
        burger_pork.setPrice(259.0);

        Product burger_veal = new Product();
        burger_veal.setCategory(categoryRepository.findByName("Классические бургеры"));
        burger_veal.setName("Бургер-телятина");
        burger_veal.setDescription("Телятина жареная на гриле со свежим томатом, листом салата под пикантным соусом Свит-Чили в пшеничной булочке");
        burger_veal.setPrice(329.0);

        Product burger_chicken = new Product();
        burger_chicken.setCategory(categoryRepository.findByName("Классические бургеры"));
        burger_chicken.setName("Бургер-курица");
        burger_chicken.setDescription("Куриное филе жареное на гриле со свежим томатом, листом салата и сыром чеддер под Медово-Горчичным соусом в пшеничной булочке.");
        burger_chicken.setPrice(249.0);


        // Подкатегория "Острые бургеры"
        Product burger_big_tasty = new Product();
        burger_big_tasty.setCategory(categoryRepository.findByName("Острые бургеры"));
        burger_big_tasty.setName("Бургер \"Биг Тейсти\"");
        burger_big_tasty.setDescription("Острый с бифштексом из 100% рубленой говядины, сыром Эмменталь, пикантным соусом Чураско и знаменитым соусом с дымком");
        burger_big_tasty.setPrice(259.0);

        Product burger_ham = new Product();
        burger_ham.setCategory(categoryRepository.findByName("Острые бургеры"));
        burger_ham.setName("Бургер \"ГАМ\"");
        burger_ham.setDescription("Сочная куриная котлета в хрустящей панировке, зеленые листья салата Айсберг и новый пикантный острый соус.");
        burger_ham.setPrice(115.0);

        Product burger_cheese = new Product();
        burger_cheese.setCategory(categoryRepository.findByName("Острые бургеры"));
        burger_cheese.setName("Бургер \"ЧИЗ\"");
        burger_cheese.setDescription("Рубленый бифштекс из натуральной говядины, с ломтиком сыра «Чеддер», острым кетчупом, горчицей, перцом чили, луком и маринованными огурчиками");
        burger_cheese.setPrice(168.0);


        // Товары категории "Напитки"
        // Подкатегория "Газированные напитки"
        Product coca_cola = new Product();
        coca_cola.setCategory(categoryRepository.findByName("Газированные напитки"));
        coca_cola.setName("Coca-cola");
        coca_cola.setDescription("Объем: 2 л, Энергетическая ценность: 42 ккал/100г, Углеводы: 11 г/100г");
        coca_cola.setPrice(74.0);

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

        Product seven_up = new Product();
        seven_up.setCategory(categoryRepository.findByName("Газированные напитки"));
        seven_up.setName("7Up");
        seven_up.setDescription("Объем: 2 л, Энергетическая ценность: 30 ккал/100г, Углеводы: 8 г/100г");
        seven_up.setPrice(100.0);


        // Подкатегория "Энергетические напитки"
        Product burn_original = new Product();
        burn_original.setCategory(categoryRepository.findByName("Энергетические напитки"));
        burn_original.setName("Burn оригинал");
        burn_original.setDescription("Объем: 449 мл, Пищевая ценность: 55 ккал/100г");
        burn_original.setPrice(85.0);

        Product burn_AppleKiwi = new Product();
        burn_AppleKiwi.setCategory(categoryRepository.findByName("Энергетические напитки"));
        burn_AppleKiwi.setName("Burn яблоко-киви");
        burn_AppleKiwi.setDescription("Объем: 449 мл, Пищевая ценность: 50 ккал/100г");
        burn_AppleKiwi.setPrice(106.0);

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

        Product steel_water = new Product();
        steel_water.setCategory(categoryRepository.findByName("Другие"));
        steel_water.setName("Святой источник");
        steel_water.setDescription("Вода, негазированная");
        steel_water.setPrice(60.0);

        productRepository.saveAll(Arrays.asList(salmon_pizza, asian_chick_pizza, caesar_pizza, italian_pizza, carbonara_pizza,
                mac_rolls, philadelphia_rolls, california_rolls, in_yan_rolls, chicken_tempura, mussels_tempura, tofu,
                bounty_rolls, marmalade_rolls, fruit_rolls, cream_rolls, set_weekend, set_bombastic, set_sweet_gourmet,
                burger_big_tasty, burger_ham, burger_cheese, burger_fish, burger_pork, burger_veal, burger_chicken,
                coca_cola, sprite, fanta, pepsi, mirinda, seven_up, burn_original, burn_AppleKiwi, adrenaline, rich,
                dobriy, j7, coffee, beer, steel_water));

    }
}
