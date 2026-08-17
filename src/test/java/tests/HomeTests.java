package tests;

import config.TestData;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.HomePage;

import java.util.stream.Stream;

@Owner("Artem")
public class HomeTests extends TestBase {

    private final HomePage homePage = new HomePage();

    static Stream<String> categoryNames() {
        return Stream.of(TestData.CATEGORIES);
    }

    @Test
    @DisplayName("Проверка отображения элементов главной страницы")
    @Tag("smoke")
    void homePageElementsTest() {
        homePage.openPage();

        for (String headerLink : TestData.HEADER_LINKS) {
            homePage.checkTopHeader(headerLink);
        }

        homePage.checkMainBanner();

        for (String category : TestData.CATEGORIES) {
            homePage.checkCategories(category);
        }

        homePage.checkShowButton();
        homePage.checkHideButtonVisible();
        homePage.clickHideButton();
        homePage.checkHideButtonHidden();
    }

    @ParameterizedTest(name = "Категория: {0}")
    @MethodSource("categoryNames")
    @DisplayName("Проверка работы кнопок категорий")
    @Tag("smoke")
    void categoryNavigationTest(String category) {
        homePage.openPage();
        homePage.selectCategory(category);
    }

    @Test
    @DisplayName("Проверка работы поиска")
    @Tag("smoke")
    void searchTest() {
        homePage.openPage();
        homePage.searchProduct(TestData.SEARCH_QUERY);
        homePage.verifySearchResultContains(TestData.SEARCH_QUERY);
    }

    @Test
    @DisplayName("Проверка покупки телефона 'Iphone 11'")
    @Tag("smoke")
    void buyPhoneTest() {
        homePage.openPage();
        homePage.searchProduct(TestData.PRODUCT_SEARCH_QUERY);
        homePage.openProductCard();
        homePage.verifyShopRedirectToMarketplace();
    }

    @Test
    @DisplayName("Проверка добавления в избранное")
    @Tag("smoke")
    void addToFavoritesTest() {
        homePage.openPage();
        homePage.searchProduct(TestData.PRODUCT_SEARCH_QUERY);
        homePage.openProductCard();
        homePage.addToFavorites();
        homePage.openFavorites();
        homePage.verifyFavoritesPageOpened();
        homePage.verifyProductInFavorites();
    }

    @Test
    @DisplayName("Проверка добавления в сравнение")
    @Tag("smoke")
    void addToCompareTest() {
        homePage.openPage();
        homePage.searchProduct(TestData.PRODUCT_SEARCH_QUERY);
        homePage.openProductCard();
        homePage.addToCompare();
        homePage.openComparePage();
        homePage.verifyComparePageOpened();
        homePage.verifyProductInCompare();
    }
}
