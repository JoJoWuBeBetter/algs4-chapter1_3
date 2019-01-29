/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.io.File;

public class Ex43 {
    public static void main(String[] args) {
        File f = new File("C:\\cup_project");
        String[] fList = f.list();
        for (int i = 0; i < fList.length; i++) {
            StdOut.println(fList[i]);
        }
    }
}
