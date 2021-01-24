import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        toh(n, 1, 2, 3); // expectation -> move n disks from src to dest
    }

    public static void toh(int n, int src, int helper, int dest) {
        if (n == 0) {
            return;
        }

        //faith -> move n-1 disks from src to helper
        toh(n - 1, src, dest, helper);
        //move nth disk from src to dest
        System.out.println("Move disk " + n + " from rod " + src + " to rod " + dest);
        //faith -> move n-1 disks from helper to destination
        toh(n - 1, helper, src, dest);
    }


}
