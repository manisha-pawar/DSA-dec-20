import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[]val = new int[n];
        int[]wt = new int[n];
        
        for(int i=0;i < n;i++) {
            val[i]=scn.nextInt();
        }
        
        for(int i=0;i < n;i++) {
            wt[i]=scn.nextInt();
        }
        
        int cap = scn.nextInt();
        
        int ans = knapsack_01(val,wt,cap);
        System.out.println(ans);
    }
    
    public static int knapsack_01(int[]val,int[]wt,int cap) {
        int n=val.length;
        
        int[][]dp = new int[n+1][cap+1];
        
        for(int i=0; i < dp.length;i++) {
            for(int j=0;j < dp[0].length;j++) {
                
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                else {
                    int no = dp[i-1][j]; //item -> no
                    
                    int it = i-1; // ith row -> i-1 item
                    
                    int yes = 0;
                    
                    if(j >= wt[it]) {
                        yes = val[it] + dp[i-1][j - wt[it]]; //item -> yes
                    }
                    
                    dp[i][j] = Math.max(no,yes);
                    
                }
            }
        }
        
        return dp[dp.length-1][dp[0].length-1];
        
    }
}