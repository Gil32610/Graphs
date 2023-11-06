package MinimumSpanningTree;

import java.util.ArrayList;

public class DisjointSet {

    private ArrayList< WeightedNode> nodeList;
    private DisjointSet(){
        this.nodeList= new ArrayList<>();
    }

    public static void makeSet(ArrayList<WeightedNode> nodeList){
        for (int i = 0; i < nodeList.size(); i++) {
            WeightedNode weightedNode = nodeList.get(i);
            DisjointSet set = new DisjointSet();
            set.nodeList.add(weightedNode);
            weightedNode.setSet(set);
        }
    }

    public static DisjointSet findSet (WeightedNode weightedNode){
           DisjointSet set = weightedNode.getSet();
           return set;
    }

}
