package MinimumSpanningTree;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<WeightedNode> nodeList = new ArrayList<>();
        nodeList.add(new WeightedNode('A'));
        nodeList.add(new WeightedNode('B'));
        nodeList.add(new WeightedNode('C'));
        nodeList.add(new WeightedNode('D'));

        DisjointSet.makeSet(nodeList);

        WeightedNode firstNode = nodeList.get(0);
        WeightedNode secondNode = nodeList.get(1);

        DisjointSet firstSet = DisjointSet.findSet(firstNode);
        DisjointSet secondSet = DisjointSet.findSet(secondNode);

        firstSet.printAllNodes();
        secondSet.printAllNodes();

        DisjointSet.union(firstNode,secondNode);
        firstSet.printAllNodes();
        secondSet.printAllNodes();



    }
}
