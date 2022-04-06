package qa_interview.utils;

import qa_interview.utils.enums.Languages;


public class LanguageProperties {

    public static Languages chooseLanguage(String language){

        switch (language){

            case "ru":
                return Languages.RU;

            case "en":
                return Languages.EN;

            case "ua":
                return Languages.UA;

            default:
                return TestEnv.defaultLanguage;
        }
    }
}
