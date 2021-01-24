import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        
        int a=0; // second last term
        int b=1; // last term
        int c=0; // current term
        
        for(int i=1;i<=n;i++) {
            System.out.println(a);
            c = a+b;
            a = b;
            b = c;
        }
        
    }
}
