import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        
        int[]coins = new int[n];
        
        for(int i=0;i<n;i++) {
            coins[i]=scn.nextInt();
        }
        
        int amt = scn.nextInt();
        
        int ans=coinChangePerm(coins,amt);
        System.out.println(ans);
    }
    
    public static int coinChangePerm(int[]coins,int amt) {
        int[]dp = new int[amt+1];
        
        //dp[i] -> total permutations to pay 'i' amount
        
        dp[0] = 1;
        
        for(int i=1;i < dp.length;i++) {
            
            for(int j=0; j < coins.length;j++) {
                int rem_amt = i - coins[j];
                
                if(rem_amt >= 0) {
                    dp[i] += dp[rem_amt];
                }
                
            }
        }
        
        return dp[amt];
    }
}