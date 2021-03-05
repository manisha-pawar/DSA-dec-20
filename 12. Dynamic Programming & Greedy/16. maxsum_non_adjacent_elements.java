import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        
        int[]arr=new int[n];
        
        for(int i=0;i<n;i++) {
            arr[i]=scn.nextInt();
        }
        
        int ans = maximumSumNA(arr);
        System.out.println(ans);
    }
    
    public static int maximumSumNA(int[]arr) {
        int oinc = arr[0];
        int oexc = 0;
        
        for(int i=1; i < arr.length;i++) {
            int ninc = oexc + arr[i];
            int nexc = Math.max(oinc,oexc);
            
            oinc = ninc;
            oexc = nexc;
        }
        
        return Math.max(oinc,oexc);
    }
}