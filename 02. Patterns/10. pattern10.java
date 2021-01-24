import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();

        //row =leftSpaces + leftStar (1) + middleSpaces + rightStar(1 or 0)

        int lspc = n / 2;
        int mspc = -1;

        for (int r = 1; r <= n; r++) {
            //print leftSpaces
            for (int i = 1; i <= lspc; i++) {
                System.out.print("\t");
            }

            //print leftStar
            System.out.print("*\t");

            //print middleSpaces
            for (int i = 1; i <= mspc; i++) {
                System.out.print("\t");
            }

            //rstar
            if (r != 1 && r != n) {
                System.out.print("*\t");
            }

            System.out.println();

            if (r < (n + 1) / 2) {
                lspc--;
                mspc += 2;
            } else {
                lspc++;
                mspc -= 2;
            }
        }

    }
}
