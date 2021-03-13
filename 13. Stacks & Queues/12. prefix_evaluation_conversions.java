import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // code
        prefix_evaluation_conversion(exp);
    }

    public static void prefix_evaluation_conversion(String prefix) {
        Stack < Integer > eval = new Stack < > ();
        Stack < String > in = new Stack < > ();
        Stack < String > post = new Stack < > ();

        for (int i = prefix.length() - 1; i >= 0; i--) {
            char ch = prefix.charAt(i);

            if (ch >= '0' && ch <= '9') {
                eval.push(ch - '0'); in .push(ch + "");
                post.push(ch + "");
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                char opr = ch;
                //evaluation in eval stack
                int v1 = eval.pop();
                int v2 = eval.pop();
                int val = operation(v1, v2, opr);
                eval.push(val);

                //evaluation in infix stack
                String inV1 = in .pop();
                String inV2 = in .pop();
                String inVal = "(" + inV1 + opr + inV2 + ")"; 
                in.push(inVal);

                //evaluation in postfix stack
                String postV1 = post.pop();
                String postV2 = post.pop();
                String postVal = postV1 + postV2 + opr;
                post.push(postVal);

            }
        }

        System.out.println(eval.peek());
        System.out.println(in.peek());
        System.out.println(post.peek());

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