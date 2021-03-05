import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
       Scanner scn = new Scanner(System.in);
       int n=scn.nextInt();
       int k=scn.nextInt();
       
       long ans = partitionIntoKss(n,k);
       System.out.println(ans);
   }
   
   public static long partitionIntoKss(int n,int k) {
       long[][]dp = new long[n+1][k+1];
       
       //dp[i][j] -> ways to partition i elements into k subsets
       
       for(int e=1 ; e < dp.length;e++) {
           for(int s=1; s < dp[0].length;s++) {
               if(e == s) {
                   dp[e][s] = 1;
               }
               else if(e < s) {
                   dp[e][s] = 0;
               }
               else {
                   dp[e][s] = dp[e-1][s-1] + (s)*dp[e-1][s];
               }
           }
       }
       
       return dp[n][k];
       
   }
}