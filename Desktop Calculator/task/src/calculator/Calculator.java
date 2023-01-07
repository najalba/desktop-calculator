package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {

    public Calculator() {
        this.initUI();
    }

    private void initUI() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 610);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel resultLabel = new JLabel();
        resultLabel.setName("ResultLabel");
        resultLabel.setBounds(25, 50, 290, 45);
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 45));
        resultLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        resultLabel.setVerticalAlignment(SwingConstants.CENTER);
        add(resultLabel);

        JLabel equationLabel = new JLabel();
        equationLabel.setName("EquationLabel");
        equationLabel.setBounds(25, 110, 290, 25);
        equationLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        equationLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        equationLabel.setVerticalAlignment(SwingConstants.CENTER);
        equationLabel.setForeground(Color.GREEN.darker());
        add(equationLabel);

        ActionListener arithmeticActionListener = actionEvent -> this.arithmeticActionPerformed(actionEvent, equationLabel);

        JButton parentheses = new JButton("( )");
        parentheses.setName("Parentheses");
        parentheses.setBounds(35, 170, 60, 50);
        parentheses.addActionListener(actionEvent -> this.parenthesesActionPerformed(equationLabel));
        add(parentheses);

        JButton ce = new JButton("CE");
        ce.setName("CE");
        ce.setBounds(105, 170, 60, 50);
        add(ce);

        JButton clear = new JButton("C");
        clear.setName("Clear");
        clear.setBounds(175, 170, 60, 50);
        clear.addActionListener(actionEvent -> {
                    equationLabel.setForeground(Color.GREEN.darker());
                    resultLabel.setText("0");
                    equationLabel.setText("");
                }
        );
        add(clear);

        JButton delete = new JButton("Del");
        delete.setName("Delete");
        delete.setBounds(245, 170, 60, 50);
        delete.addActionListener(actionEvent -> {
            equationLabel.setForeground(Color.GREEN.darker());
            String equationText = equationLabel.getText();
            if (equationText.length() > 0) {
                equationLabel.setText(equationText.substring(0, equationText.length() - 1));
            }
        });
        add(delete);

        JButton powerTwo = new JButton(Operator.POWER_2.code());
        powerTwo.setName("PowerTwo");
        powerTwo.setBounds(35, 230, 60, 50);
        powerTwo.addActionListener(actionEvent -> this.power2ActionPerformed(equationLabel));
        add(powerTwo);

        JButton powerY = new JButton(Operator.POWER_Y.code());
        powerY.setName("PowerY");
        powerY.setBounds(105, 230, 60, 50);
        powerY.addActionListener(actionEvent -> this.powerYActionPerformed(equationLabel));
        add(powerY);

        JButton squareRoot = new JButton(Operator.SQUARE_ROOT.code());
        squareRoot.setName("SquareRoot");
        squareRoot.setBounds(175, 230, 60, 50);
        squareRoot.addActionListener(actionEvent -> this.squareRootActionPerformed(equationLabel));
        add(squareRoot);

        JButton divide = new JButton(Operator.DIVIDE.code());
        divide.setName("Divide");
        divide.setBounds(245, 230, 60, 50);
        divide.addActionListener(arithmeticActionListener);
        add(divide);

        JButton seven = new JButton("7");
        seven.setName("Seven");
        seven.setBounds(35, 290, 60, 50);
        seven.addActionListener(arithmeticActionListener);
        add(seven);

        JButton eight = new JButton("8");
        eight.setName("Eight");
        eight.setBounds(105, 290, 60, 50);
        eight.addActionListener(arithmeticActionListener);
        add(eight);

        JButton nine = new JButton("9");
        nine.setName("Nine");
        nine.setBounds(175, 290, 60, 50);
        nine.addActionListener(arithmeticActionListener);
        add(nine);

        JButton multiply = new JButton(Operator.MULTIPLY.code());
        multiply.setName("Multiply");
        multiply.setBounds(245, 290, 60, 50);
        multiply.addActionListener(arithmeticActionListener);
        add(multiply);

        JButton four = new JButton("4");
        four.setName("Four");
        four.setBounds(35, 350, 60, 50);
        four.addActionListener(arithmeticActionListener);
        add(four);

        JButton five = new JButton("5");
        five.setName("Five");
        five.setBounds(105, 350, 60, 50);
        five.addActionListener(arithmeticActionListener);
        add(five);

        JButton six = new JButton("6");
        six.setName("Six");
        six.setBounds(175, 350, 60, 50);
        six.addActionListener(arithmeticActionListener);
        add(six);

        JButton subtract = new JButton(Operator.SUBTRACT.code());
        subtract.setName("Subtract");
        subtract.setBounds(245, 350, 60, 50);
        subtract.addActionListener(arithmeticActionListener);
        add(subtract);

        JButton one = new JButton("1");
        one.setName("One");
        one.setBounds(35, 410, 60, 50);
        one.addActionListener(arithmeticActionListener);
        add(one);

        JButton two = new JButton("2");
        two.setName("Two");
        two.setBounds(105, 410, 60, 50);
        two.addActionListener(arithmeticActionListener);
        add(two);

        JButton three = new JButton("3");
        three.setName("Three");
        three.setBounds(175, 410, 60, 50);
        three.addActionListener(arithmeticActionListener);
        add(three);

        JButton plus = new JButton(Operator.PLUS.code());
        plus.setName("Add");
        plus.setBounds(245, 410, 60, 50);
        plus.addActionListener(arithmeticActionListener);
        add(plus);

        JButton plusMinus = new JButton("\u00B1");
        plusMinus.setName("PlusMinus");
        plusMinus.setBounds(35, 470, 60, 50);
        plusMinus.addActionListener(actionEvent -> this.plusMinusActionPerformed(equationLabel));
        add(plusMinus);

        JButton zero = new JButton("0");
        zero.setName("Zero");
        zero.setBounds(105, 470, 60, 50);
        zero.addActionListener(arithmeticActionListener);
        add(zero);

        JButton dot = new JButton(".");
        dot.setName("Dot");
        dot.setBounds(175, 470, 60, 50);
        dot.addActionListener(arithmeticActionListener);
        add(dot);

        JButton equal = new JButton("=");
        equal.setName("Equals");
        equal.setBounds(245, 470, 60, 50);
        equal.addActionListener(actionEvent -> {
            var equation = new Equation(equationLabel.getText());
            if (equation.isValid()) {
                equationLabel.setForeground(Color.GREEN.darker());
                try {
                    resultLabel.setText(new Equation(equationLabel.getText()).evaluate());
                } catch (IllegalArgumentException e) {
                    equationLabel.setForeground(Color.RED.darker());
                }
            } else {
                equationLabel.setForeground(Color.RED.darker());
            }
        });
        add(equal);

        setVisible(true);
    }

    private void arithmeticActionPerformed(ActionEvent actionEvent, JLabel equationLabel) {
        var equationLabelText = equationLabel.getText();
        if (equationLabelText.length() > 0 || !Equation.OPERATORS_CODES.contains(actionEvent.getActionCommand())) {
            if (Equation.OPERATORS_CODES.contains(actionEvent.getActionCommand())) {
                if (Equation.OPERATORS_CODES.contains(equationLabelText.substring(equationLabelText.length() - 1))) {
                    equationLabel.setText(equationLabelText.substring(0, equationLabelText.length() - 1) + actionEvent.getActionCommand());
                } else {
                    var lastDotIndex = equationLabelText.lastIndexOf('.');
                    var prevDotCharacters = new java.util.ArrayList<>(java.util.List.copyOf(Equation.OPERATORS_CODES));
                    prevDotCharacters.add(")");
                    prevDotCharacters.add("(");
                    if (lastDotIndex > -1 && (lastDotIndex == 0 || prevDotCharacters.contains(equationLabelText.substring(lastDotIndex - 1, lastDotIndex)))) {
                        var equationLabelUpdatedText = new StringBuilder(equationLabelText);
                        equationLabelUpdatedText.insert(lastDotIndex, "0");
                        equationLabelUpdatedText.append(actionEvent.getActionCommand());
                        equationLabel.setText(equationLabelUpdatedText.toString());
                    } else if (lastDotIndex == equationLabelText.length() - 1) {
                        equationLabel.setText(equationLabelText + "0" + actionEvent.getActionCommand());
                    } else {
                        equationLabel.setText(equationLabelText + actionEvent.getActionCommand());
                    }
                }
            } else {
                equationLabel.setText(equationLabelText + actionEvent.getActionCommand());
            }

            var equationLabelUpdatedText = equationLabel.getText();
            var lastCloseBracketIndex = equationLabelUpdatedText.lastIndexOf(")");
            if (lastCloseBracketIndex > -1 && lastCloseBracketIndex < equationLabelUpdatedText.length() - 1 && Character.isDigit(equationLabelUpdatedText.charAt(lastCloseBracketIndex + 1))) {
                var stringBuilder = new StringBuilder(equationLabelUpdatedText);
                stringBuilder.insert(lastCloseBracketIndex + 1, Operator.MULTIPLY.code());
                equationLabel.setText(stringBuilder.toString());
            }
        }
    }

    private void parenthesesActionPerformed(JLabel equationLabel) {
        var equationLabelText = equationLabel.getText();
        var open = equationLabelText.chars()
                .filter(c -> ((char) c) == '(')
                .count();
        var close = equationLabelText.chars()
                .filter(c -> ((char) c) == ')')
                .count();
        if (open == close) {
            equationLabel.setText(equationLabelText + "(");
        } else {
            var lastCharacter = equationLabelText.substring(equationLabelText.length() - 1);
            if ("(".equals(lastCharacter) || Equation.OPERATORS_CODES.contains(lastCharacter)) {
                equationLabel.setText(equationLabelText + "(");
            } else {
                equationLabel.setText(equationLabelText + ")");
            }
        }

        var equationLabelUpdatedText = equationLabel.getText();
        var lastOpenBracketIndex = equationLabelUpdatedText.lastIndexOf("(");
        if (lastOpenBracketIndex > 0 && Character.isDigit(equationLabelUpdatedText.charAt(lastOpenBracketIndex - 1))) {
            var stringBuilder = new StringBuilder(equationLabelUpdatedText);
            stringBuilder.insert(lastOpenBracketIndex, Operator.MULTIPLY.code());
            equationLabel.setText(stringBuilder.toString());
        }
    }

    private void power2ActionPerformed(JLabel equationLabel) {
        var equationLabelText = equationLabel.getText();
        if (equationLabelText.length() > 0 && Character.isDigit(equationLabelText.charAt(equationLabelText.length() - 1))) {
            equationLabel.setText(equationLabelText + Operator.POWER.code() + "(2)");
        }
    }

    private void powerYActionPerformed(JLabel equationLabel) {
        var equationLabelText = equationLabel.getText();
        if (equationLabelText.length() > 0 && Character.isDigit(equationLabelText.charAt(equationLabelText.length() - 1))) {
            equationLabel.setText(equationLabelText + Operator.POWER.code() + "(");
        }
    }

    private void squareRootActionPerformed(JLabel equationLabel) {
        var equationLabelText = equationLabel.getText();
        equationLabel.setText(equationLabelText + Operator.SQUARE_ROOT.code() + "(");
    }

    private void plusMinusActionPerformed(JLabel equationLabel) {
        var equationLabelText = equationLabel.getText();
        if (equationLabelText.startsWith("(-")) {
            if (equationLabelText.length() > 2) {
                var equationLabelUpdatedText = equationLabelText.substring(2);
                if (equationLabelUpdatedText.startsWith("(")) {
                    equationLabel.setText(equationLabelUpdatedText.substring(1));
                } else {
                    equationLabel.setText(equationLabelUpdatedText);
                }
            } else {
                equationLabel.setText("");
            }
        } else {
            var isExpression = equationLabelText.split("[" + Operator.PLUS.code() + "\\-" + Operator.MULTIPLY.code() + Operator.DIVIDE.code() + Operator.POWER.code() + Operator.SQUARE_ROOT.code() + "]").length > 1;
            if (isExpression) {
                equationLabel.setText("(" + Operator.SUBTRACT.code() + "(" + equationLabelText);
            } else {
                equationLabel.setText("(" + Operator.SUBTRACT.code() + equationLabelText);
            }
        }
    }
}
