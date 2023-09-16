package view;

import controller.RPNController;
import model.AnyStack;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Notação Polonesa Reversa
        AnyStack<Integer> stack = new AnyStack<>();
        RPNController RPN = new RPNController();
        Scanner scan = new Scanner(System.in);

        System.out.println("Reverse Polish Notation Calculator\n");
        System.out.println("Inform a number or an operation (+, -, *, /)\nType 'clear' to clean the stack or 'end' to finish.");

        String input;
        do {
            input = scan.next();
            if (input.equals("end")) {
                System.err.println("exiting...");
                System.exit(1);
            }
            RPN.InsertValue(stack, input);
        } while (true);
    }
}
