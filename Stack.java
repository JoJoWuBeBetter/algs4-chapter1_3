/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
    private Node first;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public Stack(Stack<Item> s) { // Ex42
        Stack<Item> temp = new Stack<Item>();
        for (Item i : s) {
            temp.push(i);
        }
        for (Item i : temp) {
            this.push(i);
        }
    }

    public Stack() {

    }


    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public Item peek() {
        return first.item;
    }

    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(1);
        s.push(2);
        Stack<Integer> s2 = new Stack<Integer>(s);
        s.pop();
        for (int i : s) {
            StdOut.println(i);
        }


        StdOut.println();

        for (int i : s2) {
            StdOut.println(i);
        }
    }
}
