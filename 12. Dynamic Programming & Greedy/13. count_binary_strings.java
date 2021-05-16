import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        
        int ans = cbs(n);
        System.out.println(ans);
    }
 
    public static int cbs(int n) {
        int o_zero = 1;
        int o_one = 1;
        
        for(int i=2; i <= n;i++) {
            int n_zero = o_one;
            int n_one = o_zero + o_one;
            
            o_one = n_one;
            o_zero = n_zero;
        }
        
        return o_one + o_zero;
    }

}