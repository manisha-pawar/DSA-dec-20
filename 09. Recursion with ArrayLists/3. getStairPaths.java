import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        
        ArrayList<String>ans = getStairPaths(n);
        System.out.println(ans);
    }

    public static ArrayList < String > getStairPaths(int n) {
       if(n == 0) {
           ArrayList<String>base = new ArrayList<>();
           base.add("");
           return base;
       }
           
        if(n < 0) {
            ArrayList<String>base = new ArrayList<>();
            return base;
        }
       
       
       ArrayList<String>nm1To0 = getStairPaths(n-1); // n-1 to 0
       ArrayList<String>nm2To0 = getStairPaths(n-2); // n-2 to 0
       ArrayList<String>nm3To0 = getStairPaths(n-3); // n-3 to 0
       
       ArrayList<String>nTo0 = new ArrayList<>();
       
       //n to 0 = n to n-1(1 step) + n-1 to 0
       for(int i=0;i < nm1To0.size(); i++) {
           nTo0.add("1" + nm1To0.get(i));
       }
       
       //n to 0 = n to n-2(2 step) + n-2 to 0
       for(int i=0;i < nm2To0.size(); i++) {
           nTo0.add("2" + nm2To0.get(i));
       }
       
       //n to 0 = n to n-3(3 step) + n-3 to 0
       for(int i=0;i < nm3To0.size(); i++) {
           nTo0.add("3" + nm3To0.get(i));
       }
       
       return nTo0;
    }

}
