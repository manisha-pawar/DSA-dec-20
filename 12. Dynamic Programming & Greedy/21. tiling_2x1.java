import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        
        int ans = tiling(n);
        System.out.println(ans);
    }
    
    public static int tiling(int n) {
        int[]dp = new int[n+1];
        
        //dp[i] -> total ways to tile up 2*i area
        
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i=3; i <= n;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[n];
    }
}