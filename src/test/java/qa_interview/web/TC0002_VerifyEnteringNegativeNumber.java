package qa_interview.web;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import qa_interview.page_object.FactorialPage;
import qa_interview.utils.Tags;

@Disabled("Until bug TEST2222 is not fixed")
@Tag(Tags.smoke)
@Tag(Tags.test)
@Tag(Tags.prod)
public class TC0002_VerifyEnteringNegativeNumber extends BaseWebTest {
    @Description("Verify entering a negative number")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Verify entering a negative number")
    @TmsLink("TEST-1112")
    @Test
    public void verifyEnteringNegativeNumber() {

        int factorialNumber = -1;

        FactorialPage factorialPage = new FactorialPage();

        factorialPage.enterNumber(factorialNumber);
        factorialPage.clickOnCalculateButton();
        factorialPage.verifyFactorialOfNumber(factorialNumber);
    }
}
