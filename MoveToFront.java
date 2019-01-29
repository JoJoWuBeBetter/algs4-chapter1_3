/* *****************************************************************************
 *  Name: Ex40
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class MoveToFront implements Iterable<String> {
    private Node first;
    private int N;

    private class Node {
        String item;
        Node next;
    }

    public MoveToFront(String string) {
        String strings[] = string.split("");
        for (int i = 0; i < strings.length; i++) {
            add(strings[i]);
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void add(String string) {
        Node node = new Node();
        node.item = string;
        node.next = first;
        first = node;
        Node current = first;

        while (current.next != null) {
            if (current.next.item.equals(string)) {
                current.next = current.next.next;
            }
            else {
                current = current.next;
            }
        }
        N++;
    }

    public Iterator<String> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<String> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
        }

        public String next() {
            String item = current.item;
            current = current.next;
            return item;
        }
    }


    public static void main(String[] args) {
        MoveToFront m = new MoveToFront("3123333322145567546asddafgagdfg132sg1h65sfgh");
        for (String s : m) {
            StdOut.println(s);
        }
    }
}
