package GraphWithMatrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
private ArrayList<GraphNode> nodeList;
private boolean[][] adjacencyMatrix;

private Integer[]cor;

private Integer[]previous;
private Integer[] distance;
private int tempo;
private Queue<Integer> fila;

private int start[];
private int end[];


    public Graph(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
        this.adjacencyMatrix = new boolean[nodeList.size()][nodeList.size()];
        fila = new LinkedList<>();
        cor = new Integer[nodeList.size()];
        previous = new Integer[nodeList.size()];
        distance = new Integer[nodeList.size()];
        start= new int[nodeList.size()];
        end = new int[nodeList.size()];
    }

    public void addUndirectedEdge(int i, int j){
        adjacencyMatrix[i][j] = true;
        adjacencyMatrix[j][i] = true;
    }

    @Override
    public String toString(){
        StringBuilder s= new StringBuilder();

        s.append("   ");

        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).getName() + " ");
        }
        s.append("\n");
        for (int i = 0; i < nodeList.size() ; i++) {
            s.append(nodeList.get(i).getName()+": ");
            for (int j = 0; j <adjacencyMatrix[i].length ; j++) {
                s.append(flag(adjacencyMatrix[i][j])+ " ");

            }
            s.append("\n");
        }
        return s.toString();

    }

    public int flag(boolean status){
        return status?1:0;
    }

    public void BFS(int s){
        for (int j = 0; j < nodeList.size(); j++) {
            cor[j] = GraphNode.BRANCO;
            distance[j] = -1;
            previous[j] = null;
        }
        cor[s] = GraphNode.CINZA;
        distance[s] = 0;
        fila.offer(s);
        while(!fila.isEmpty()){
            int u = fila.poll();
            for (int i = 0; i < nodeList.size(); i++) {

                if(adjacencyMatrix[u][i] && cor[i]==GraphNode.BRANCO){
                    cor[i] = GraphNode.CINZA;
                    distance[i]= distance[u]+1;
                    previous[i] = u;
                    fila.offer(i);
                }
            }
            cor[u] = GraphNode.PRETO;
        }

    }

    public boolean startDFS(int s,int targetSum){
        for (int i = 0; i <nodeList.size() ; i++) {
            cor[i] = GraphNode.BRANCO;
            start[i]=-2;
            end[i]=-2;
            previous[i] = -2;
        }
        tempo= -1;
        return dfsVisit(0,nodeList.get(0).getValue(),targetSum);
    }

    public boolean dfsVisit(int u, int sum, int targetSum) {
        if (!allVisited()) {
            if (sum == targetSum && neighboursCount(u) == 1) {
                return true;
            }
            cor[u] = GraphNode.CINZA;
            start[u] = ++tempo;
            for (int v = 0; v < adjacencyMatrix.length; v++) {
                if (adjacencyMatrix[u][v] && cor[v] == GraphNode.BRANCO) {
                    previous[v] = u;
                    sum += nodeList.get(v).getValue();
                    return dfsVisit(v, sum, targetSum);
                }
            }

            cor[u] = GraphNode.PRETO;
            sum -= nodeList.get(u).getValue();
            return dfsVisit(previous[u],sum,targetSum);
        }
        return false;
    }

    public Integer[] getCor() {
        return cor;
    }

    public Integer[] getPrevious() {
        return previous;
    }

    public Integer[] getDistance() {
        return distance;
    }

    public int neighboursCount(int u){
        int count =0;
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            count += adjacencyMatrix[u][i]?1:0;
        }
        return count;
    }

    public boolean allVisited(){
        for (int i = 0; i < cor.length; i++) {
            if(cor[i] != GraphNode.PRETO){
                return false;
            }

        }
        return true;
    }
}
