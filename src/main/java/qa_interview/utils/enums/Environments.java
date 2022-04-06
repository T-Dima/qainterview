package qa_interview.utils.enums;

public enum Environments {
    PRODUCTION("https://qainterview.pythonanywhere.com"),
    STAGING("https://qainterview.pythonanywhere.com");

    private final String env;

    Environments(String envValue) {
        this.env = envValue;
    }

    @Override
    public String toString() {
        return this.env;
    }
}
