package GraphWithMatrix;

public class GraphNode {
    public static final int BRANCO = 0;
    public static final int CINZA = 1;
    public static final int PRETO = 2;

    private int value ;
    private int index;

    public GraphNode(int value, int index) {
        this.value= value;
        this.index = index;
    }

    public int getName() {
        return value;
    }

    public int getValue() {
        return value;
    }

    public int getIndex() {
        return index;
    }
}
