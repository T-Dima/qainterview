package qa_interview.page_object;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import qa_interview.utils.config.ErrorMessageConfig;
import qa_interview.utils.config.FactorialMessageConfig;
import qa_interview.utils.config.StyleConfig;

import java.util.stream.LongStream;

import static com.codeborne.selenide.Selenide.$;

public class FactorialPage extends BasePage{

    private final String EnterIntegerInputId = "[id='number']";
    private final String calculateButtonId = "[id='getFactorial']";
    private final String resultMessageXpath = "//p[@id='resultDiv']";
    private final String termsAndConditionsLinkXpath = "//div[@class='row-fluid']//a[@href='/terms']";
    private final String PrivacyLinkXpath = "//div[@class='row-fluid']//a[@href='/privacy']";

    @Step("Click on the 'Calculate' button")
    public void clickOnCalculateButton() {
        $(calculateButtonId)
                .shouldBe(Condition.visible)
                .click();
    }

    @Step("Verify is border on 'Enter an integer' input displayed")
    public void isRedBorderOnNumberInputDisplayed(boolean status) {
        if (status){
            Assertions.assertThat(
                            $(EnterIntegerInputId).getAttribute("style")
            ).as("Border color is equal to required")
                            .isEqualTo(StyleConfig.errorInputRedBorder);
        }else {
            Assertions.assertThat(
                            $(EnterIntegerInputId).getAttribute("style")
                    ).as("Border color is equal to ''")
                    .isEqualTo("");
        }
    }

    @Step("Verify is error message displayed")
    public void isErrorMessageDisplayed(boolean status) {
        if (status){
            $(By.xpath(resultMessageXpath))
                    .shouldBe(Condition.visible)
                    .shouldHave(Condition.text(ErrorMessageConfig.pleaseEnterAnIntegerErrorMessage));
        }else {
            $(By.xpath(resultMessageXpath))
                    .shouldNotBe(Condition.visible)
                    .shouldNotHave(Condition.text(ErrorMessageConfig.pleaseEnterAnIntegerErrorMessage));
        }
    }

    @Step("Fill in with number {0} for field 'Enter an integer'")
    public void enterNumber(int number) {
        $(EnterIntegerInputId).setValue(String.valueOf(number));
    }
    @Step("Fill in with number {0} for field 'Enter an integer'")
    public void enterNumber(String number) {
        $(EnterIntegerInputId).setValue(number);
    }

    @Step("Calculate a factorial number of {0}")
    public long factorialUsingStreams(int n) {
        return LongStream.rangeClosed(1, n)
                .reduce(1, (long x, long y) -> x * y);
    }

    @Step("Verify filled in factorial number")
    public void verifyFactorialOfNumber(int factorialNumber) {
        $(By.xpath(resultMessageXpath))
                .shouldBe(Condition.visible)
                .shouldHave(
                        Condition.text(
                                String.format(
                                        FactorialMessageConfig.factorialText, factorialNumber, factorialUsingStreams(factorialNumber)
                                )
                        )
                );
    }

    @Step("Verify that 'Terms and conditions' link is present")
    public void isTermsAndConditionsLinkPresent(boolean status) {
        if (status){
            $(By.xpath(termsAndConditionsLinkXpath)).shouldBe(Condition.visible);
        }else {
            $(By.xpath(termsAndConditionsLinkXpath)).shouldNotBe(Condition.visible);
        }
    }

    @Step("Click on the 'Terms and conditions' link")
    public void clickOnTermsAndConditionsLink() {
        $(By.xpath(termsAndConditionsLinkXpath)).click();
    }

    @Step("Click on the 'Privacy' link")
    public void clickOnPrivacyLink() {
        $(By.xpath(PrivacyLinkXpath)).click();
    }

    @Step("Press 'Enter' button")
    public void pressEnterButton() {
        $(EnterIntegerInputId).pressEnter();
    }
}
