/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;


public class InfixToPostfix {
    public static void main(String[] args) {
        String string = "( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )";
        String[] strings = string.split(" ");
        Stack<String> stack = new Stack<String>();
        String output = "";
        for (int i = 0; i < strings.length; i++) {
            switch (strings[i]) {
                case "+":
                case "-":
                case "*":
                case "/":
                    stack.push(strings[i]);
                    break;
                case "(":
                    break;
                case ")":
                    output += stack.pop();
                    break;
                default:
                    output += strings[i];
            }
        }
        StdOut.println(output);
    }
}
