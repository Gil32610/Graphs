package GraphWithMatrix.TopologicalSortMatrix;

import GraphWithMatrix.Graph;
import GraphWithMatrix.GraphNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        ArrayList<GraphNode> nodeList = new ArrayList<>();
        nodeList.add(new GraphNode('A',0));
        nodeList.add(new GraphNode('B',1));
        nodeList.add(new GraphNode('C',2));
        nodeList.add(new GraphNode('D',3));
        nodeList.add(new GraphNode('E',4));
        nodeList.add(new GraphNode('F',5));
        nodeList.add(new GraphNode('G',6));
        nodeList.add(new GraphNode('H',7));

        Graph graph = new Graph(nodeList);

        graph.addDirectedEdge(0,2);
        graph.addDirectedEdge(2,4);

        graph.addDirectedEdge(4,7);
        graph.addDirectedEdge(4,5);

        graph.addDirectedEdge(5,6);
        graph.addDirectedEdge(1,2);
        graph.addDirectedEdge(1,3);

        graph.addDirectedEdge(3,5);
        Stack<Integer> stack = graph.topologicalDfsStart();
        Character[] order = new Character[stack.size()];
        for (int i = 0; i < order.length; i++) {
            order[i] = nodeList.get(stack.pop()).getName();
        }

        System.out.println("Topological sort index order:");
        System.out.println(Arrays.deepToString(order));
        System.out.println();
        System.out.println("Undirected Graph Modeling:");
        graph.printUndirectedGraph();


    }
}
