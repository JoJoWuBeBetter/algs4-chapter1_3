/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class Ex9 {
    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<String>();
        Stack<String> symbolStack = new Stack<String>();
        String input = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) * 9 - 5 ) ) ) )";
        String[] strings = input.split(" ");
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals("+") || strings[i].equals("-") || strings[i].equals("/")
                    || strings[i].equals("*")) {
                symbolStack.push(strings[i]);
            }
            else if (strings[i].equals(")")) {
                String string2 = stringStack.pop();
                StdOut.println(string2);
                String string1 = stringStack.pop();
                StdOut.println(string1);
                stringStack.push("( " + string1 + " " + symbolStack.pop() + " " + string2 + " )");
            }
            else {
                stringStack.push(strings[i]);
            }
        }
        StdOut.println(stringStack.pop());
        StdOut.println(stringStack.pop());

    }
}

