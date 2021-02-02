import java.io.*;
import java.util.*;

public class Main {
    
    static String[]codes = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"}; 
    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        
        printKPC(str,"");
    }

    public static void printKPC(String str, String asf) {
        if(str.length() == 0) {
            System.out.println(asf);
            return;
        }        
        
        char ch = str.charAt(0); // '5'
        String remstr = str.substring(1); // "79"
        
        String mycode = codes[ch-'0']; // codes[5] -> mno
        
        for(int i=0; i < mycode.length();i++) {
            char mych = mycode.charAt(i);
            printKPC(remstr,asf + mych);
        }
    }

}
