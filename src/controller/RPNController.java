package controller;

import model.AnyStack;

public class RPNController {

    public void InsertValue(AnyStack<Integer> stack, String input) {
        if (input.contains("+") || input.contains("-") || input.contains("*") || input.contains("/")) {
            System.out.println("result: " + RPN_Operation(stack, input));
        }else if (input.equals("clear")) {
            StackCleaner(stack);
        } else {
            try {
                int number = Integer.parseInt(input);
                stack.push(number);
            } catch (NumberFormatException invalid) {
                System.err.println("Invalid input detected: " + invalid.getMessage() + "\nTry again.");
            }
        }
    }

    private int RPN_Operation(AnyStack<Integer> stack, String op) {
        int result = 0;
        if (stack.size() < 2) {
            System.err.println("Insufficient stacked values.");
        } else {
            try {
                int value1 = stack.pop();
                int value2 = stack.pop();
                switch (op) {
                    case "+" -> stack.push(value1 + value2);
                    case "-" -> stack.push(value2 - value1);
                    case "*" -> stack.push(value1 * value2);
                    case "/" -> stack.push(value2 / value1);
                    default -> System.err.println("Invalid operation\nTry again.");
                }
                result = stack.top();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return result;
    }

    private void StackCleaner(AnyStack<Integer> stack) {
        try {
            while (stack != null) {
                stack.pop();
            }
        } catch (Exception empty) {
            System.err.println("stack cleaned!");
        }
    }
}
