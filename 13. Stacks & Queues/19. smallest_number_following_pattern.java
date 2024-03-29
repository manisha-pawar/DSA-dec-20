import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // code
        solve(str);
    }

    public static void solve(String str) {
        Stack < Integer > st = new Stack < > ();
        int n = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == 'd') {
                n++;
                st.push(n);
            } else if (ch == 'i') {
                n++;
                st.push(n);

                while (st.size() > 0) {
                    System.out.print(st.pop());
                }
            }
        }

        n++;
        st.push(n);


        while (st.size() > 0) {
            System.out.print(st.pop());
        }
    }
}