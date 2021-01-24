import java.io.*;
import java.util.*;

public class Main {

    public static void solution(String str) {
        //write your code here
        for (int st = 0; st < str.length(); st++) {
            for (int et = st; et < str.length(); et++) {

                String substr = str.substring(st, et + 1);

                if (isPalindrome(substr) == true) {
                    System.out.println(substr);
                }
            }
        }
    }

    public static boolean isPalindrome(String str) {
        int li = 0;
        int ri = str.length() - 1;

        while (li < ri) {
            char lch = str.charAt(li);
            char rch = str.charAt(ri);

            if (lch == rch) {
                li++;
                ri--;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        solution(str);
    }

}
