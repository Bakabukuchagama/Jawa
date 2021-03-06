package Examination.enumerations;

public enum QuestionType {
    ONE_QUESTION("ONE_QUESTION"),
    MANY_QUESTION("MANY_QUESTION"),
    OPEN_QUESTION("OPEN_QUESTION");
    String value;

    QuestionType(String value) {
        this.value = value;
    }
    public String getValue()
    {
        return value;
    }

    public static QuestionType getByName(String name) {

        try {
            return valueOf(name.toUpperCase());
        } catch (IllegalArgumentException e) {
            return OPEN_QUESTION;
        }
    }
}
