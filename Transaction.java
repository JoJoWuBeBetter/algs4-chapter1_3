/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class Transaction {
    private String who;
    private Date when;
    private double amount;

    public Transaction(String who, Date when, double amount) {
        this.who = who;
        this.when = when;
        this.amount = amount;
    }

    public Transaction(String transaction) {
        who = transaction.split("#")[0];
        int mouth = Integer.parseInt(transaction.split("#")[1].split("-")[1]);
        int day = Integer.parseInt(transaction.split("#")[1].split("-")[2]);
        int year = Integer.parseInt(transaction.split("#")[1].split("-")[0]);
        when = new Date(mouth, day, year);
        amount = Double.parseDouble(transaction.split("#")[2]);
    }

    public String toString() {
        return who + "#" + when + "#" + amount;
    }

    public static Transaction[] readTransactions(String string) {
        String[] transactions = string.split(" ");
        Queue<Transaction> q = new Queue<Transaction>();
        for (int i = 0; i < transactions.length; i++) {
            q.enqueue(new Transaction(transactions[i]));
        }

        Transaction[] result = new Transaction[transactions.length];
        for (int i = 0; i < transactions.length; i++) {
            result[i] = q.dequeue();
        }
        return result;
    }

    public boolean equals(Object x) {
        if (this == x) return true;
        if (x == null) return false;
        if (this.getClass() != x.getClass()) return false;
        Transaction that = (Transaction) x;
        if (!this.who.equals(that.who)) return false;
        if (!this.when.equals(that.when)) return false;
        if (this.amount != that.amount) return false;
        return true;
    }

    public static void main(String[] args) {
        Transaction a = new Transaction("JoJo#2018-05-27#1000");
        Transaction b = new Transaction("JoJo#2018-05-27#1000");
        StdOut.println(a.equals(b));
    }
}
