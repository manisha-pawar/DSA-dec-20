import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        
        long ans = arrangeBuildings(n);
        System.out.println(ans);
    }
 
    public static long arrangeBuildings(int n) {
        int ob = 1;
        int os = 1;
        
        for(int i=2; i <= n;i++) {
            int nb = os;
            int ns = ob + os;
            
            os = ns;
            ob = nb;
        }
        
        int ways = os + ob;
        long ans = ways*(long)ways;
        
        return ans;
        
    }

}