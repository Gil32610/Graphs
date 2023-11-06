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

    public char getName() {
        return name;
    }

    public ArrayList<WeightedNode> getNeighbours() {
        return neighbours;
    }

    public HashMap<WeightedNode, Integer> getWeightMap() {
        return weightMap;
    }

    public WeightedNode getParent() {
        return parent;
    }

    public DisjointSet getSet() {
        return set;
    }

    public int getDistance() {
        return distance;
    }

    public void setName(char name) {
        this.name = name;
    }

    public void setNeighbours(ArrayList<WeightedNode> neighbours) {
        this.neighbours = neighbours;
    }

    public void setWeightMap(HashMap<WeightedNode, Integer> weightMap) {
        this.weightMap = weightMap;
    }

    public void setParent(WeightedNode parent) {
        this.parent = parent;
    }

    public void setSet(DisjointSet set) {
        this.set = set;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
