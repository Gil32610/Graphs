package GraphWithMatrix.DfsTargetSum;

import GraphWithMatrix.Graph;
import GraphWithMatrix.GraphNode;

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
        nodeList.add(new GraphNode('F',5));
        nodeList.add(new GraphNode('G',6));
        nodeList.add(new GraphNode('H',7));
        nodeList.add(new GraphNode('I',8));

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
        System.out.println("Output : " + g.startSumTargetDFS(0,sumTarget));
        System.out.println("Previous: "+ Arrays.deepToString(g.getPrevious()));
        System.out.println("Distance: " + Arrays.deepToString(g.getDistance()));
        System.out.println("Color: "+ Arrays.deepToString(g.getCor()));

        g.dfsStart(0);
        System.out.println("\nThis is DFS previous nodes order:");
        System.out.println(Arrays.deepToString(g.getPrevious()));
        System.out.println("This is DFS time of start and time of end order:");
        System.out.println(Arrays.deepToString(g.getStart()));
        System.out.println(Arrays.deepToString(g.getEnd()));
    }

    public static void printListNodes(ArrayList<GraphNode> nodeList){
        for (int i = 0; i <nodeList.size() ; i++) {
            System.out.println("Node: " + nodeList.get(i).getIndex());
        }
    }
}
