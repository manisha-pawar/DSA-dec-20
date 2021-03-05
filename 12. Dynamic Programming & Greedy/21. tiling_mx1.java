import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        
        int ans = tiling(n,m);
        System.out.println(ans);
    }
    
    public static int tiling(int n,int m) {
        //total ways to tile up m*n area using tile of m*1
        
        int[]dp = new int[n+1];
        
        //dp[i] -> total ways to tile up m*i area
        
        for(int w=1; w <= n;w++) {
            
            if(w < m) {
                dp[w] = 1;
            }
            else if(w == m) {
                dp[w] = 2;
            }
            else {
                dp[w] = dp[w-1] + dp[w-m];
            }
        }
        
        return dp[n];
        
    }
}