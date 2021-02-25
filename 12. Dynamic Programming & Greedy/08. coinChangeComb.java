import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        
        int[]coins = new int[n];
        
        for(int i=0;i<coins.length;i++) {
            coins[i]=scn.nextInt();
        }
        
        int amt = scn.nextInt();
        
        int ans = coinChangeComb(coins,amt);
        
        System.out.println(ans);
    }
    
    public static int coinChangeComb(int[]coins,int amt) {
        int[]dp = new int[amt+1];
        
        //dp[i] -> number of combinations to pay 'i' amount
        dp[0]=1;
        
        for(int i=0;i < coins.length;i++) {
            
            for(int j=coins[i];j < dp.length;j++) {
                int rem_amt = j - coins[i];
                dp[j] += dp[rem_amt];
            }
        }
        
        return dp[amt];
    }
}