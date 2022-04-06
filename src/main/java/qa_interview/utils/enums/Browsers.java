package qa_interview.utils.enums;

public enum Browsers {

    CHROME("chrome"),
    MOZILLA("firefox"),
    OPERA("opera");

    private final String browser;

    Browsers(String browserValue) {
        this.browser = browserValue;
    }

    @Override
    public String toString() {
        return this.browser;
    }
}
