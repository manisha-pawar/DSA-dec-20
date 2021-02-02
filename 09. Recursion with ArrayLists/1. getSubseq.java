import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        String str = scn.next();
        
        ArrayList<String>ans=gss(str); // expectation [,c,b,bc,a,ac,ab,abc]
        System.out.println(ans);
    }

    public static ArrayList < String > gss(String str) {
        if(str.length() == 0) {
            ArrayList<String>base=new ArrayList<>();
            base.add("");
            return base;
        }
        
        char ch = str.charAt(0); // a
        String remstr = str.substring(1); //bc
        
        ArrayList<String>recans = gss(remstr); //faith [,c,b,bc]
        ArrayList<String>myans = new ArrayList<>();
        
        //ch -> no choice
        for(int i=0; i < recans.size();i++) {
            myans.add(recans.get(i));
        }
        
        //ch -> yes choice
        for(int i=0; i < recans.size();i++) {
            myans.add(ch + recans.get(i));
        }
        
        return myans;
        
    }

}
