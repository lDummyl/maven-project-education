package task3;

import java.util.function.Function;

public enum OracleReaction {
    TOO_LONG("Будь лаконичнее"),
    TOO_SHORT("Будь красноречивее"),
    STICK_HIT("(；一_一) ┻━┻༼ つ ಥ_ಥ ༽つ" + "\n" + "-Оракул бьёт вас палкой"),
    RUDENESS("Дай-ка угадаю, кто-то украл твой сладкий рулет?"),
    NO_KEY_WORT("Не слышу вопроса в речах твоих"),
    TO_MATCH_KEY_WORT("Ты задаёшь слишком много вопросов");

    private String value;

    OracleReaction(String reactionAnswer) {
        this.value = reactionAnswer;
    }

    public String getValue() {
        return value;
    }
}
