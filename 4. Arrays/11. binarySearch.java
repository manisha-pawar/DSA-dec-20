import java.util.Scanner;

public class Main {

    public static int search(int[] ar, int key) {

        //Write your code here.
        int left = 0;
        int right = ar.length - 1;
        int pos = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (ar[mid] == key) {
                pos = mid;
                break;
            }
            else if (ar[mid] > key) {
                //discard right area
                right = mid - 1;
            }
            else if (ar[mid] < key) {
                //discard left area
                left = mid + 1;
            }
        }

        return pos;

    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = s.nextInt();
        }
        int key = s.nextInt();
        System.out.println(search(ar, key));
    }
}
