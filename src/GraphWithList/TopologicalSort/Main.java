package GraphWithList.TopologicalSort;

import GraphWithList.GraphNodeNeighbourList;
import GraphWithList.GraphWithAdjList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        ArrayList<GraphNodeNeighbourList> nodeList = new ArrayList<>();
        nodeList.add(new GraphNodeNeighbourList('A',0));
        nodeList.add(new GraphNodeNeighbourList('B',1));
        nodeList.add(new GraphNodeNeighbourList('C',2));
        nodeList.add(new GraphNodeNeighbourList('D',3));
        nodeList.add(new GraphNodeNeighbourList('E',4));
        nodeList.add(new GraphNodeNeighbourList('F',5));
        nodeList.add(new GraphNodeNeighbourList('G',6));
        nodeList.add(new GraphNodeNeighbourList('H',7));

        GraphWithAdjList graph = new GraphWithAdjList(nodeList);

        //A and B directed edges
        graph.addDirectedEdge(0,2);
        graph.addDirectedEdge(1,2);
        graph.addDirectedEdge(1,3);

        //C directed edge
        graph.addDirectedEdge(2,4);

        //E directed edges
        graph.addDirectedEdge(4,7);
        graph.addDirectedEdge(4,5);

        //D directed edge
        graph.addDirectedEdge(3,5);

        //F directed edge
        graph.addDirectedEdge(5,6);

        Stack<GraphNodeNeighbourList> stack = graph.topologicalDfsStart();

        Character[] order = new Character[stack.size()];

        for (int i = 0; i <order.length ; i++) {
            order[i] = stack.pop().getName();
        }
        System.out.println("Order of topological sort on the graph model:");
        System.out.println(Arrays.deepToString(order));



    }
}
