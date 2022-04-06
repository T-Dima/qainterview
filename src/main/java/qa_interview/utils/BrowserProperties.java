package qa_interview.utils;

import qa_interview.utils.enums.Browsers;

public class BrowserProperties {
    public static Browsers chooseBrowser(String browser){

        switch (browser){

            case "chrome":
                return Browsers.CHROME;

            case "firefox":
                return Browsers.MOZILLA;

            case "opera":
                return Browsers.OPERA;

            default:
                return TestEnv.defaultBrowser;
        }
    }
}
