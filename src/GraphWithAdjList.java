import java.util.ArrayList;

public class GraphWithAdjList {
private ArrayList<GraphNodeNeighbourList> adjacencyList;

    public GraphWithAdjList(ArrayList<GraphNodeNeighbourList> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    public ArrayList<GraphNodeNeighbourList> getAdjacencyList() {
        return adjacencyList;
    }

    public void addUndirectedEdge(int i, int j){
       GraphNodeNeighbourList start = adjacencyList.get(i);
       GraphNodeNeighbourList pivot = adjacencyList.get(j);
       adjacencyList.get(i).getNeighbours().add(pivot);
       adjacencyList.get(j).getNeighbours().add(start);
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < adjacencyList.size(); i++) {
            s.append((adjacencyList.get(i).getName()+ ": " ));
            ArrayList<GraphNodeNeighbourList> neighbour = getAdjacencyList().get(i).getNeighbours();
            for (int j = 0; j <neighbour.size() ; j++) {
                s.append(neighbour.get(j));
                if(j!=neighbour.size()-1){
                    s.append(" -> ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }
}
