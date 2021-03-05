import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        int k=scn.nextInt();
        
        if(n == 1) {
            System.out.println(k);
            return;
        }
        
        int ans = paintFence(n,k);
        System.out.println(ans);
    }
    
    public static int paintFence(int n,int k) {
        int osc = 0; //last two fence are painted with same color
        int odc = 0; //last two fence are painted with different color
        
        
        for(int i=2; i <= n;i++) {
            int nsc = 0;
            int ndc = 0;
            
            if(i == 2) {
                nsc = k;
                ndc = k*(k-1);
            }
            else {
                int total = osc + odc;
                nsc = odc;
                ndc = total*(k-1);
            }
            
            osc = nsc;
            odc = ndc;
            
        }
        
        return osc + odc;
    }
}