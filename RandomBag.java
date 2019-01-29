/* *****************************************************************************
 *  Name: Ex34
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomBag<Item> implements Iterable<Item> {
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

    public void add(Item item) {
        checkSize();
        a[N++] = item;
    }

    public Iterator<Item> iterator() {
        return new RandomBagIterator();
    }

    private class RandomBagIterator implements Iterator<Item> {  // 支持后进先出的迭代
        private int i = N;
        private Item[] bag = a;

        public boolean hasNext() {
            return i > 0;
        }

        public Item next() {
            int index = StdRandom.uniform(0, i);
            Item item = a[index];
            for (int j = index; j < i - 1; j++) {
                bag[j] = bag[j + 1];
            }
            a[--i] = null;
            return item;
        }

        public void remove() {
        }
    }

    public static void main(String[] args) {
        RandomBag<Integer> rb = new RandomBag<Integer>();
        rb.add(1);
        rb.add(2);
        rb.add(3);
        rb.add(4);
        rb.add(5);
        rb.add(6);
        rb.add(7);
        rb.add(8);
        rb.add(9);
        for (Integer s : rb) {
            StdOut.println(s);
            StdOut.println();
        }
    }
}
