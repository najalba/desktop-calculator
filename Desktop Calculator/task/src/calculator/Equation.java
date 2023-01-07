package calculator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Equation {
    static final List<String> OPERATORS_CODES = List.of(Operator.PLUS.code(), Operator.SUBTRACT.code(), Operator.MULTIPLY.code(), Operator.DIVIDE.code(), Operator.POWER.code(), Operator.SQUARE_ROOT.code());
    private final String inFixNotation;

    Equation(String inFixNotation) {
        this.inFixNotation = this.zeroBetweenOpenParenthesesAndPlusSubtract(inFixNotation);
    }

    boolean isValid() {
        var open = this.inFixNotation.chars()
                .filter(c -> ((char) c) == '(')
                .count();
        var close = this.inFixNotation.chars()
                .filter(c -> ((char) c) == ')')
                .count();
        return this.inFixNotation.length() > 0 &&
                !OPERATORS_CODES.contains(this.inFixNotation.substring(this.inFixNotation.length() - 1)) &&
                !this.inFixNotation.contains(Operator.DIVIDE.code() + "0") &&
                open == close;
    }

    String evaluate() {
        var stack = new ArrayDeque<String>();
        var postFixNotation = this.toPostFixNotation();
        for (String str : postFixNotation) {
            if (OPERATORS_CODES.contains(str)) {
                double result;
                if (Operator.PLUS.code().equals(str)) {
                    double operand2 = Double.parseDouble(stack.pop());
                    double operand1 = Double.parseDouble(stack.pop());
                    result = operand1 + operand2;
                } else if (Operator.SUBTRACT.code().equals(str)) {
                    double operand2 = Double.parseDouble(stack.pop());
                    double operand1 = Double.parseDouble(stack.pop());
                    result = operand1 - operand2;
                } else if (Operator.MULTIPLY.code().equals(str)) {
                    double operand2 = Double.parseDouble(stack.pop());
                    double operand1 = Double.parseDouble(stack.pop());
                    result = operand1 * operand2;
                } else if (Operator.DIVIDE.code().equals(str)) {
                    double operand2 = Double.parseDouble(stack.pop());
                    double operand1 = Double.parseDouble(stack.pop());
                    result = operand1 / operand2;
                } else if (Operator.POWER.code().equals(str)) {
                    double operand2 = Double.parseDouble(stack.pop());
                    double operand1 = Double.parseDouble(stack.pop());
                    result = Math.pow(operand1, operand2);
                } else {
                    double operand1 = Double.parseDouble(stack.pop());
                    if (operand1 < 0) {
                        throw new IllegalArgumentException();
                    }
                    result = Math.sqrt(operand1);
                }
                stack.push(Double.toString(result));
            } else {
                stack.push(str);
            }
        }
        double doubleResult = Double.parseDouble(stack.pop());
        int intResult = (int) doubleResult;
        return doubleResult - intResult > 0 ? String.valueOf(doubleResult) : String.valueOf(intResult);
    }

    private List<String> toPostFixNotation() {
        var stack = new ArrayDeque<String>();
        var asListInFixNotation = new ArrayList<String>();
        var asListPostFixNotation = new ArrayList<String>();

        var operands = this.inFixNotation.split("[" + Operator.PLUS.code() + "\\-" + Operator.MULTIPLY.code() + Operator.DIVIDE.code() + Operator.POWER.code() + Operator.SQUARE_ROOT.code() + "]");
        int index = 0;
        for (String operand : operands) {
            asListInFixNotation.add(operand);
            index += operand.length();
            if (index < this.inFixNotation.length() - 1) {
                asListInFixNotation.add(String.valueOf(this.inFixNotation.charAt(index)));
                index++;
            }
        }

        asListInFixNotation.forEach(str -> {
            if (OPERATORS_CODES.contains(str)) {
                var operator = Operator.byCode(str);
                while (!stack.isEmpty() && OPERATORS_CODES.contains(stack.peek()) && operator.priority() <= Operator.byCode(stack.peek()).priority()) {
                    asListPostFixNotation.add(Operator.byCode(stack.peek()).code());
                    stack.pop();
                }
                stack.push(operator.code());
            } else {
                var operand = new StringBuilder();
                str.chars().forEach(c -> {
                    var ch = (char) c;
                    if (ch == '(') {
                        stack.push("(");
                    } else if (ch == ')') {
                        while (!stack.isEmpty() && !Objects.equals(stack.peek(), "(")) {
                            if (operand.length() > 0) {
                                asListPostFixNotation.add(operand.toString());
                                operand.setLength(0);
                            }
                            asListPostFixNotation.add(stack.peek());
                            stack.pop();
                        }
                        stack.pop();
                    } else {
                        operand.append(ch);
                    }
                });
                if (operand.length() > 0) {
                    asListPostFixNotation.add(operand.toString());
                }
            }
        });
        while (!stack.isEmpty()) {
            asListPostFixNotation.add(Operator.byCode(stack.pop()).code());
        }
        return asListPostFixNotation;
    }

    private String zeroBetweenOpenParenthesesAndPlusSubtract(String inFixNotation) {
        var inFixStringBuilder = new StringBuilder(inFixNotation);
        var positionToInsert = new ArrayList<Integer>();
        for (int i = 0; i < inFixStringBuilder.length() - 1; i++) {
            var current = String.valueOf(inFixStringBuilder.charAt(i));
            var next = String.valueOf(inFixStringBuilder.charAt(i + 1));
            if ("(".equals(current) && (Operator.PLUS.code().equals(next) || Operator.SUBTRACT.code().equals(next))) {
                positionToInsert.add(i + 1);
            }
        }
        for (int i = 0; i < positionToInsert.size(); i++) {
            inFixStringBuilder.insert(positionToInsert.get(i) + i, "0");
        }
        return inFixStringBuilder.toString();
    }
}
