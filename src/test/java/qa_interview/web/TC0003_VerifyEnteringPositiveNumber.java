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
public class TC0003_VerifyEnteringPositiveNumber extends BaseWebTest {
    @Description("Verify entering a positive number")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Verify entering a positive number")
    @TmsLink("TEST-1113")
    @Test
    public void verifyEnteringPositiveNumber() {

        int factorialNumber = 5;

        FactorialPage factorialPage = new FactorialPage();

        factorialPage.enterNumber(factorialNumber);
        factorialPage.clickOnCalculateButton();
        factorialPage.verifyFactorialOfNumber(factorialNumber);
    }
}
