package CH11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindWay {

    public static void main(String[] args) {

        int[][] nodeInfo = {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};


        Node[] nodes = new Node[nodeInfo.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i+1, nodeInfo[i][0], nodeInfo[i][1]);
        }

        Arrays.sort(nodes, (a,b) -> b.y - a.y);

        Node root = constructTree(nodes);

        ArrayList<Integer> preOrder = new ArrayList<>();
        pre(root,preOrder);

        ArrayList<Integer> postOrder = new ArrayList<>();
        post(root,postOrder);

        List<List<Integer>> result = new ArrayList<>();
        result.add(preOrder);
        result.add(postOrder);

        System.out.println("result = " + result);
    }

    private static void pre(Node node, List<Integer> visits) {
        if( node == null) return;

        visits.add(node.value);
        pre(node.left, visits);
        pre(node.right,visits);
    }

    private static void post(Node node, List<Integer> visits) {
        if( node == null) return;

        pre(node.left, visits);
        pre(node.right,visits);
        visits.add(node.value);
    }

    private static Node constructTree(Node[] nodes) {
        Node root = nodes[0];

        for (int i = 1; i < nodes.length; i++) {
            insert(root,nodes[i]);
        }

        return root;
    }

    private static void insert(Node root, Node node) {
        if(node.x < root.x) {
            // 왼쪽 서브 트리에
            if(root.left == null) {
                root.left = node;
            } else {
                insert(root.left, node);
            }
        } else {
            // 오른쪽 서브 트리에
            if(root.right == null) {
                root.right = node;
            } else {
                insert(root.right, node);
            }
        }


    }
    private static class Node {
        public final int value;
        public final int x;
        public final int y;

        public Node left;
        public Node right;

        private Node(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }


    }
}
