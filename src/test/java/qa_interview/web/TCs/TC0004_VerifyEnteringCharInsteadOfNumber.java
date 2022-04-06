package qa_interview.web.TCs;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import qa_interview.page_object.FactorialPage;
import qa_interview.utils.Tags;
import qa_interview.web.BaseWebTest;

@Tag(Tags.fullRegression)
@Tag(Tags.smoke)
@Tag(Tags.test)
@Tag(Tags.prod)
public class TC0004_VerifyEnteringCharInsteadOfNumber extends BaseWebTest {
    @Description("Verify entering string instead of a number")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Verify entering string instead of a number")
    @TmsLink("TEST-1114")
    @Test
    public void verifyEnteringStringInsteadOfNumber() {

        String factorialNumber = "A";

        FactorialPage factorialPage = new FactorialPage();

        factorialPage.enterNumber(factorialNumber);
        factorialPage.clickOnCalculateButton();
        factorialPage.isErrorMessageDisplayed(true);
    }
}
