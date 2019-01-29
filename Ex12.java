/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

public class Ex12 {
    public static Stack<String> copy(Stack<String> a) {
        Stack<String> b = new Stack<String>();
        Stack<String> c = new Stack<String>();
        for (String s : a) b.push(s);
        for (String s : b) c.push(s);
        return c;

    }
}
