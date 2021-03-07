import java.util.*;

public class Main {
    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[]arr = new int[n];
        
        for(int i=0;i < arr.length;i++) {
            arr[i]=scn.nextInt();
        }
        
        int[]nsl = nextSmallerLeft(arr);
        
        System.out.println("Next Smaller on Left -> ");
        for(int i=0;i < n;i++) {
            System.out.print(nsl[i] + " ");
        }
        System.out.println();
        
    }
    
    public static int[] nextSmallerLeft(int[]arr) {
        int n=arr.length;
        int[]nsl = new int[n];
        
        Stack<Integer>st = new Stack<>();
        nsl[0]=-1;
        st.push(arr[0]);
        
        for(int i=1; i < n;i++) {
            while(st.size() > 0 && arr[i] < st.peek()) {
                st.pop();
            }
            
            if(st.size() == 0) {
                nsl[i] = -1;
            }
            else {
                nsl[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return nsl;
    }
    
    public static int[] nextSmallerRight(int[]arr) {
        int n=arr.length;
        int[]nsr = new int[n];
        
        Stack<Integer>st = new Stack<>();
        nsr[n-1]=-1;
        st.push(arr[n-1]);
        
        for(int i=n-2; i >= 0;i--) {
            while(st.size() > 0 && arr[i] < st.peek()) {
                st.pop();
            }
            
            if(st.size() == 0) {
                nsr[i] = -1;
            }
            else {
                nsr[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return nsr;
    }
    
    public static int[] nextGreaterLeft(int[]arr) {
        int[]ngl = new int[arr.length];
        Stack<Integer>st = new Stack<>();
        ngl[0]=-1;
        st.push(arr[0]);
        
        for(int i=1; i < arr.length;i++) {
            while(st.size() > 0 && arr[i] > st.peek()) {
                st.pop();
            }
            
            if(st.size() == 0) {
                ngl[i] = -1;
            }
            else {
                ngl[i] = st.peek();
            }
            
            st.push(arr[i]);
        }
        
        return ngl;
    }
}