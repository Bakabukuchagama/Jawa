package Examination.Enumerations;

public enum DifficultyQuestion {
    EASY("EASY"),
    MEDIUM("MEDIUM"),
    HARD("HARD");
    String value;

    DifficultyQuestion(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }

    public static DifficultyQuestion getByName(String name) {

        try {
            return valueOf(name.toUpperCase());
        } catch (IllegalArgumentException e) {
            return EASY;
        }
    }

}
