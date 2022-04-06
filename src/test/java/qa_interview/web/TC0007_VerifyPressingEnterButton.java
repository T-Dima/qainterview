package qa_interview.web;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import qa_interview.page_object.FactorialPage;
import qa_interview.utils.Tags;

@Tag(Tags.fullRegression)
@Tag(Tags.smoke)
@Tag(Tags.test)
@Tag(Tags.prod)
public class TC0007_VerifyPressingEnterButton extends BaseWebTest {
    @Description("Verify pressing 'Enter' button")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Verify pressing 'Enter' button")
    @TmsLink("TEST-1117")
    @Test
    public void verifyPressingEnterButton() {

        int factorialNumber = 5;

        FactorialPage factorialPage = new FactorialPage();

        factorialPage.enterNumber(factorialNumber);
        factorialPage.pressEnterButton();
        factorialPage.isRedBorderOnNumberInputDisplayed(false);
        factorialPage.isErrorMessageDisplayed(false);
    }
}
