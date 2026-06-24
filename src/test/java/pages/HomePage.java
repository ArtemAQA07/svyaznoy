package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
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
    hideButton = $(".l-categories-compact__hide-button");




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
    public void checkShowButton() {showButton.shouldBe(visible).click();sleep(1000);}


    @Step("Проверка, что кнопка 'Скрыть' отображается")
    public void checkHideButtonVisible() {hideButton.shouldBe(visible);}



    @Step("Нажать на кнопку 'Скрыть'")
    public void clickHideButton() {hideButton.shouldBe(visible).click();sleep(1000);}


    @Step("Проверка, что кнопка 'Скрыть' скрыта")
    public void checkHideButtonHidden() {hideButton.shouldNotBe(visible);}


}