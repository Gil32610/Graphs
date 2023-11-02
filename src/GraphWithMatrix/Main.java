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
        int sumTarget = 20;
        System.out.println("Sum Target: "+ sumTarget);
        printListNodes(nodeList);
        System.out.println("Output : " + g.startDFS(0,sumTarget));
        System.out.println("Previous: "+ Arrays.deepToString(g.getPrevious()));
        System.out.println("Distance: " + Arrays.deepToString(g.getDistance()));
        System.out.println("Color: "+ Arrays.deepToString(g.getCor()));
    }

    public static void printListNodes(ArrayList<GraphNode> nodeList){
        for (int i = 0; i <nodeList.size() ; i++) {
            System.out.println("Node: " + nodeList.get(i).getValue());
        }
    }
}
