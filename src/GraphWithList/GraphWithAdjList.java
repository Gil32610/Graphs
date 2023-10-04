package GraphWithList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphWithAdjList {

    private int[] ante;
    private int[] d;
    private int[] cor;
    private ArrayList<GraphNodeNeighbourList> adjacencyList;

    public GraphWithAdjList(ArrayList<GraphNodeNeighbourList> adjacencyList) {
        this.adjacencyList = adjacencyList;
        this.d = new int[adjacencyList.size()];
        this.cor = new int[adjacencyList.size()];
        this.ante = new int[adjacencyList.size()];
    }

    public ArrayList<GraphNodeNeighbourList> getAdjacencyList() {
        return adjacencyList;
    }


    public void addUndirectedEdge(int i, int j) {
        GraphNodeNeighbourList start = adjacencyList.get(i);
        GraphNodeNeighbourList pivot = adjacencyList.get(j);
        adjacencyList.get(i).getNeighbours().add(pivot);
        adjacencyList.get(j).getNeighbours().add(start);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < adjacencyList.size(); i++) {
            s.append((adjacencyList.get(i).getName() + ": "));
            ArrayList<GraphNodeNeighbourList> neighbour = getAdjacencyList().get(i).getNeighbours();
            for (int j = 0; j < neighbour.size(); j++) {
                s.append(neighbour.get(j));
                if (j != neighbour.size() - 1) {
                    s.append(" -> ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }

    public void BreadthFirstSearchStart(int i) {
        GraphNodeNeighbourList u = adjacencyList.get(i);

        for (int j = 0; j < adjacencyList.size(); j++) {
            ante[i] = -1;
            d[i] = -1;
            cor[i] = 0;
        }
        BreadthFirstSearch(u);
    }

    private void BreadthFirstSearch(GraphNodeNeighbourList s) {
        Queue<GraphNodeNeighbourList> fila = new LinkedList<>();
        fila.offer(s);
        s.setStatus(GraphNodeNeighbourList.CINZA);
        cor[adjacencyList.indexOf(s)] = GraphNodeNeighbourList.CINZA;
        d[adjacencyList.indexOf(s)] = 0;

        while (!fila.isEmpty()) {
            GraphNodeNeighbourList u = fila.poll();
            int currentPos = adjacencyList.indexOf(u);
            for (int i = 0; i < u.getNeighbours().size(); i++) {
                GraphNodeNeighbourList v = u.getNeighbours().get(i);
                if (v.getStatus() == GraphNodeNeighbourList.BRANCO) {
                    int currentAdj = adjacencyList.indexOf(v);
                    v.setStatus(GraphNodeNeighbourList.CINZA);
                    cor[currentAdj] = GraphNodeNeighbourList.CINZA;
                    d[currentAdj] = d[currentPos] + 1;
                    ante[currentAdj] = currentPos;
                    fila.offer(v);
                }
            }
            u.setStatus(GraphNodeNeighbourList.PRETO);
            cor[currentPos] = GraphNodeNeighbourList.PRETO;
        }
    }

    public int[] getAnte() {
        return ante;
    }

    public int[] getD() {
        return d;
    }

    public int[] getCor() {
        return cor;
    }
}
