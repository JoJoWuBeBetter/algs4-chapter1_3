/* *****************************************************************************
 *  Name: Ex33
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class ResizingArrayDeque<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[1];
    private int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void resize(int max) {  // 将栈移动到一个大小为max 的新数组
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++)
            temp[i] = a[i];
        a = temp;
    }

    private void checkSize() {

        if (N == a.length) {
            resize(2 * a.length);
        }
        else if (N < a.length / 4) {
            resize(a.length / 2);
        }
    }

    public void pushLeft(Item item) {
        checkSize();
        if (N != 0) {
            // StdOut.println(a.length);
            for (int i = N; i > 0; i--) {
                // StdOut.println(i);
                // StdOut.println(a[i]);
                a[i] = a[i - 1];
            }
        }
        a[0] = item;
        N++;
    }

    public void pushRight(Item item) {
        checkSize();
        a[N++] = item;
    }

    public Item popLeft() {
        Item item = a[0];
        if (N != 0) {
            for (int i = 0; i < N - 1; i++) {
                a[i] = a[i + 1];
            }
        }
        a[--N] = null;
        checkSize();
        return item;
    }

    public Item popRight() {
        Item item = a[--N];
        a[N] = null;
        checkSize();
        return item;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {  // 支持后进先出的迭代
        private int i = N;

        public boolean hasNext() {
            return i > 0;
        }

        public Item next() {
            return a[--i];
        }

        public void remove() {
        }
    }

    public static void main(String[] args) {
        ResizingArrayDeque<Integer> dq = new ResizingArrayDeque<Integer>();
        dq.pushLeft(1);
        dq.pushRight(4);
        // StdOut.println(dq.popLeft());
        StdOut.println(dq.popRight());
        StdOut.println();
        for (Integer s : dq) {
            StdOut.println(s);
        }
    }
}
