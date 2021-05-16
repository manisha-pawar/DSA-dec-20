import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        
        int[][]cost = new int[n][3];
        
        for(int i=0;i < n;i++) {
            for(int j=0;j<3;j++) {
                cost[i][j] = scn.nextInt();
            }
        }
        
        int ans = paintHouse2(cost);
        System.out.println(ans);
    }
    
    public static int paintHouse1(int[][]cost) {
        int or = 0,og = 0, ob = 0;
        
        for(int i = 0;i < cost.length;i++) {
            int nr = cost[i][0] + Math.min(ob,og);
            int ng = cost[i][1] + Math.min(or,ob);
            int nb = cost[i][2] + Math.min(or,og);
            
            or = nr;
            og = ng;
            ob = nb;
        }
        
        return Math.min(Math.min(or,og),ob);
    }
    
    public static int paintHouse2(int[][]cost) {
        int[][]dp = new int[cost.length][3];
        
        for(int i=0;i < dp.length;i++) {
            for(int j=0;j < 3;j++) {
                
                if(i == 0) {
                    dp[i][j] = cost[i][j];
                }
                else if(j == 0) {
                    dp[i][j] = cost[i][j] + Math.min(dp[i-1][1],dp[i-1][2]);
                }
                else if(j == 1){
                    dp[i][j] = cost[i][j] + Math.min(dp[i-1][0],dp[i-1][2]);
                }
                else if(j == 2) {
                    dp[i][j] = cost[i][j] + Math.min(dp[i-1][0],dp[i-1][1]);
                }
            }
        }
        
        int n = cost.length;
        
        return Math.min(Math.min(dp[n-1][0],dp[n-1][1]),dp[n-1][2]);
    }
}