import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        int[][]cost = new int[n][k];
        
        for(int i=0;i < n;i++) {
            for(int j=0;j < k;j++) {
                cost[i][j] = scn.nextInt();
            }
        }
        
        int ans = paintHouse_ManyColors(cost);
        
        System.out.println(ans);
    }
    
    public static int paintHouse_ManyColors(int[][]cost) {
        int n = cost.length;
        int k = cost[0].length;
        
        int[][]dp = new int[n][k];
        
        int omin = Integer.MAX_VALUE;
        int osmin = Integer.MAX_VALUE;
        
        for(int i=0; i < n;i++) {
            int cmin = Integer.MAX_VALUE;
            int csmin = Integer.MAX_VALUE;
            
            for(int j=0 ; j < k;j++) {
                if(i == 0) {
                    dp[i][j] = cost[i][j];
                }
                else {
                    if(dp[i-1][j] == omin) {
                        dp[i][j] = cost[i][j] + osmin;
                    }
                    else {
                        dp[i][j] = cost[i][j] + omin;
                    }
                }
                
                if(dp[i][j] < cmin) {
                    csmin = cmin;
                    cmin = dp[i][j];
                }
                else if(dp[i][j] < csmin) {
                    csmin = dp[i][j];
                }
                
            }
            
            omin = cmin;
            osmin = csmin;
        }
        
        return omin;
    }
}