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
            ArrayList<String>base=new ArrayList<>();
            base.add("");
            return base;
        }
        
        ArrayList<String>srcToDest = new ArrayList<>();
        
        //horizontal moves
        for(int jump = 1; sc + jump <= dc;jump++) {
            ArrayList<String>HnbrToDest=getMazePaths(sr,sc + jump,dr,dc);
            
            for(int i=0;i < HnbrToDest.size();i++) {
                srcToDest.add("h"+ jump + HnbrToDest.get(i));
            }
        }
        
        //vertical moves
        for(int jump = 1; sr + jump <= dr;jump++) {
            ArrayList<String>VnbrToDest=getMazePaths(sr + jump,sc,dr,dc);
            
            for(int i=0;i < VnbrToDest.size();i++) {
                srcToDest.add("v"+ jump + VnbrToDest.get(i));
            }
        }
        
        //diagonal moves
        for(int jump = 1; sc + jump <= dc && sr + jump <= dr;jump++) {
            ArrayList<String>DnbrToDest=getMazePaths(sr + jump,sc + jump,dr,dc);
            
            for(int i=0;i < DnbrToDest.size();i++) {
                srcToDest.add("d"+ jump + DnbrToDest.get(i));
            }
        }
        
        return srcToDest;
    }

}
