package GraphWithList;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        ArrayList<GraphNodeNeighbourList> adjacencyList= new ArrayList<>();
        adjacencyList.add(new GraphNodeNeighbourList('A',0));
        adjacencyList.add(new GraphNodeNeighbourList('B',1));
        adjacencyList.add(new GraphNodeNeighbourList('C',2));
        adjacencyList.add(new GraphNodeNeighbourList('D',3));
        adjacencyList.add(new GraphNodeNeighbourList('E',4));
        GraphWithAdjList g = new GraphWithAdjList(adjacencyList);

        g.addUndirectedEdge(0,1);
        g.addUndirectedEdge(0,3);
        g.addUndirectedEdge(0,2);
        g.addUndirectedEdge(1,4);
        g.addUndirectedEdge(4,3);
        g.addUndirectedEdge(3,2);

        System.out.println(g);
    }
}
