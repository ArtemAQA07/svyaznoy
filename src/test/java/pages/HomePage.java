package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByTagAndText;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    private final SelenideElement
            header = $(".l-header__top-bar"),
            mainBanner = $(".c-header-middle-bar__container"),
            categories = $(".l-categories-compact"),
            showButton = $(".l-categories-compact__show-button"),
            hideButton = $(".l-categories-compact__hide-button"),
            items1 = $(byTagAndText("span", "Смартфоны")),
            items2 = $(byTagAndText("span", "Гаджеты")),
            items3 = $(byTagAndText("span", "Автомобильная электроника")),
            items4 = $(byTagAndText("span", "Аксессуары")),
            items5 = $(byTagAndText("span", "Бытовая техника")),
            items6 = $(byTagAndText("span", "Игровые платформы")),
            items7 = $(byTagAndText("span", "Модемы и роутеры")),
            items8 = $(byTagAndText("span", "Ноутбуки")),
            input = $(".c-input-search__input"),
            ProductPage = $(".c-product-thumb__name"),
            productName = $x("//span[contains(text(), 'Смартфон Apple iPhone 11 (новая комплектация) 64Gb Белый')]"),
            goToShopButton = $x("//span[contains(text(), 'Перейти в магазин')]"),
            searchField = $("[data-auto='snippet-title']"),
            favoriteButton = $(byTagAndText("span", "В избранное")),
            favoritesTitle = $x("//h1[contains(text(), 'Избранное')]"),
            heartButton = $(byTagAndText("a", "Перейти в избранное")),
            favoriteProduct = $(byTagAndText("span", "Смартфон Apple iPhone 11 (новая комплектация) 64Gb Белый")),
            compareButton = $(byTagAndText("span", "К сравнению")),
            comparisonButton = $(byTagAndText("a", "Сравнить")),
            compareTitle = $x("//h1[contains(text(), 'Сравнение товаров')]"),
            compareProduct = $(byTagAndText("a", "Смартфон Apple iPhone 11 (новая комплектация) 64Gb Белый"));



    @Step("Открыть главную страницу")
    public void openPage() {
        open("");
        Selenide.sleep(3000);
    }

    @Step("Проверка элементов верхнего блока")
    public void checkTopHeader(String element) {
        header.shouldHave(text(element));
    }


    @Step("Проверка отображения главного баннера")
    public void checkMainBanner() {
        mainBanner.shouldBe(visible);
    }


    @Step("Проверка отображения популярных категорий товаров")
    public void checkCategories(String element) {
        categories.shouldHave(text(element));
    }


    @Step("Проверка кнопки 'Показать еще' ")
    public void checkShowButton() {
        showButton.shouldBe(visible).click();
        sleep(1000);
    }


    @Step("Проверка, что кнопка 'Скрыть' отображается")
    public void checkHideButtonVisible() {
        hideButton.shouldBe(visible);
    }


    @Step("Нажать на кнопку 'Скрыть'")
    public void clickHideButton() {
        hideButton.shouldBe(visible).click();
        sleep(1000);
    }


    @Step("Проверка, что кнопка 'Скрыть' скрыта")
    public void checkHideButtonHidden() {
        hideButton.shouldNotBe(visible);
    }


    @Step("Проверка, что при нажатии кнопки 'Смартфоны' переносит в данную категорию")
    public void checkSelectCategoryPhones() {
        items1.click();
        sleep(3000);
        $(".category-name").shouldHave(text("Смартфоны"));
    }

    @Step("Проверка, что при нажатии кнопки 'Гаджеты' категории переносит в данную категорию")
    public void checkSelectCategoryGadgets() {
        items2.click();
        sleep(3000);
        $(".category-name").shouldHave(text("Гаджеты"));
    }

    @Step("Проверка, что при нажатии кнопки  'Автомобильная электроника' переносит в данную категорию")
    public void checkSelectCategoryAutomotiveElectronics() {
        items3.click();
        sleep(3000);
        $(".category-name").shouldHave(text("Автомобильная электроника"));
    }

    @Step("Проверка, что при нажатии кнопки 'Аксессуары' переносит в данную категорию")
    public void checkSelectCategoryAccessories() {
        items4.click();
        sleep(3000);
        $(".category-name").shouldHave(text("Аксессуары"));
    }

    @Step("Проверка, что при нажатии кнопки 'Бытовая техника' переносит в данную категорию")
    public void checkSelectCategoryHouseholdAppliances() {
        items5.click();
        sleep(3000);
        $(".category-name").shouldHave(text("Бытовая техника"));
    }

    @Step("Проверка, что при нажатии кнопки 'Игровые платформы' переносит в данную категорию")
    public void checkSelectCategoryGamingPlatforms() {
        items6.click();
        sleep(3000);
        $(".category-name").shouldHave(text("Игровые платформы"));
    }

    @Step("Проверка, что при нажатии кнопки 'Модемы и роутеры' переносит в данную категорию")
    public void checkSelectCategoryModemsAndRouters() {
        items7.click();
        sleep(3000);
        $(".category-name").shouldHave(text("Модемы и роутеры"));
    }

    @Step("Проверка, что при нажатии кнопки 'Ноутбуки' переносит в данную категорию")
    public void checkSelectCategoryLaptops() {
        items8.click();
        sleep(3000);
        $(".category-name").shouldHave(text("Ноутбуки"));
    }

    @Step("Проверка работы поиска")
    public void InputTest(String product) {
        input.click();
        input.setValue(product).pressEnter();
    }

    @Step("Проверка, что именно этот продукт найден")
    public void ConfirmingThatThisSpecificProductHasBeenFound(String product) {
        ProductPage.shouldHave(text(product));
    }

    @Step("Проверка перехода по карточки товара")
    public void testClickOnProductNameRedirectsToProductCard() {
        productName.shouldBe(visible);
        productName.click();
    }

    @Step("Проверка перехрда в маркетплейс")
    public void testClickOnShopButtonRedirectsToYandexMarket(){
        goToShopButton.shouldBe(visible);
        goToShopButton.click();
        Selenide.switchTo().window(1);
        sleep(5000);
        searchField.shouldBe(visible);
        searchField.shouldHave(text("iPhone 11"));
    }

    @Step("Проверка нажатия кнопки 'В избранное'")
    public void testClickFavoritesButton(){
        favoriteButton.click();
    }

    @Step("Открыть Избранное")
    public void openFavorites() {
        heartButton.shouldBe(visible);
        heartButton.click();
    }

    @Step("Проверка что пользователь на странице Избранное")
    public void testOnFavoritesPage(){
        favoritesTitle.shouldBe(visible);
    }

    @Step("Проверка что товар находиться в Избранном")
    public void productInFavoritesTest(){
        favoriteProduct.shouldBe(visible);
    }

    @Step("Проверка нажатия кнопки 'К сравнению'")
    public void testClickСompareButton(){
        compareButton.click();
    }

    @Step("Открыть Сравнение")
    public void openСompare() {
        comparisonButton.shouldBe(visible);
        comparisonButton.click();
    }

    @Step("Проверка что пользователь на странице Сравнение")
    public void testOnСomparePage(){
        compareTitle.shouldBe(visible);
    }

    @Step("Проверка что товар находиться в Сравнение")
    public void productInСompareTest(){
        compareProduct.shouldBe(visible);
    }


}
