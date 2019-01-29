/* *****************************************************************************
 *  Name: Ex14
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class ResizingArrayQueueOfStrings {
    private String[] a = new String[1];
    private int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }


    private void resize(int max) {
        String[] temp = new String[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public void enqueue(String string) {
        a[N++] = string;
        if (N == a.length) {
            resize(2 * a.length);
        }
    }

    public String dequeue() {
        String item = a[0];
        for (int i = 0; i < N; i++) {
            a[i] = a[i + 1];
            a[i + 1] = null;
        }
        N--;
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    public static void main(String[] args) {
        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        // StdOut.println(queue.size());
        StdOut.println(queue.dequeue());
        StdOut.println(queue.dequeue());
        StdOut.println(queue.dequeue());
        StdOut.println(queue.dequeue());
        // StdOut.println(queue.size());

    }
}
