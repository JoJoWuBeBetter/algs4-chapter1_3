/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Ex31<Item> implements Iterable<Item> {
    private DoubleNode first;
    private DoubleNode last;
    private int N;

    private class DoubleNode {
        Item item;
        DoubleNode next;
        DoubleNode prev;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private void insertHead(Item item) {
        DoubleNode node = new DoubleNode();
        node.item = item;
        if (first == null) {
            first = node;
            last = node;
        }
        else {
            DoubleNode oldFirst = first;
            first = node;
            first.next = oldFirst;
            oldFirst.prev = first;
        }
        N++;
    }

    private void insertEnd(Item item) {
        DoubleNode node = new DoubleNode();
        node.item = item;
        if (first == null) {
            first = node;
            last = node;
        }
        else {
            DoubleNode oldLast = last;
            last = node;
            oldLast.next = last;
            last.prev = oldLast;
        }
        N++;
    }

    private void insertBefore(DoubleNode node, Item item) {

        if (N < 2) {
            insertHead(item);
        }
        else {
            DoubleNode insertNode = new DoubleNode();
            insertNode.item = item;
            DoubleNode prevNode = node.prev;
            prevNode.next = null;
            node.prev = insertNode;
            insertNode.next = node;
            prevNode.next = insertNode;
            insertNode.prev = prevNode;
        }
        N++;
    }

    private void insertAfter(DoubleNode node, Item item) {

        if (N < 2) {
            insertEnd(item);
        }
        else {
            DoubleNode insertNode = new DoubleNode();
            insertNode.item = item;
            DoubleNode nextNode = node.next;
            nextNode.prev = null;
            node.next = insertNode;
            insertNode.prev = node;

            insertNode.next = nextNode;
            nextNode.prev = insertNode;
        }
        N++;
    }

    private void delNode(DoubleNode node) {

        if (N == 1) {
            first = null;
            last = null;
        }
        else {
            DoubleNode prevNode = node.prev;
            DoubleNode nextNode = node.next;

            node.prev = null;
            node.next = null;

            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
        N--;
    }

    private void delHead() {
        if (N == 1) {
            first = null;
            last = null;
        }
        else if (isEmpty()) {
            return;
        }
        else {
            DoubleNode oldFirst = first;
            first = first.next;
            first.prev = null;
            oldFirst.next = null;
        }
        N--;
    }

    private void delEnd() {
        if (N == 1) {
            first = null;
            last = null;
        }
        else if (isEmpty()) {
            return;
        }
        else {
            DoubleNode oldLast = last;
            last = last.prev;
            last.next = null;
            oldLast.prev = null;
        }
        N--;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private DoubleNode current = first;

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
        Ex31<Integer> test = new Ex31<Integer>();
        test.insertHead(1);
        test.insertHead(2);
        // test.insertHead(3);
        // test.insertEnd(4);
        test.delEnd();
        // test.insertBefore(test.first, 4);
        StdOut.println(test.size());
        StdOut.println();
        // StdOut.println(test.first.item);

        for (int s : test) {
            StdOut.println(s);
        }

    }
}
