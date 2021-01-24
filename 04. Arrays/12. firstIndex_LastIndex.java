import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int key = scn.nextInt();
        int fi = firstIndex(arr, key);
        int li = lastIndex(arr, key);

        System.out.println(fi);
        System.out.println(li);
    }

    public static int firstIndex(int[] arr, int key) {
        int fi = -1;
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == key) {
                fi = mid;
                //go to left to find first index
                right = mid - 1;
            } 
            else if (arr[mid] > key) {
                right = mid - 1;
            } 
            else if (arr[mid] < key) {
                left = mid + 1;
            }
        }

        return fi;
    }

    public static int lastIndex(int[] arr, int key) {
        int li = -1;
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == key) {
                li = mid;
                //go to right to find last index
                left = mid + 1;
            } 
            else if (arr[mid] > key) {
                right = mid - 1;
            } 
            else if (arr[mid] < key) {
                left = mid + 1;
            }
        }

        return li;
    }

}
