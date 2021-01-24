import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        int spc = 2 * n - 3;

        for (int r = 1; r <= n; r++) {
            //print left values
            int lvalc = r;
            int lst = 1;
            for (int i = 1; i <= lvalc; i++) {
                System.out.print(lst + "\t");
                lst++;
            }

            //print spaces
            for (int i = 1; i <= spc; i++) {
                System.out.print("\t");
            }

            //print right values
            int rvalc = (r == n) ? r - 1 : r;
            int rst = (r == n) ? r - 1 : r;
            for (int i = 1; i <= rvalc; i++) {
                System.out.print(rst + "\t");
                rst--;
            }

            System.out.println();
            spc -= 2;

        }

    }
}
