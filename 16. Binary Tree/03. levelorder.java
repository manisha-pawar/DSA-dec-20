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


    public static void levelOrder(Node node) {
        Queue < Node > q = new ArrayDeque < > ();

        q.add(node);

        while (q.size() > 0) {
            int s = q.size();

            for (int i = 0; i < s; i++) {
                Node rem = q.remove();
                System.out.print(rem.data + " ");

                //left child
                if (rem.left != null) {
                    q.add(rem.left);
                }

                //right child
                if (rem.right != null) {
                    q.add(rem.right);
                }
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        //input can be managed
    }
}