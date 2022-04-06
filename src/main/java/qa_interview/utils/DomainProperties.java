package qa_interview.utils;

import qa_interview.utils.enums.Environments;

public class DomainProperties {

    public static Environments chooseEnvironment(String env){
        
        switch (env){

            case "prod":
                return Environments.PRODUCTION;
            case "stage":
                return Environments.STAGING;

            default:
                return TestEnv.defaultEnvironment;
        }
    }
}
