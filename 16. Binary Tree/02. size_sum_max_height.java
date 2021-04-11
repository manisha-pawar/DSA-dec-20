import java.util.*;

public class Main {

    public static class Node {
        int data;
        Node left;
        Node right;

        Node() {

        }

        Node(int data) {
            this.data = data;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair() {

        }

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] data) {
        Stack < Pair > st = new Stack < > ();

        Node root = new Node(data[0]);

        Pair root_pair = new Pair(root, 0);
        st.push(root_pair);

        int idx = 1;

        while (st.size() > 0) {
            Pair top = st.peek();

            if (top.state == 0) {
                //left child
                top.state++;

                if (data[idx] != null) {
                    Node lc = new Node(data[idx]);
                    top.node.left = lc;

                    Pair lcp = new Pair(lc, 0);
                    st.push(lcp);
                }
                idx++;

            } else if (top.state == 1) {
                //right child
                top.state++;

                if (data[idx] != null) {
                    Node rc = new Node(data[idx]);
                    top.node.right = rc;

                    Pair rcp = new Pair(rc, 0);
                    st.push(rcp);
                }
                idx++;
            } else if (top.state == 2) {
                st.pop();
            }
        }


        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = " <- " + node.data + " -> ";

        String left = (node.left != null) ? ("" + node.left.data) : ".";
        String right = (node.right != null) ? ("" + node.right.data) : ".";

        str = left + str + right;

        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    //size of binary tree
    public static int size(Node node) {
        if (node == null) {
            return 0;
        }

        int lsize = size(node.left);
        int rsize = size(node.right);

        return lsize + rsize + 1;
    }


    //sum of binary tree
    public static int sum(Node node) {
        if (node == null) {
            return 0;
        }

        int lsum = sum(node.left);
        int rsum = sum(node.right);

        return lsum + rsum + node.data;
    }

    //max of binary tree
    public static int max(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        int lmax = max(node.left);
        int rmax = max(node.right);

        return Math.max(Math.max(lmax, rmax), node.data);
    }

    //height of binary tree
    public static int height(Node node) {
        if (node == null) {
            return -1;
        }

        int lht = height(node.left);
        int rht = height(node.right);

        return Math.max(lht, rht) + 1;
    }

    public static void main(String[] args) {
        //input can be manages
    }
}