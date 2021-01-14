import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        printSubsets(arr);
    }

    public static void printSubsets(int[] arr) {
        int n = arr.length;
        int tns = (int) Math.pow(2, n); //total number of subsets

        for (int d = 0; d < tns; d++) {
            int[] subset = decimalToBinary(d, n);

            //print this subset
            for (int i = 0; i < n; i++) {
                if (subset[i] == 0) {
                    System.out.print("-\t");
                } 
                else if (subset[i] == 1) {
                    System.out.print(arr[i] + "\t");
                }
            }
            System.out.println();
        }
    }

    public static int[] decimalToBinary(int num, int len) {
        int[] bin = new int[len];
        int idx = len - 1;

        while (num > 0) {
            int rem = num % 2;
            num = num / 2;

            bin[idx] = rem;
            idx--;
        }

        return bin;
    }

}
