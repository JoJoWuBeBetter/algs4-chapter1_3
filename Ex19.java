/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Ex19<Item> implements Iterable<Item> {
    private Node first;  // 链表的首结点

    public class Node {
        Item item;
        Node next;
    }

    public void add(Item item) {  // 和Stack 的push() 方法完全相同
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public void removeLast() { // Ex 19
        Node last = first;
        Node newNetx = new Node();

        while (last.next != null) {
            newNetx = last;
            last = last.next;
        }
        newNetx.next = null;
    }

    public void delete(int k) { // Ex20
        Node node = first;
        Node nodeFater = new Node();

        for (int i = 0; i < k; i++) {
            nodeFater = node;
            node = node.next;
        }
        nodeFater.next = node.next;
    }

    public boolean find(String key) { // Ex21
        Node node = first;
        while (node.next != null) {
            if (node.item.equals(key)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void removeAfter(Node node) {  //  Ex24
        if (node == null || node.next == null) {
            return;
        }
        Node tepm = new Node();
        while (node.next != null) {
            tepm.next = node.next.next;
            node.next = null;
            node = tepm;
        }
    }

    public void insertAfter(Node insertNode, Node node) {
        if (insertNode == null || node == null) {
            return;
        }

        insertNode.next = node.next;
        node.next = insertNode;
    }

    // public Item max(Node node) {
    //     if (node == null) {
    //         return null;
    //     }
    //
    //     if (node.next == null) {
    //         return node.item;
    //     }
    //
    //     if (node.item > node.next.item) {
    //         node.next = node.next.next;
    //         return max(node);
    //     }
    //
    //     return max(node.next);
    // }

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
        Ex19<Integer> nums = new Ex19<Integer>();
        nums.add(3);
        nums.add(2);
        nums.add(1);
        // nums.removeAfter(nums.first.next.next);
        // nums.max(nums.first);

        for (int s : nums) {
            StdOut.println(s);
        }
    }
}
