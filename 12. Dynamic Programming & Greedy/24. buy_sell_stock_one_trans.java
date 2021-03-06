import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        
        int[]prices = new int[n];
        
        for(int i=0;i < prices.length;i++) {
            prices[i] = scn.nextInt();
        }
        
        int ans = SingleTranscn(prices);
        System.out.println(ans);
    }
    
    public static int SingleTranscn(int[]prices) {
        int minsf = Integer.MAX_VALUE;
        int op = 0;
        
        for(int i=0 ; i < prices.length;i++) {
            //maintain min so far
            
            if(prices[i] < minsf) {
                minsf = prices[i];
            }
            
            int cp = prices[i]-minsf;
            
            if(cp > op) {
                op = cp;
            }
        }
        
        return op;
    }

}