import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();

        //select a row
        for (int r = 1; r <= n; r++) {
            //print r stars
            for (int st = 1; st <= r; st++) {
                System.out.print("*\t");
            }
            System.out.println();
        }

    }
}
