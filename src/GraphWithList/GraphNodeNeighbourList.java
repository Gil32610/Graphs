package GraphWithList;

import java.util.ArrayList;

public class GraphNodeNeighbourList {
    public static final int BRANCO = 0;
    public static final int CINZA = 1;

    public static final int PRETO = 2;

    private Character name;
    private int index;
    private ArrayList<GraphNodeNeighbourList> neighbours;
    private int status;

    public GraphNodeNeighbourList(Character name, int index) {
        this.neighbours = new ArrayList<>();
        this.name = name;
        this.index = index;
        this.status = BRANCO;
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

    @Override
    public String toString() {
        return
                "{name=" + name +
                ", index=" + index +
                '}';
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
