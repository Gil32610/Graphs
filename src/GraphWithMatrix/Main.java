package GraphWithMatrix;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<GraphNode> nodeList = new ArrayList<>();
        nodeList.add(new GraphNode(2,0));
        nodeList.add(new GraphNode(7,1));
        nodeList.add(new GraphNode(2,2));
        nodeList.add(new GraphNode(6,3));
        nodeList.add(new GraphNode(5,4));
        nodeList.add(new GraphNode(11,5));
        nodeList.add(new GraphNode(5,6));
        nodeList.add(new GraphNode(9,7));
        nodeList.add(new GraphNode(4,8));

        Graph g = new Graph(nodeList);
        g.addUndirectedEdge(0,1);
        g.addUndirectedEdge(0,6);

        g.addUndirectedEdge(1,3);
        g.addUndirectedEdge(1,2);

        g.addUndirectedEdge(3,4);
        g.addUndirectedEdge(3,5);

        g.addUndirectedEdge(6,7);

        g.addUndirectedEdge(7,8);
        System.out.println(g);
        System.out.println(g.startDFS(0,20));

        System.out.println(Arrays.deepToString(g.getPrevious()));
        System.out.println(Arrays.deepToString(g.getDistance()));
        System.out.println(Arrays.deepToString(g.getCor()));
    }
}
