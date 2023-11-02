package GraphWithMatrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
private ArrayList<GraphNode> nodeList;
private boolean[][] adjacencyMatrix;

private Integer[]cor;

private Integer[]previous;
private Integer[] distance;
private int tempo;
private Queue<Integer> fila;

private Integer start[];
private Integer end[];


    public Graph(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
        this.adjacencyMatrix = new boolean[nodeList.size()][nodeList.size()];
        fila = new LinkedList<>();
        cor = new Integer[nodeList.size()];
        previous = new Integer[nodeList.size()];
        distance = new Integer[nodeList.size()];
        start= new Integer[nodeList.size()];
        end = new Integer[nodeList.size()];
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

    public boolean startSumTargetDFS(int s,int targetSum){
        for (int i = 0; i <nodeList.size() ; i++) {
            cor[i] = GraphNode.BRANCO;
            start[i]=-2;
            end[i]=-2;
            previous[i] = -2;
        }
        tempo= -1;
        return dfsSumTargetVisit(0,nodeList.get(0).getIndex(),targetSum);
    }

    public boolean dfsSumTargetVisit(int u, int sum, int targetSum) {
        if (!allVisited()) {
            if (sum == targetSum && neighboursCount(u) == 1) {
                return true;
            }
            cor[u] = GraphNode.CINZA;
            start[u] = ++tempo;
            for (int v = 0; v < adjacencyMatrix.length; v++) {
                if (adjacencyMatrix[u][v] && cor[v] == GraphNode.BRANCO) {
                    previous[v] = u;
                    sum += nodeList.get(v).getIndex();
                    return dfsSumTargetVisit(v, sum, targetSum);
                }
            }

            cor[u] = GraphNode.PRETO;
            sum -= nodeList.get(u).getIndex();
            return dfsSumTargetVisit(previous[u],sum,targetSum);
        }
        return false;
    }

    public void dfsStart(int s){
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            cor[i] = GraphNode.BRANCO;
            start[i]=-2;
            end[i]=-2;
            previous[i] = -2;
        }
        tempo = -1;
        dfsVisit(s);
    }
    
    
    public void dfsVisit(int u){
        cor[u] = GraphNode.CINZA;
        start[u]=++tempo;
        for (int v = 0; v < adjacencyMatrix.length; v++) {
            if(adjacencyMatrix[u][v]&& cor[v]==GraphNode.BRANCO){
                previous[v] = u;
                dfsVisit(v);
            }
        }
        end[u]=++tempo;
        cor[u] = GraphNode.PRETO;
    }

    public void addDirectedEdge(int i,int j){
        adjacencyMatrix[i][j] = true;
    }

    public Stack<Integer> topologicalDfsStart(){
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            cor[i]= GraphNode.BRANCO;
            start[i] = -2;
            end[i] = -2;
            previous[i] = -2;
        }
        tempo = -1;
        for (int u = 0; u < adjacencyMatrix.length; u++) {
            if(hasDependencies(u)){
                for (int v = 0; v < adjacencyMatrix.length ; v++) {
                    if(cor[v]==GraphNode.BRANCO){
                        topologicalSortVisit(stack,v);
                    }
                }
            }else continue;
        }
        return stack;
    }

    public boolean hasDependencies(int i){
        for (int v = 0; v <adjacencyMatrix.length ; v++) {
            if(adjacencyMatrix[i][v]){
                return true;
            }
        }
        return false;
    }

    public void topologicalSortVisit(Stack<Integer>stack, int u){
        start[u] = ++tempo;
        cor[u] = GraphNode.CINZA;
        for (int v = 0; v < adjacencyMatrix.length; v++) {
            if(cor[v] == GraphNode.BRANCO && adjacencyMatrix[u][v]){
                previous[v] = u;
                topologicalSortVisit(stack,v);
            }
        }
        cor[u] = GraphNode.PRETO;
        end[u] = ++tempo;
        stack.push(u);
    }

    public void printUndirectedGraph(){
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j <adjacencyMatrix.length ; j++) {
                if(adjacencyMatrix[i][j]){
                    if(j!=adjacencyMatrix[i].length-1){
                        System.out.print(nodeList.get(i).getName() + " -> " + nodeList.get(j).getName() + " | ");
                    }else{
                        System.out.print(nodeList.get(i).getName() + " -> " + nodeList.get(j).getName());
                    }
                }

            }
            System.out.println();
        }
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

    public Integer[] getStart() {
        return start;
    }

    public Integer[] getEnd() {
        return end;
    }
}

