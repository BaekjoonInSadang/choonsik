package CH11;

import java.util.Arrays;
import java.util.Comparator;

public class ConnectIsland {

    public static void main(String[] args) {

        int n = 4;
        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};

        Edge[] edges = Arrays.stream(costs)
                .map(edge -> new Edge(edge[0], edge[1], edge[2]))
                .sorted(Comparator.comparingInt(e -> e.cost))
                .toArray(Edge[]::new);

        Node[] nodes = new Node[4];

        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }

        System.out.println("edges = " + Arrays.toString(edges));

        int totalCost = 0;

        for (Edge edge : edges) {
            Node node1 = nodes[edge.u];
            Node node2 = nodes[edge.v];

            if(node1.isConnected(node2)) continue;
            node1.merge(node2);
            totalCost += edge.cost;

        }

        System.out.println("nodes = " + Arrays.toString(nodes));



        System.out.println("totalCost = " + totalCost);
    }

    public static class Node {
        public Node parent = null;

        public boolean isConnected(Node o) {
            return root() == o.root();
        }

        public void merge(Node o) {
            if (isConnected(o)) return;
            o.parent = this;
        }

        private Node root() {
            if (parent == null) return this;
            return parent = parent.root();
        }

        @Override
        public String toString() {
            return "[" + "parent=" + parent +  ']';
        }
    }

    public static class Edge {
        public final int u;
        public final int v;
        public final int cost;

        public Edge(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "u=" + u +
                    ", v=" + v +
                    ", cost=" + cost +
                    '}';
        }
    }

}
