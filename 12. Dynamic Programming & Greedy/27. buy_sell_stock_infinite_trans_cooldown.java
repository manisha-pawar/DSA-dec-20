import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[]prices = new int[n];
        
        for(int i=0;i < n;i++) {
            prices[i] = scn.nextInt();
        }
        
        int ans = infiniteTranscnCooldown(prices);
        System.out.println(ans);
        
    }
    
    public static int infiniteTranscnCooldown(int[]prices) {
        int ob = -prices[0];
        int os = 0;
        int oc = 0;
        
        for(int i=1 ;i < prices.length;i++) {
            int nb = 0;
            int ns = 0;
            int nc = 0;
            
            //new buy state
            if(ob < oc - prices[i]) {
                nb = oc - prices[i];
            }
            else {
                nb = ob;
            }
            
            //new sell state
            if(os < ob + prices[i]) {
                ns = ob + prices[i];
            }
            else {
                ns = os;
            }
            
            //new cooldown state
            if(oc < os + 0) {
                nc = os + 0;
            }
            else {
                nc = oc;
            }
            
            ob = nb;
            os = ns;
            oc = nc;
        }
        
        return os;
    }

}