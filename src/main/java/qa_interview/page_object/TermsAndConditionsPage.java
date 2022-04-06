package qa_interview.page_object;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;

public class TermsAndConditionsPage extends BasePage{

    private final String privacyPolicyPageXpath = "//body";

    @Step("Verify that 'Body' tag is available")
    public void verifyOpenedPage() {
        $(By.xpath(privacyPolicyPageXpath)).shouldBe(Condition.visible);
    }

    @Step("Verify link of 'Terms and conditionals' page")
    public void verifyLinkTermsAndConditionsPage() {
      String expectedUrl = String.format("%s/terms", domain);
        Assertions.assertThat(
                url()
        ).as("link is equal to expected")
                .isEqualTo(expectedUrl);
    }
}
