package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.TestConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = TestConfig.browser();
        Configuration.browserSize = TestConfig.browserSize();
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = TestConfig.baseUrl();
        Configuration.timeout = TestConfig.timeout();

        if (TestConfig.isRemoteRun()) {
            Configuration.remote = TestConfig.remoteUrl();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        }
    }

    @BeforeEach
    void setUpBeforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(false)
                .savePageSource(false));
    }

    @AfterEach
    void tearDown() {
        if (Selenide.webdriver().driver().hasWebDriverStarted()) {
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            Attach.browserConsoleLogs();
            if (TestConfig.isRemoteRun()) {
                Attach.addVideo();
            }
        }
        Selenide.closeWebDriver();
        SelenideLogger.removeListener("AllureSelenide");
    }
}
