import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        
        int[]prices = new int[n];
        
        for(int i=0;i < n;i++) {
            prices[i] = scn.nextInt();
        }
        
        System.out.println(infiniteTranscn(prices));
    }
    
    public static int infiniteTranscn(int[]prices) {
        int bd = 0;
        int sd = 0;
        int profit = 0;
        
        for(int i=0; i < prices.length - 1;i++) {
            if(prices[i] < prices[i+1]) {
                sd=i+1;
            }
            else {
                profit += prices[sd] - prices[bd];
                bd = i+1;
                sd = i+1;
            }
        }
        
        profit += prices[sd] - prices[bd];
        
        return profit;
    }

}