import java.util.ArrayList;

public class Graph {
private ArrayList<GraphNode> nodeList;
private int[] [] adjacencyMatrix;

    public Graph(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
        this.adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
    }

    public void addUndirectedEdge(int i, int j){
        adjacencyMatrix[i][j] = 1;
        adjacencyMatrix[j][i] = 1;
    }

    @Override
    public String toString(){
        StringBuilder s= new StringBuilder();

        s.append("  ");

        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).getName() + " ");
        }
        s.append("\n");
        for (int i = 0; i < nodeList.size() ; i++) {
            s.append(nodeList.get(i).getName()+": ");
            for (int j = 0; j <adjacencyMatrix[i].length ; j++) {
                s.append(adjacencyMatrix[i][j]+ " ");

            }
            s.append("\n");
        }
        return s.toString();

    }


}
