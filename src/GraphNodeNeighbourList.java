import java.util.ArrayList;

public class GraphNodeNeighbourList {

    private Character name;
    private int index;
    private ArrayList<GraphNodeNeighbourList> neighbours;

    public GraphNodeNeighbourList(Character name, int index) {
        this.neighbours = new ArrayList<>();
        this.name = name;
        this.index = index;
    }

    public Character getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public ArrayList<GraphNodeNeighbourList> getNeighbours() {
        return neighbours;
    }
}
