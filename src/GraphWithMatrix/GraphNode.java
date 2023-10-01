package GraphWithMatrix;

public class GraphNode {

    private Character name;
    private int index;

    public GraphNode(Character name, int index) {
        this.name = name;
        this.index = index;
    }

    public Character getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }
}
