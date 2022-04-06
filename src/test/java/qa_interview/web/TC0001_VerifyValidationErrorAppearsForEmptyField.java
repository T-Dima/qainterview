package qa_interview.web;

import io.github.artsok.RepeatedIfExceptionsTest;
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
public class TC0001_VerifyValidationErrorAppearsForEmptyField extends BaseWebTest {
    @Description("Verify that validation error appears after trying sending empty input")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Verify that validation error appears after trying sending empty input")
    @TmsLink("TEST-1111")
    @Test
    public void verifyValidationErrorAppearsForEmptyField() {

        FactorialPage factorialPage = new FactorialPage();

        factorialPage.isRedBorderOnNumberInputDisplayed(false);
        factorialPage.clickOnCalculateButton();
        factorialPage.isRedBorderOnNumberInputDisplayed(true);
        factorialPage.isErrorMessageDisplayed(true);
    }
}
