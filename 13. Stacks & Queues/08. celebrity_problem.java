import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"


        Stack < Integer > st = new Stack < > ();
        for (int i = 0; i < arr.length; i++) {
            st.push(i);
        }

        //rejection
        while (st.size() >= 2) {
            int i = st.pop();
            int j = st.pop();

            if (arr[i][j] == 1) {
                //i knows j -> i can't be a celebrity
                st.push(j);
            } else if (arr[i][j] == 0) {
                //i doesn't knows j -> j can't be a celebrity
                st.push(i);
            }
        }

        int pc = st.peek(); //potential celebrity

        boolean isCeleb = true;

        //row check
        for (int i = 0; i < arr.length; i++) {
            if (arr[pc][i] == 1) {
                isCeleb = false;
                break;
            }
        }

        //col check
        for (int i = 0; i < arr.length; i++) {
            if (i != pc && arr[i][pc] == 0) {
                isCeleb = false;
                break;
            }
        }

        if (isCeleb == true) {
            System.out.println(pc);
        } else {
            System.out.println("none");
        }

    }

}