package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        String[] browserSettings = System.getProperty("browser", "chrome 100.0").split(" ");
        String browserName = browserSettings[0];
        String browserVersion = browserSettings[1];
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.timeout = 10000;
        Configuration.pageLoadTimeout = 10000;
        Configuration.browser = System.getProperty(browserName, "chrome");
//        Configuration.holdBrowserOpen = true;
        Configuration.remote =  System.getProperty("remoteUrl", "https://user1:1234@selenoid.autotests.cloud") +"/wd/hub";;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        capabilities.setVersion(browserVersion);
        Configuration.browserCapabilities = capabilities;


        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

//    @BeforeEach
//    void addListener() {
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
//    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.attachHtml("HTML");
        Attach.addVideo();
        Selenide.closeWebDriver();
    }
}
