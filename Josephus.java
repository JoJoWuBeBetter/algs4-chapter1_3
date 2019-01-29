/* *****************************************************************************
 *  Name: Ex37
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class Josephus {
    private Node last;
    private int N;

    private class Node {
        int index;
        Node next;
    }

    public Josephus(int count) {
        for (int i = 0; i < count; i++) {
            enqueue(i);
        }
    }

    public boolean isEmpty() {
        return last == null;
    }

    public void kill(int num) {
        int j = 1;
        int count = N;
        Node oldLast = last;
        while (count > 0) {
            if (j == num) {
                j = 1;
                count--;
                int index = oldLast.next.index;
                oldLast.next = oldLast.next.next;
                StdOut.print(index + " ");
            }
            else {
                oldLast = oldLast.next;
                j++;
            }

        }
    }

    public void enqueue(int index) {
        if (isEmpty()) {
            last = new Node();
            last.index = index;
            last.next = last;
        }
        else {

            Node current = last.next;

            Node node = new Node();
            node.index = index;
            node.next = current;

            last.next = node;
            last = node;
        }
        N++;

    }

    public static void main(String[] args) {
        int count = Integer.parseInt(args[0]);
        int killNum = Integer.parseInt(args[1]);
        Josephus a = new Josephus(count);
        a.kill(killNum);
        StdOut.println();
    }
}
