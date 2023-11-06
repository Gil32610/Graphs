package MinimumSpanningTree;

import java.util.ArrayList;
import java.util.HashMap;

public class WeightedNode {
    private char name;

    private ArrayList<WeightedNode> neighbours;
    private HashMap<WeightedNode,Integer> weightMap;
    private WeightedNode parent;

    private DisjointSet set;

    private int distance;

    public WeightedNode(char name){
        this.name = name;
        this.distance = Integer.MAX_VALUE;
    }
}
