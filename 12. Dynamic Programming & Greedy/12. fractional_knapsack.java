import java.io.*;
import java.util.*;

public class Main {

    public static class Pair implements Comparable<Pair>{
        int wt;
        int price;
        double r; //price by wt
        
        Pair(int wt,int price) {
            this.wt = wt;
            this.price = price;
            this.r = price*1.0 / wt;
        }
        
        //-ve -> this < o
        //+ve -> this > o
        //0 -> this == o
        
        public int compareTo(Pair o) {
            if(this.r < o.r) {
                return -1;
            }
            else if(this.r > o.r) {
                return 1;
            }
            else {
                return 0;
            }
        }
    
    }
    
    public static double fractional_knapsack(int[]wt,int[]prices,int cap) {
        int n = wt.length;
        Pair[]item = new Pair[n];
        
        //fill item array
        for(int i=0; i < n;i++) {
            item[i] = new Pair(wt[i],prices[i]);
        }
        
        //sort item array
        Arrays.sort(item);
        
        int rc = cap; //remaining capacity
        int idx = n-1;
        double profit = 0;
        
        while(rc > 0) {
            Pair p = item[idx];
            
            if(rc >= p.wt) {
                profit += p.price;
                rc -= p.wt;
            }
            else {
                double pp = rc * p.r; //partial profit
                profit += pp;
                rc = 0;
            }
            
            idx--;
        }
        
        return profit;
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[]prices = new int[n];
        int[]wt = new int[n];
        
        for(int i=0; i < n;i++) {
            prices[i] = scn.nextInt();
        }
        
        for(int i=0; i < n;i++) {
            wt[i] = scn.nextInt();
        }
        
        int cap = scn.nextInt();
        
        double profit = fractional_knapsack(wt,prices,cap);
        System.out.println(profit);
    }
}