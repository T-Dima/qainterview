package qa_interview.page_object;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import qa_interview.utils.DomainProperties;

public class BasePage {

    public static String env = System.getProperty("env");
    public static String lang = System.getProperty("lang");
    public static String domain = String.valueOf(DomainProperties.chooseEnvironment(env));

    @Step("Refresh the page")
    public void refreshPage(){
        Selenide.refresh();
    }
}
