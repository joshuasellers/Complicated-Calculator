package Complicated.Calculator;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
    private static boolean stringOrDigit(String s)
    {
        // boolean check
        if (s.matches("-?\\d+(\\.\\d+)?"))
            return true;
        else
            return false;
    }

    // Operator having higher precedence
    // value will be returned
    static int getPrecedence(String s)
    {

        if (s.equals("+") || s.equals("-"))
            return 1;
        else if (s.equals("*") || s.equals("/"))
            return 2;
        else if (s.equals("^"))
            return 3;
        else if (s.equals("sin") || s.equals("cos") || s.equals("tan") || s.equals("log"))
            return 4;
        else
            return -1;
    }
    
      // Operator has Left --> Right associativity
      static boolean hasLeftAssociativity(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*")) {
            return true;
        } else {
            return false;
        }
    }
  
    // Method converts  given infixto postfix expression
    // to illustrate shunting yard algorithm
    static String infixToRpn(String[] expression)
    {
        // Initialising an empty String
        // (for output) and an empty stack
        Stack<String> stack = new Stack<>();

        // Initially empty string taken
        String output = new String("");

        // Iterating over tokens using inbuilt
        // .length() function
        for (int i = 0; i < expression.length; ++i) {
            // Finding character at 'i'th index
            String s = expression[i];
            System.out.println("Token: " + s);

            // If the scanned Token is an
            // operand, add it to output
            if (stringOrDigit(s)) {
                output += s;
                output += " ";
            }

            // If the scanned Token is an '('
            // push it to the stack
            else if (s.equals("(")) {
                stack.push(s);
            }

            // If the scanned Token is an ')' pop and append
            // it to output from the stack until an '(' is
            // encountered
            else if (s.equals(")")) {
                while (!stack.isEmpty()
                       && !stack.peek().equals("(")) {
                    output += stack.pop();
                    output += " ";
                }
                stack.pop();
            }

            // If an operator is encountered then taken the
            // further action based on the precedence of the
            // operator

            else {
                while (
                    !stack.isEmpty()
                    && getPrecedence(s)
                           <= getPrecedence(stack.peek()) 
                    && hasLeftAssociativity(s)) {
                    // peek() inbuilt stack function to
                    // fetch the top element(token)

                    output += stack.pop();
                    output += " ";
                }
                stack.push(s);
            }
        }

        // pop all the remaining operators from
        // the stack and append them to output
        while (!stack.isEmpty()) {
            if (stack.peek().equals("("))
                return "This expression is invalid";
            output += stack.pop();
            output += " ";
        }
        return output;
    }

    public static double evaluateRpn(String equation) {
        // https://www.geeksforgeeks.org/java/java-program-to-implement-shunting-yard-algorithm/
        // Evaluate the RPN expression

        String rpn = infixToRpn(equation.split(" "));
        System.out.println("RPN: " + rpn);
        String[] rpnTokens = rpn.split(" ");
        
        Stack<Double> stack = new Stack<>();

        for (String token : rpnTokens) {
            System.out.println("Evaluating token: " + token);
            if (token.matches("-?\\d+(\\.\\d+)?")) { // Check if it's a number
                stack.push(Double.parseDouble(token));
            } else { // It's an operator
                double operand2 = stack.pop();
                if (token.equals("sin") || token.equals("cos") || token.equals("tan") || token.equals("log")) {
                    // For unary operators, only one operand is needed
                    System.out.println("Applying unary operator: " + token + " to " + operand2);
                    switch (token) {
                        case "sin":
                            stack.push(Math.sin(operand2));
                            break;
                        case "cos":
                            stack.push(Math.cos(operand2));
                            break;
                        case "tan":
                            stack.push(Math.tan(operand2));
                            break;
                        case "log":
                            stack.push(Math.log10(operand2));
                            break;
                    }
                    continue; // Skip the rest of the loop
                }
                // For binary operators, pop the second operand
                double operand1 = stack.pop();
                System.out.println("Applying operator: " + token + " to " + operand1 + " and " + operand2);
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
