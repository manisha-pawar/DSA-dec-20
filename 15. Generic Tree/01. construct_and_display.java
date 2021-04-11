import java.util.*;

public class Main {
    public static class Node {
        int data;
        ArrayList<Node>children = new ArrayList<>();
    }
    
    public static Node construct(int[]data) {
        Stack<Node>st = new Stack<>();
        Node root = null;
        
        for(int i=0;i < data.length;i++) {
            if(data[i] == -1) {
                st.pop();
            }
            else {
                Node n = new Node();
                n.data = data[i];
                
                if(st.size() == 0) {
                    root = n;
                }
                else {
                    st.peek().children.add(n);
                }
                
                st.push(n);
                
            }
        }
        
        return root;
    }
    
    public static void display(Node root) {
        System.out.print(root.data + "->");
        
        //print root's children
        for(int i=0; i < root.children.size();i++) {
            Node child = root.children.get(i);
            System.out.print(child.data + ",");
        }
        System.out.println(".");
        
         for(int i=0; i < root.children.size();i++) {
            Node child = root.children.get(i);
            display(child);
        }
        
    }
    
    public static void main(String[]args) {
        int[]arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        Node root=construct(arr);
        // System.out.println(root.data + " " + root.children.size());
        display(root); 
    }
}