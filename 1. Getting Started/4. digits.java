//print digits from left to right

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here  
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        
        int d=0,temp=n;
        //count digits of a number
        while(temp != 0) {
            d++;
            temp = temp/10;
        }
        
        int pow = 1;
        int i = 0;
        
        //calculate 10^(d-1)
        while(i < (d-1)) {
            pow = pow * 10;
            i++;
        }
        
        //print digits from left to right
        while(pow != 0) {
            int ld = n / pow;
            System.out.println(ld);
            n = n % pow;
            pow = pow/10;
        }
    }
}
