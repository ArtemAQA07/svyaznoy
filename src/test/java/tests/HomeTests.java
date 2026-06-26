package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.HomePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomeTests extends TestBase {

    String product = "IPHONE";

    HomePage steps = new HomePage();

    @Test
    @DisplayName("Проверка отображения элементов главной страницы")
    @Tag("smoke")
    void homeTest() {
        steps.openPage();
        steps.checkTopHeader("Бренды");
        steps.checkTopHeader("Кредиты");
        steps.checkTopHeader("Авиабилеты");


        steps.checkMainBanner();


        steps.checkCategories("Смартфоны");
        steps.checkCategories("Гаджеты");
        steps.checkCategories("Автомобильная электроника");
        steps.checkCategories("Аксессуары");
        steps.checkCategories("Бытовая техника");
        steps.checkCategories("Игровые платформы");
        steps.checkCategories("Модемы и роутеры");
        steps.checkCategories("Ноутбуки");


        steps.checkShowButton();
        steps.checkHideButtonVisible();
        steps.clickHideButton();
        steps.checkHideButtonHidden();
    }

    @Test
    @DisplayName("Проверка работы кнопок категорий")
    @Tag("smoke")
    void ButtonTest() {
        steps.openPage();
        steps.checkSelectCategoryPhones();
        steps.openPage();
        steps.checkSelectCategoryGadgets();
        steps.openPage();
        steps.checkSelectCategoryAutomotiveElectronics();
        steps.openPage();
        steps.checkSelectCategoryAccessories();
        steps.openPage();
        steps.checkSelectCategoryHouseholdAppliances();
        steps.openPage();
        steps.checkSelectCategoryGamingPlatforms();
        steps.openPage();
        steps.checkSelectCategoryModemsAndRouters();
        steps.openPage();
        steps.checkSelectCategoryLaptops();
    }

    @Test
    @DisplayName("Проверка работы поиска")
    @Tag("smoke")
    void searchTest(){
        steps.openPage();
        steps.InputTest(product);
        steps.ConfirmingThatThisSpecificProductHasBeenFound(product);
    }

    @Test
    @DisplayName("Проверка покупки телефона ''Iphone 11'")
    @Tag("smoke")
    void buyPhoneTest(){
        steps.openPage();
        steps.InputTest("Iphone 11");

    }
}




