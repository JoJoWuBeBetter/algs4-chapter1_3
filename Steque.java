/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class Steque<Item> {
    private Node first;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Item enqueue() {
        Node node = first;
        Node current = new Node();
        while (node.next != null) {
            current = node;
            node = node.next;
        }
        current.next = null;
        N--;
        return node.item;

    }


    public static void main(String[] args) {
        Steque<Integer> sq = new Steque<Integer>();
        sq.push(1);
        sq.push(2);
        StdOut.println(sq.pop());
        StdOut.println(sq.enqueue());
    }
}
