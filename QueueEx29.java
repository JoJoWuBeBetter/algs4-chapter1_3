/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class QueueEx29<Item> {
    private Node last;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return last == null;
    }

    public void enqueue(Item item) {
        if (isEmpty()) {
            last = new Node();
            last.item = item;
            last.next = last;
        }
        else {

            Node current = last.next;

            Node node = new Node();
            node.item = item;
            node.next = current;

            last.next = node;
            last = node;
        }
        N++;

    }

    public Item dequeue() {
        Item index = last.next.item;
        if (N == 1) {
            last = null;
        }
        else {
            last.next = last.next.next;
        }
        return index;
    }

    public static void main(String[] args) {
        QueueEx29<Integer> q = new QueueEx29<Integer>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.dequeue();
        q.dequeue();
        StdOut.println(q.last.item);
        StdOut.println(q.last.next.item);
        StdOut.println(q.last.next.next.item);
        StdOut.println(q.last.next.next.next.item);
        StdOut.println(q.last.next.next.next.next.item);
    }
}
