package Examination.Type;

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
}
