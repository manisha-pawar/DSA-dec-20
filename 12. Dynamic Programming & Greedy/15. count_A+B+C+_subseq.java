import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        
        int ans = countABC(str);
        System.out.println(ans);
    }
    
    public static int countABC(String str) {
        int a=0; // a+ nature count
        int ab=0; // a+b+ nature count
        int abc=0; //a+b+c+ nature count
        
        for(int i=0;i < str.length();i++) {
            char ch = str.charAt(i);
            
            if(ch == 'a') {
                a = 2*a + 1;
            }
            else if(ch == 'b') {
                ab = a + 2*ab;
            }
            else if(ch == 'c') {
                abc = ab + 2*abc;
            }
            else {
                //nothing to do
            }
        }
        
        return abc;
    }
}