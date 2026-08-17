package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import config.TestData;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    private final SelenideElement
            header = $(".l-header__top-bar"),
            mainBanner = $(".c-header-middle-bar__container"),
            categories = $(".l-categories-compact"),
            showButton = $(".l-categories-compact__show-button"),
            hideButton = $(".l-categories-compact__hide-button"),
            searchInput = $(".c-input-search__input"),
            searchResultName = $(".c-product-thumb__name"),
            productName = $x("//span[contains(text(), '" + TestData.PRODUCT_FULL_NAME + "')]"),
            goToShopButton = $x("//span[contains(text(), 'Перейти в магазин')]"),
            marketplaceProductTitle = $("[data-auto='snippet-title']"),
            favoriteButton = $(byTagAndText("span", "В избранное")),
            favoritesTitle = $x("//h1[contains(text(), 'Избранное')]"),
            favoritesLink = $(byTagAndText("a", "Перейти в избранное")),
            favoriteProduct = $(byTagAndText("span", TestData.PRODUCT_FULL_NAME)),
            compareButton = $(byTagAndText("span", "К сравнению")),
            compareLink = $(byTagAndText("a", "Сравнить")),
            compareTitle = $x("//h1[contains(text(), 'Сравнение товаров')]"),
            compareProduct = $(byTagAndText("a", TestData.PRODUCT_FULL_NAME));

    @Step("Открыть главную страницу")
    public void openPage() {
        open("");
        mainBanner.shouldBe(visible);
    }

    @Step("Проверка элементов верхнего блока: {element}")
    public void checkTopHeader(String element) {
        header.shouldHave(text(element));
    }

    @Step("Проверка отображения главного баннера")
    public void checkMainBanner() {
        mainBanner.shouldBe(visible);
    }

    @Step("Проверка отображения популярных категорий товаров: {element}")
    public void checkCategories(String element) {
        categories.shouldHave(text(element));
    }

    @Step("Проверка кнопки 'Показать еще'")
    public void checkShowButton() {
        showButton.shouldBe(visible).click();
        hideButton.shouldBe(visible);
    }

    @Step("Проверка, что кнопка 'Скрыть' отображается")
    public void checkHideButtonVisible() {
        hideButton.shouldBe(visible);
    }

    @Step("Нажать на кнопку 'Скрыть'")
    public void clickHideButton() {
        hideButton.shouldBe(visible).click();
    }

    @Step("Проверка, что кнопка 'Скрыть' скрыта")
    public void checkHideButtonHidden() {
        hideButton.shouldNotBe(visible);
    }

    @Step("Выбрать категорию: {categoryName}")
    public void selectCategory(String categoryName) {
        $(byTagAndText("span", categoryName)).shouldBe(visible).click();
        $(".category-name").shouldHave(text(categoryName));
    }

    @Step("Выполнить поиск: {product}")
    public void searchProduct(String product) {
        searchInput.shouldBe(visible).click();
        searchInput.setValue(product).pressEnter();
        searchResultName.shouldBe(visible);
    }

    @Step("Проверить, что в результатах поиска есть: {product}")
    public void verifySearchResultContains(String product) {
        searchResultName.shouldHave(text(product));
    }

    @Step("Открыть карточку товара")
    public void openProductCard() {
        productName.shouldBe(visible).click();
    }

    @Step("Проверить переход в маркетплейс")
    public void verifyShopRedirectToMarketplace() {
        goToShopButton.shouldBe(visible).click();
        Selenide.switchTo().window(1);
        marketplaceProductTitle.shouldBe(visible);
        marketplaceProductTitle.shouldHave(text(TestData.MARKETPLACE_PRODUCT_TITLE));
        Selenide.closeWindow();
        Selenide.switchTo().window(0);
    }

    @Step("Добавить товар в избранное")
    public void addToFavorites() {
        favoriteButton.shouldBe(visible).click();
    }

    @Step("Открыть страницу избранного")
    public void openFavorites() {
        favoritesLink.shouldBe(visible).click();
    }

    @Step("Проверить, что открыта страница избранного")
    public void verifyFavoritesPageOpened() {
        favoritesTitle.shouldBe(visible);
    }

    @Step("Проверить, что товар находится в избранном")
    public void verifyProductInFavorites() {
        favoriteProduct.shouldBe(visible);
    }

    @Step("Добавить товар к сравнению")
    public void addToCompare() {
        compareButton.shouldBe(visible).click();
    }

    @Step("Открыть страницу сравнения")
    public void openComparePage() {
        compareLink.shouldBe(visible).click();
    }

    @Step("Проверить, что открыта страница сравнения")
    public void verifyComparePageOpened() {
        compareTitle.shouldBe(visible);
    }

    @Step("Проверить, что товар находится в сравнении")
    public void verifyProductInCompare() {
        compareProduct.shouldBe(visible);
    }
}
