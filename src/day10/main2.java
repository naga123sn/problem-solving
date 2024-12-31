package day10;
import java.util.*;

// Class to represent a graph
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

    // Method to detect a cycle in the graph
    public boolean hasCycle() {
        boolean[] visited = new boolean[vertices];

        // Check for cycles in each connected component
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                if (dfsCycle(i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    // DFS utility to detect a cycle
    private boolean dfsCycle(int current, boolean[] visited, int parent) {
        visited[current] = true;

        for (int neighbor : adjacencyList[current]) {
            if (!visited[neighbor]) {
                // Recur for unvisited neighbors
                if (dfsCycle(neighbor, visited, current)) {
                    return true;
                }
            } else if (neighbor != parent) {
                // If the neighbor is visited and not the parent, there's a cycle
                return true;
            }
        }
        return false;
    }
}

// Main class to test the graph for a cycle
public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(5);

        // Add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1); // This edge creates a cycle

        if (graph.hasCycle()) {
            System.out.println("The graph contains a cycle.");
        } else {
            System.out.println("The graph does not contain a cycle.");
        }
    }
}
