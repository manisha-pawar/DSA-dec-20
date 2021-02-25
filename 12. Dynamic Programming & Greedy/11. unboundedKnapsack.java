import java.io.*;
	import java.util.*;

	public class Main {

	    public static void main(String[] args) throws Exception {
            Scanner scn = new Scanner(System.in);
            int n=scn.nextInt();
            
            int[]wt=new int[n];
            int[]val=new int[n];
            
            for(int i=0;i < n;i++) {
                val[i]=scn.nextInt();
            }
            
            for(int i=0;i < n;i++) {
                wt[i]=scn.nextInt();
            }
            
            int cap = scn.nextInt();
            
            int ans = unboundedKS(val,wt,cap);
            
            System.out.println(ans);
	    }
	    
	    public static int unboundedKS(int[]val,int[]wt,int cap) {
	        int[]dp = new int[cap+1];
	        
	        dp[0] = 0;
	        
	        for(int i=1; i < dp.length;i++) {
	            
	            int max = 0;
	            for(int j=0; j < wt.length;j++) {
	                int rem_cap = i - wt[j];
	                
	                if(rem_cap >= 0) {
	                    int temp = dp[rem_cap] + val[j];
	                    
	                    if(temp > max) {
	                        max = temp;
	                    }
	                }
	            }
	            
	            dp[i] = max;
	        }
	        
	        return dp[cap];
	    }
	}