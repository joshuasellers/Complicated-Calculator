package Complicated.Calculator;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;
import java.util.Stack;

public final class Helper {
    private Helper() {
        // private constructor to prevent instantiation
    }

    public static void addobjects(Component c, Container container, GridBagLayout layout, 
                                GridBagConstraints gbc, int gx, int gy, int gw, int gh){

        // Set gridx, gridy, gridwidth, gridheight for GridBagConstraints
        gbc.gridx = gx;
        gbc.gridy = gy;

        gbc.gridwidth = gw;
        gbc.gridheight = gh;

        layout.setConstraints(c, gbc);
        container.add(c);
    }

    // Method is used to get the precedence of operators
    private static boolean letterOrDigit(char c)
    {
        // boolean check
        if (Character.isLetterOrDigit(c))
            return true;
        else
            return false;
    }

    // Operator having higher precedence
    // value will be returned
    static int getPrecedence(char ch)
    {

        if (ch == '+' || ch == '-')
            return 1;
        else if (ch == '*' || ch == '/')
            return 2;
        else if (ch == '^')
            return 3;
        else
            return -1;
    }
    
      // Operator has Left --> Right associativity
      static boolean hasLeftAssociativity(char ch) {
        if (ch == '+' || ch == '-' || ch == '/' || ch == '*') {
            return true;
        } else {
            return false;
        }
    }
  
    // Method converts  given infixto postfix expression
    // to illustrate shunting yard algorithm
    static String infixToRpn(String expression)
    {
        // Initialising an empty String
        // (for output) and an empty stack
        Stack<Character> stack = new Stack<>();

        // Initially empty string taken
        String output = new String("");

        // Iterating over tokens using inbuilt
        // .length() function
        for (int i = 0; i < expression.length(); ++i) {
            // Finding character at 'i'th index
            char c = expression.charAt(i);

            // If the scanned Token is an
            // operand, add it to output
            if (letterOrDigit(c))
                output += c;

            // If the scanned Token is an '('
            // push it to the stack
            else if (c == '(')
                stack.push(c);

            // If the scanned Token is an ')' pop and append
            // it to output from the stack until an '(' is
            // encountered
            else if (c == ')') {
                while (!stack.isEmpty()
                       && stack.peek() != '(')
                    output += stack.pop();

                stack.pop();
            }

            // If an operator is encountered then taken the
            // further action based on the precedence of the
            // operator

            else {
                while (
                    !stack.isEmpty()
                    && getPrecedence(c)
                           <= getPrecedence(stack.peek()) 
                    && hasLeftAssociativity(c)) {
                    // peek() inbuilt stack function to
                    // fetch the top element(token)

                    output += stack.pop();
                }
                stack.push(c);
            }
        }

        // pop all the remaining operators from
        // the stack and append them to output
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "This expression is invalid";
            output += stack.pop();
        }
        return output;
    }

    public static double evaluateRpn(String equation) {
        // https://www.geeksforgeeks.org/java/java-program-to-implement-shunting-yard-algorithm/
        // Evaluate the RPN expression

        String rpn = infixToRpn(equation.replaceAll(" ", ""));
        String[] rpnTokens = rpn.split("");
        
        Stack<Double> stack = new Stack<>();

        for (String token : rpnTokens) {
            if (token.matches("-?\\d+(\\.\\d+)?")) { // Check if it's a number
                stack.push(Double.parseDouble(token));
            } else { // It's an operator
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(operand1 + operand2);
                        break;
                    case "-":
                        stack.push(operand1 - operand2);
                        break;
                    case "*":
                        stack.push(operand1 * operand2);
                        break;
                    case "/":
                        stack.push(operand1 / operand2);
                        break;
                    case "^":
                        stack.push(Math.pow(operand1, operand2));
                        break;
                }
            }
        }
        return stack.pop();
    }
}
