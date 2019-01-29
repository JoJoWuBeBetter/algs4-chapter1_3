/* *****************************************************************************
 *  Name: Ex33
 *  Date:
 *  Description:
 **************************************************************************** */

public class Deque<Item> {
    private Node left;
    private Node right;
    private int N;

    private class Node {
        Item item;
        Node next;
        Node prev;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void pushLeft(Item item) {
        Node node = new Node();
        node.item = item;

        if (N == 0) {
            left = node;
            right = node;
        }
        else if (N == 1) {
            left = node;
            left.next = right;
            right.prev = node;
        }
        else {
            Node oldLeft = left;
            left = node;
            left.next = oldLeft;
            left.next.prev = left;
        }
        N++;
    }

    public void pushRight(Item item) {
        Node node = new Node();
        node.item = item;

        if (N == 0) {
            left = node;
            right = node;
        }
        else if (N == 1) {
            right = node;
            left.next = right;
            right.prev = left;
        }
        else {
            Node oldRight = right;
            right = node;
            right.prev = oldRight;
            right.prev.next = left;
        }
        N++;
    }

    public Item popLeft() {
        Item item = left.item;
        if (N == 1) {
            left = null;
            right = null;
        }
        else {
            left = left.next;
        }
        N--;
        return item;
    }

    public Item popRight() {
        Item item = right.item;
        if (N == 1) {
            left = null;
            right = null;
        }
        else {
            right = right.next;
        }
        N--;
        return item;
    }

    public static void main(String[] args) {
        Deque<Integer> q = new Deque<Integer>();
        q.pushLeft(1);
        q.pushRight(2);
    }
}
