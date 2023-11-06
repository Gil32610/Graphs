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

    public static DisjointSet union (WeightedNode u, WeightedNode v){
            DisjointSet set1 = u.getSet();
            DisjointSet set2 = v.getSet();


        for (WeightedNode weightedNode:set1.nodeList) {
            weightedNode.setSet(set2);
            set2.nodeList.add(weightedNode);
        }
        return set2;

    }



}
