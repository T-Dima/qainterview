package qa_interview.web;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import qa_interview.SelenoidDriverProvider;
import qa_interview.page_object.BasePage;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;

public class BaseWebTest extends BasePage {

    @BeforeAll
    public static void setUp() {
        Configuration.browser = SelenoidDriverProvider.class.getName();
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        Configuration.driverManagerEnabled = false;
        SelenideLogger.addListener("SelenideAllure", new AllureSelenide().screenshots(true).savePageSource(false));
    }

    @BeforeEach
    public void start() {
        open(domain);
    }

    @AfterEach
    public void clearCookie() throws IOException {
        clearBrowserCookies();
        screenshot();
    }

    @AfterAll
    public static void tearDown() {
        closeWebDriver();
        SelenideLogger.removeListener("SelenideAllure");
    }

    @Attachment(type = "image/png")
    public byte[] screenshot() throws IOException {
        File screenshot = Screenshots.takeScreenShotAsFile();
        return Files.toByteArray(screenshot);
    }

}
