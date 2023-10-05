package GraphWithMatrix;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<GraphNode> nodeList = new ArrayList<>();
        nodeList.add(new GraphNode(10,0));
        nodeList.add(new GraphNode(15,1));
        nodeList.add(new GraphNode(1,2));
        nodeList.add(new GraphNode(5,3));

        Graph g = new Graph(nodeList);
        g.addUndirectedEdge(0,1);
        g.addUndirectedEdge(0,3);
        g.addUndirectedEdge(1,2);
        System.out.println(g);
        System.out.println(g.startDFS(0,26));

        System.out.println(Arrays.deepToString(g.getPrevious()));
        System.out.println(Arrays.deepToString(g.getDistance()));
        System.out.println(Arrays.deepToString(g.getCor()));
    }
}
