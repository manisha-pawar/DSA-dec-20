import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();

        for (int r = n; r >= 1; r--) {
            for (int st = 1; st <= r; st++) {
                System.out.print("*\t");
            }
            System.out.println();
        }
    }
}
