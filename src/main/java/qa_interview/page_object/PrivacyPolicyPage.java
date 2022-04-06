package qa_interview.page_object;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;

public class PrivacyPolicyPage extends BasePage{

    private final String termsPageXpath = "//body";

    @Step("Verify that 'Body' tag is available")
    public void verifyOpenedPage() {
        $(By.xpath(termsPageXpath)).shouldBe(Condition.visible);
    }

    @Step("Verify link of 'Privacy' page")
    public void verifyLinkPrivacyPage() {
        String expectedUrl = String.format("%s/privacy", domain);
        Assertions.assertThat(
                        url()
                ).as("link is equal to expected")
                .isEqualTo(expectedUrl);
    }
}
