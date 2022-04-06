package qa_interview.utils.enums;

public enum Languages {
    EN("en"),
    RU("ru"),
    UA("ua");

    private final String language;

    Languages(String languageValue) {
        this.language = languageValue;
    }

    @Override
    public String toString() {
        return this.language;
    }
}
