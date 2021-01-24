import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();

        // //1.relationship between row and column

        // for(int r=1;r<=n;r++) {
        //     for(int c=1;c<=n;c++) {
        //         if(r+c >= n+1) {
        //             System.out.print("*\t");
        //         }
        //         else if(r+c < n+1){
        //             System.out.print("\t");
        //         }
        //     }
        //     System.out.println();
        // }

        //2. split each row's work

        int spc = n - 1;
        int stc = 1;

        for (int r = 1; r <= n; r++) {
            //print spaces
            for (int i = 1; i <= spc; i++) {
                System.out.print("\t");
            }
            //print stars
            for (int i = 1; i <= stc; i++) {
                System.out.print("*\t");
            }

            System.out.println();
            spc--;
            stc++;
        }

    }
}
