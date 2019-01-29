/* *****************************************************************************
 *  Name: Ex35
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomQueue<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[1];
    private int N;

    public boolean isEmpty() {
        return N == 0;
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

    public void enqueue(Item item) {
        checkSize();
        a[N++] = item;
    }

    public Item dequeue() {
        checkSize();
        if (N == 1) {
            return a[--N];
        }
        else {
            int index = StdRandom.uniform(0, N);
            Item item = a[index];
            a[index] = a[N - 1];
            a[--N] = null;
            return item;
        }
    }

    public Item sample() {
        if (N == 1) {
            return a[N - 1];
        }
        else {
            int index = StdRandom.uniform(0, N);
            Item item = a[index];
            a[index] = a[N - 1];
            a[N - 1] = item;
            return item;
        }
    }

    public Iterator<Item> iterator() {
        return new RandomQueueIterator();
    }

    private class RandomQueueIterator implements Iterator<Item> {  // 支持后进先出的迭代
        private int i = N;
        private Item[] queue = a;

        public boolean hasNext() {
            return i > 0;
        }

        public Item next() {
            int index = StdRandom.uniform(0, i);
            Item item = a[index];
            for (int j = index; j < i - 1; j++) {
                queue[j] = queue[j + 1];
            }
            a[--i] = null;
            return item;
        }

        public void remove() {
        }
    }


    public static void main(String[] args) {
        RandomQueue<Integer> q = new RandomQueue<Integer>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        StdOut.println(q.sample());
        StdOut.println();
        StdOut.println(q.dequeue());
        StdOut.println();
        for (Integer i : q) {
            StdOut.println(i);
        }

    }
}
