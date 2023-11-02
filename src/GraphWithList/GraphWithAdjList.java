package GraphWithList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphWithAdjList {

    private Integer[] ante;
    private Integer[] d;
    private Integer[] cor;

    private Integer[] start;
    private Integer[]end;
    private int time;
    private ArrayList<GraphNodeNeighbourList> adjacencyList;



    public GraphWithAdjList(ArrayList<GraphNodeNeighbourList> adjacencyList) {
        this.adjacencyList = adjacencyList;
        this.d = new Integer[adjacencyList.size()];
        this.cor = new Integer[adjacencyList.size()];
        this.ante = new Integer[adjacencyList.size()];
        this.start = new Integer[adjacencyList.size()];
        this.end = new Integer[adjacencyList.size()];
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

    public void addDirectedEdge(int i, int j){
        GraphNodeNeighbourList first = adjacencyList.get(i);
        GraphNodeNeighbourList second = adjacencyList.get(j);
        first.getNeighbours().add(second);
    }

public Stack<GraphNodeNeighbourList> topologicalDfsStart(){
        Stack<GraphNodeNeighbourList> stack = new Stack<>();
    for (GraphNodeNeighbourList node:adjacencyList
         ) {
        cor[adjacencyList.indexOf(node)] = GraphNodeNeighbourList.BRANCO;
        start[adjacencyList.indexOf(node)] = -2;
        end[adjacencyList.indexOf(node)] = -2;
    }
    this.time =-1;
    for (GraphNodeNeighbourList v:adjacencyList
         ) {
        if(cor[adjacencyList.indexOf(v)] == GraphNodeNeighbourList.BRANCO){
            topologicalDFS(v,stack);
        }
    }
    return stack;
}

public void topologicalDFS (GraphNodeNeighbourList u, Stack<GraphNodeNeighbourList> stack){
        start[adjacencyList.indexOf(u)] = ++time;
        cor[adjacencyList.indexOf(u)] = GraphNodeNeighbourList.CINZA;
    for (GraphNodeNeighbourList v:u.getNeighbours()
         ) {
        if(cor[adjacencyList.indexOf(v)] == GraphNodeNeighbourList.BRANCO){
            ante[adjacencyList.indexOf(v)] = adjacencyList.indexOf(u);
            cor[adjacencyList.indexOf(v)] = GraphNodeNeighbourList.CINZA;
            topologicalDFS(v,stack);
        }
    }
    end[adjacencyList.indexOf(u)] = ++time;
    cor[adjacencyList.indexOf(u)] = GraphNodeNeighbourList.PRETO;
    stack.push(u);
}


    public Integer[] getAnte() {
        return ante;
    }

    public Integer[] getD() {
        return d;
    }

    public Integer[] getCor() {
        return cor;
    }

    public void printDirectedGraph(){
        for (GraphNodeNeighbourList node:adjacencyList
             ) {

            for (GraphNodeNeighbourList nodeRelation:node.getNeighbours()
                 ) {
                if(node.getNeighbours().size()-1!= node.getNeighbours().indexOf(nodeRelation)){
                    System.out.print(node.getName()+" -> " + nodeRelation.getName()+ " | ");
                }
                else System.out.println(node.getName()+" -> " + nodeRelation.getName());
            }
        }
    }
}
