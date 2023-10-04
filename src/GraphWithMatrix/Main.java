package GraphWithMatrix;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<GraphNode> nodeList = new ArrayList<>();
        nodeList.add(new GraphNode('A',0));
        nodeList.add(new GraphNode('B',1));
        nodeList.add(new GraphNode('C',2));
        nodeList.add(new GraphNode('D',3));
        nodeList.add(new GraphNode('E',4));

        Graph g = new Graph(nodeList);
        g.addUndirectedEdge(0,1);
        g.addUndirectedEdge(0,3);
        g.addUndirectedEdge(0,2);
        g.addUndirectedEdge(1,4);
        g.addUndirectedEdge(3,2);
        System.out.println(g);
        g.BFS(0);
        System.out.println(Arrays.deepToString(g.getPrevious()));
        System.out.println(Arrays.deepToString(g.getDistance()));
        System.out.println(Arrays.deepToString(g.getCor()));
    }
}
