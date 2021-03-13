import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // code
        postfix_evaluation_conversions(exp);
    }

    public static void postfix_evaluation_conversions(String exp) {
        Stack < Integer > eval = new Stack < > ();
        Stack < String > in = new Stack < > ();
        Stack < String > pre = new Stack < > ();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch >= '0' && ch <= '9') {
                eval.push(ch - '0'); in .push(ch + "");
                pre.push(ch + "");
            } else if (ch == '+' || ch == '-' || ch == '/' || ch == '*') {
                char opr = ch;
                //evaluate in eval stack
                int v2 = eval.pop();
                int v1 = eval.pop();
                int val = operation(v1, v2, opr);
                eval.push(val);

                //evaluate in infix stack
                String inV2 = in .pop();
                String inV1 = in .pop();
                String inVal = "(" + inV1 + opr + inV2 + ")"; in .push(inVal);

                //evaluate in prefix stack
                String preV2 = pre.pop();
                String preV1 = pre.pop();
                String preVal = opr + preV1 + preV2;
                pre.push(preVal);
            }
        }

        System.out.println(eval.peek());
        System.out.println( in .peek());
        System.out.println(pre.peek());
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