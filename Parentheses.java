/* *****************************************************************************
 *  Name:Ex04
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class Parentheses {
    String[] strings;
    Stack<String> stack;

    public Parentheses(String input) {
        strings = input.split("");
        stack = new Stack<String>();
    }

    public boolean isTrue() {
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals("[") || strings[i].equals("(") || strings[i].equals("{")) {
                stack.push(strings[i]);
            }
            else {
                switch (strings[i]) {
                    case "]":
                        if (!stack.pop().equals("[")) {
                            return false;
                        }
                        break;
                    case ")":
                        if (!stack.pop().equals("(")) {
                            return false;
                        }
                        break;
                    case "}":
                        if (!stack.pop().equals("{")) {
                            return false;
                        }
                        break;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String input1 = "[()]{}{[()()]()}";
        String input2 = "[(])";
        Parentheses p1 = new Parentheses(input1);
        StdOut.println(p1.isTrue());
        Parentheses p2 = new Parentheses(input2);
        StdOut.println(p2.isTrue());
    }
}
