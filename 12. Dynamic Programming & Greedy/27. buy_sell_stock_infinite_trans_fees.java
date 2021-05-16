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
        
        int fees = scn.nextInt();
        
        int ans = infiniteTranscnFees(prices,fees);
        System.out.println(ans);
    }
    
    public static int infiniteTranscnFees(int[]prices,int fees) {
        int ob = -prices[0];
        int os = 0;
        
        for(int i=1;i < prices.length;i++) {
            int nb = 0;
            int ns = 0;
            
            //new buy state
            if(ob < os - prices[i]) {
                nb = os - prices[i];
            }
            else {
                nb = ob;
            }
            
            //new sell state
            if(os < ob + prices[i] - fees) {
                ns = ob + prices[i] - fees;
            }
            else {
                ns = os;
            }
            
            ob = nb;
            os = ns;
        }
        
        return os;
    }

}