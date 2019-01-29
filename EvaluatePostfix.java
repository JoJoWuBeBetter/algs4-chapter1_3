/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class EvaluatePostfix {
    public static void main(String[] args) {
        String[] strings = StdIn.readString().split("");
        Stack<Integer> numStack = new Stack<Integer>();
        for (int i = 0; i < strings.length; i++) {
            switch (strings[i]) {
                case "+":
                    numStack.push(numStack.pop() + numStack.pop());
                    break;
                case "-":
                    numStack.push(numStack.pop() - numStack.pop());
                    break;
                case "*":
                    numStack.push(numStack.pop() * numStack.pop());
                    break;
                case "/":
                    numStack.push(numStack.pop() / numStack.pop());
                    break;
                default:
                    int num = Integer.parseInt(strings[i]);
                    numStack.push(num);
            }
        }
        StdOut.println(numStack.pop());
    }
}
