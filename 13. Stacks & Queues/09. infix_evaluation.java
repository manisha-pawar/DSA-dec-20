import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // code
        int ans = infix_evaluation(exp);
        System.out.println(ans);
    }

    public static int infix_evaluation(String str) {
        Stack < Character > oprtn = new Stack < > ();
        Stack < Integer > oprnd = new Stack < > ();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(') {
                oprtn.push(ch);
            } else if (ch >= '0' && ch <= '9') {
                oprnd.push(ch - '0');
            } else if (ch == ')') {
                //evaluation till '('
                while (oprtn.peek() != '(') {
                    char opr = oprtn.pop();

                    int v2 = oprnd.pop();
                    int v1 = oprnd.pop();

                    int val = operation(v1, v2, opr);
                    oprnd.push(val);
                }
                oprtn.pop(); // opening bracket 
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (oprtn.size() > 0 && oprtn.peek() != '(' && precedence(ch) <= precedence(oprtn.peek())) {
                    char opr = oprtn.pop();

                    int v2 = oprnd.pop();
                    int v1 = oprnd.pop();

                    int val = operation(v1, v2, opr);
                    oprnd.push(val);
                }

                oprtn.push(ch);
            }
        }

        while (oprtn.size() > 0) {
            char opr = oprtn.pop();

            int v2 = oprnd.pop();
            int v1 = oprnd.pop();

            int val = operation(v1, v2, opr);
            oprnd.push(val);
        }

        return oprnd.peek();
    }

    public static int precedence(char opr) {
        if (opr == '+' || opr == '-') {
            return 1;
        } else if (opr == '*' || opr == '/') {
            return 2;
        } else {
            return 0;
        }
    }

    public static int operation(int v1, int v2, char opr) {
        if (opr == '+') {
            return v1 + v2;
        } else if (opr == '-') {
            return v1 - v2;
        } else if (opr == '*') {
            return v1 * v2;
        } else if (opr == '/') {
            return v1 / v2;
        } else {
            return 0;
        }
    }
}