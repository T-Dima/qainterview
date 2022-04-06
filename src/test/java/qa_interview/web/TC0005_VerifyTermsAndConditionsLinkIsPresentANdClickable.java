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
import qa_interview.page_object.TermsAndConditionsPage;
import qa_interview.utils.Tags;

//@Disabled("until bug 0005 with incorrect link is not fixed")
@Tag(Tags.smoke)
@Tag(Tags.test)
@Tag(Tags.prod)
public class TC0005_VerifyTermsAndConditionsLinkIsPresentANdClickable extends BaseWebTest {
    @Description("Verify that 'Terms and conditions' link is present")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Verify that 'Terms and conditions' link is present")
    @TmsLink("TEST-1115")
    @Test
    public void verifyTermsAndConditionsLinkIsPresentANdClickable() {
        FactorialPage factorialPage = new FactorialPage();
        TermsAndConditionsPage termsAndConditionsPage = new TermsAndConditionsPage();

        factorialPage.isTermsAndConditionsLinkPresent(true);
        factorialPage.clickOnTermsAndConditionsLink();
        termsAndConditionsPage.verifyOpenedPage();
        termsAndConditionsPage.verifyLinkTermsAndConditionsPage();
    }
}
