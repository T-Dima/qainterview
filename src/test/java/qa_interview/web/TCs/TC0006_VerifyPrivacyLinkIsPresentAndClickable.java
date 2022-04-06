package qa_interview.web.TCs;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import qa_interview.page_object.FactorialPage;
import qa_interview.page_object.PrivacyPolicyPage;
import qa_interview.utils.Tags;
import qa_interview.web.BaseWebTest;

@Disabled("until bug 0006 with incorrect link is not fixed")
@Tag(Tags.smoke)
@Tag(Tags.test)
@Tag(Tags.prod)
public class TC0006_VerifyPrivacyLinkIsPresentAndClickable extends BaseWebTest {
    @Description("Verify that 'Privacy' link is present")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Verify that 'Privacy' link is present")
    @TmsLink("TEST-1116")
    @Test
    public void verifyPrivacyLinkIsPresentAndClickable() {
        FactorialPage factorialPage = new FactorialPage();
        PrivacyPolicyPage privacyPolicyPage = new PrivacyPolicyPage();

        factorialPage.isTermsAndConditionsLinkPresent(true);
        factorialPage.clickOnPrivacyLink();
        privacyPolicyPage.verifyOpenedPage();
        privacyPolicyPage.verifyLinkPrivacyPage();
    }
}
