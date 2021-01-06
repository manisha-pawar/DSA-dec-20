import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];

        //take input in array
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int ans = span(arr);
        System.out.println(ans);
    }

    public static int span(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }

            if (arr[i] < min) {
                min = arr[i];
            }
        }

        int ans = max - min;
        return ans;
    }

}
