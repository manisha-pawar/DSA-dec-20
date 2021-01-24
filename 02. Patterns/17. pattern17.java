import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        int mid = (n + 1) / 2;

        // //1. row splitting
        // int rstar = 1;


        // for (int r = 1; r <= n; r++) {
        //     //print spaces
        //     int spc = (r == mid) ? 0 : n / 2;
        //     for (int i = 1; i <= spc; i++) {
        //         System.out.print("\t");
        //     }

        //     //print left stars
        //     int lstar = (r == mid) ? n / 2 : 0;
        //     for (int i = 1; i <= lstar; i++) {
        //         System.out.print("*\t");
        //     }

        //     //print right stars
        //     for (int i = 1; i <= rstar; i++) {
        //         System.out.print("*\t");
        //     }

        //     System.out.println();
        //     if (r < mid) {
        //         rstar++;
        //     } else {
        //         rstar--;
        //     }
        // }

        //2. relation between row and col

        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                if (r == mid || c == mid) {
                    System.out.print("*\t");
                } 
                else if (r < mid && c > mid && c - r <= n / 2) {
                    System.out.print("*\t");
                } 
                else if (r > mid && c > mid && r + c <= (3 * n + 1) / 2) {
                    System.out.print("*\t");
                } 
                else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }

    }
}
