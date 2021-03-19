import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }

    public static class Interval implements Comparable < Interval > {
        int st;
        int et;

        Interval() {

        }

        Interval(int st, int et) {
            this.st = st;
            this.et = et;
        }

        //-ve value -> this < o
        //+ve value -> this > o
        //0 value -> this == o
        public int compareTo(Interval o) {
            return this.st - o.st;
        }

    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time
        int n = arr.length;
        Interval[] intervals = new Interval[n];

        //fill this interval array
        for (int i = 0; i < n; i++) {
            int ist = arr[i][0];
            int iet = arr[i][1];

            Interval temp = new Interval(ist, iet);
            intervals[i] = temp;
        }

        Arrays.sort(intervals);

        Stack < Interval > st = new Stack < > ();
        st.push(intervals[0]); // push first interval

        for (int i = 1; i < n; i++) {
            Interval curr = intervals[i];
            Interval top = st.peek();

            if (top.et >= curr.st) {
                top.et = Math.max(curr.et, top.et);
            } else {
                st.push(curr);
            }
        }


        //print your ans
        Stack < Interval > helper = new Stack < > ();

        while (st.size() > 0) {
            helper.push(st.pop());
        }

        while (helper.size() != 0) {
            Interval temp = helper.pop();
            System.out.println(temp.st + " " + temp.et);
        }


    }

}