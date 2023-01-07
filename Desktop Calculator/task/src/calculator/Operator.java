package calculator;

public enum Operator {
    PLUS("\u002B", 1),
    SUBTRACT("-", 1),
    MULTIPLY("\u00D7", 2),
    DIVIDE("\u00F7", 2),
    POWER("^", 3),
    POWER_2("X\u00B2", 3),
    POWER_Y("X\u02b8", 3),
    SQUARE_ROOT("\u221A", 3);
    private final String code;
    private final int priority;

    Operator(String code, int priority) {
        this.code = code;
        this.priority = priority;
    }

    String code() {
        return code;
    }

    int priority() {
        return priority;
    }

    static Operator byCode(String code) {
        return switch (code) {
            case "\u002B" -> PLUS;
            case "-" -> SUBTRACT;
            case "\u00D7" -> MULTIPLY;
            case "\u00F7" -> DIVIDE;
            case "^" -> POWER;
            case "X\u00B2" -> POWER_2;
            case "X\u02b8" -> POWER_Y;
            case "\u221A" -> SQUARE_ROOT;
            default -> throw new IllegalArgumentException("No such operator");
        };
    }
}
