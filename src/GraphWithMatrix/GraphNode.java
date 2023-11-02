package GraphWithMatrix;

public class GraphNode {
    public static final int BRANCO = 0;
    public static final int CINZA = 1;
    public static final int PRETO = 2;

    private char name;
    private int index;

    public GraphNode(char name, int index) {
        this.name= name;
        this.index = index;
    }

    public char getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }
}
