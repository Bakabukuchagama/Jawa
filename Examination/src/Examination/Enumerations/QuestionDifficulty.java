package Examination.Enumerations;

public enum QuestionDifficulty {
    EASY("EASY"),
    MEDIUM("MEDIUM"),
    HARD("HARD");
    String value;

    QuestionDifficulty(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }

    public static QuestionDifficulty getByName(String name) {

        try {
            return valueOf(name.toUpperCase());
        } catch (IllegalArgumentException e) {
            return EASY;
        }
    }

}
