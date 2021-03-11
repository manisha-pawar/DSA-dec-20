import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        // code
        int area = largest_area_histogram(a);
        System.out.println(area);
    }

    public static int largest_area_histogram(int[] heights) {
        int[] nsl = nextSmallerLeft(heights);
        int[] nsr = nextSmallerRight(heights);

        int max = 0;

        for (int i = 0; i < heights.length; i++) {
            int ans = heights[i] * (nsr[i] - nsl[i] - 1);

            if (ans > max) {
                max = ans;
            }
        }

        return max;
    }

    public static int[] nextSmallerLeft(int[] arr) {
        int n = arr.length;
        int[] nsl = new int[n];
        Stack < Integer > st = new Stack < > ();

        nsl[0] = -1;
        st.push(0);

        for (int i = 1; i < n; i++) {
            while (st.size() > 0 && arr[i] <= arr[st.peek()]) {
                st.pop();
            }

            if (st.size() == 0) {
                nsl[i] = -1;
            } else {
                nsl[i] = st.peek();
            }

            st.push(i);
        }

        return nsl;
    }

    public static int[] nextSmallerRight(int[] arr) {
        int n = arr.length;
        int[] nsr = new int[n];
        Stack < Integer > st = new Stack < > ();

        nsr[n - 1] = n;
        st.push(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            while (st.size() > 0 && arr[i] <= arr[st.peek()]) {
                st.pop();
            }

            if (st.size() == 0) {
                nsr[i] = n;
            } else {
                nsr[i] = st.peek();
            }

            st.push(i);
        }

        return nsr;
    }
}