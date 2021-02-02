import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();
        
        ArrayList<String>ans=getMazePaths(0,0,n-1,m-1);
        System.out.println(ans);
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList < String > getMazePaths(int sr, int sc, int dr, int dc) {
       if(sr == dr && sc == dc) {
           ArrayList<String> base = new ArrayList<>();
           base.add("");
           return base;
       }
       
       if(sr > dr || sc > dc) {
           ArrayList<String> base = new ArrayList<>();
           return base;
       }
        
       ArrayList<String>horToDest =  getMazePaths(sr,sc+1,dr,dc); // horizontal
       ArrayList<String>verToDest = getMazePaths(sr+1,sc,dr,dc); // vertical
       
       ArrayList<String>srcToDest = new ArrayList<>();
       
       //src to Dest =  src to hor ("h") +  hor to Dest
       for(int i=0;i<horToDest.size();i++) {
           srcToDest.add("h" + horToDest.get(i));
       }
       
        //src to Dest =  src to ver ("v") +  ver to Dest
       for(int i=0;i<verToDest.size();i++) {
           srcToDest.add("v" + verToDest.get(i));
       }
       
       return srcToDest;
       
    }

}
