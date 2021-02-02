import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        String str=scn.next();
        
        printSS(str,"");
    }

    public static void printSS(String str, String ans) {
        if(str.length() == 0) {
            System.out.println(ans);
            return;
        }

        char ch=str.charAt(0);
        String remstr=str.substring(1);
        
        //ch -> yes choice
        printSS(remstr , ans+ch);
        
        //ch -> no choice
        printSS(remstr , ans);
    }

}
