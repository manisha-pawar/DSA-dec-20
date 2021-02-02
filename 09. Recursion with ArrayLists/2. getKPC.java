import java.io.*;
import java.util.*;

public class Main {
    
    static String[]codes = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    
    public static void main(String[] args) throws Exception {
       Scanner scn=new Scanner(System.in);
       String str = scn.next();
       
       ArrayList<String>ans = getKPC(str);
       System.out.println(ans);
    }

    public static ArrayList < String > getKPC(String str) {
        if(str.length() == 0) {
            ArrayList<String>base=new ArrayList<>();
            base.add("");
            return base;
        }
        
        char ch = str.charAt(0); // '5'
        String remstr = str.substring(1); // "79"
        
        ArrayList<String>recans = getKPC(remstr); // ["ty","tz","uy","uz"]
        ArrayList<String>myans = new ArrayList<>();
        
        String mycode = codes[ch-'0']; // "mno"
        
        for(int i=0;i < mycode.length();i++) {
            char mych = mycode.charAt(i); //'m' , 'n' , 'o'
            
            for(int j=0; j < recans.size();j++) {
                myans.add(mych + recans.get(j));
            }
        }
        
        return myans;
        
    }

}
