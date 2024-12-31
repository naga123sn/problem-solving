package day10;
import java.util.*;

//Class to represent a graph
class Graph {
 private int vertices; // Number of vertices
 private LinkedList<Integer>[] adjacencyList; // Adjacency list for the graph

 // Constructor to initialize the graph
 @SuppressWarnings("unchecked")
 public Graph(int vertices) {
     this.vertices = vertices;
     adjacencyList = new LinkedList[vertices];
     for (int i = 0; i < vertices; i++) {
         adjacencyList[i] = new LinkedList<>();
     }
 }

 // Method to add an edge to the graph
 public void addEdge(int source, int destination) {
     adjacencyList[source].add(destination);
     adjacencyList[destination].add(source); // For undirected graph
 }

 // Depth-First Search (DFS)
 public void dfs(int start) {
     boolean[] visited = new boolean[vertices];
     System.out.println("DFS starting from vertex " + start + ":");
     dfsUtil(start, visited);
     System.out.println();
 }

 private void dfsUtil(int vertex, boolean[] visited) {
     visited[vertex] = true;
     System.out.print(vertex + " ");
     for (int neighbor : adjacencyList[vertex]) {
         if (!visited[neighbor]) {
             dfsUtil(neighbor, visited);
         }
     }
 }

 // Breadth-First Search (BFS)
 public void bfs(int start) {
     boolean[] visited = new boolean[vertices];
     Queue<Integer> queue = new LinkedList<>();
     
     visited[start] = true;
     queue.add(start);

     System.out.println("BFS starting from vertex " + start + ":");
     while (!queue.isEmpty()) {
         int current = queue.poll();
         System.out.print(current + " ");
         for (int neighbor : adjacencyList[current]) {
             if (!visited[neighbor]) {
                 visited[neighbor] = true;
                 queue.add(neighbor);
             }
         }
     }
     System.out.println();
 }
}

//Main class to test the graph traversals
public class Main {
 public static void main(String[] args) {
     Graph graph = new Graph(6);

     // Add edges to the graph
     graph.addEdge(0, 1);
     graph.addEdge(0, 2);
     graph.addEdge(1, 3);
     graph.addEdge(1, 4);
     graph.addEdge(2, 5);

     // Perform DFS and BFS
     graph.dfs(0); // Start DFS from vertex 0
     graph.bfs(0); // Start BFS from vertex 0
 }
}

