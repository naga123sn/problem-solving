package day10;
import java.util.*;

// Class to represent a directed graph
class Graph {
    private int vertices; // Number of vertices
    private LinkedList<Integer>[] adjacencyList; // Adjacency list

    // Constructor to initialize the graph
    @SuppressWarnings("unchecked")
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Method to add a directed edge to the graph
    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
    }

    // Method to detect a cycle in the graph
    public boolean hasCycle() {
        boolean[] visited = new boolean[vertices];
        boolean[] recursionStack = new boolean[vertices];

        // Check for cycles in each connected component
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                if (dfsCycle(i, visited, recursionStack)) {
                    return true;
                }
            }
        }
        return false;
    }

    // DFS utility to detect a cycle
    private boolean dfsCycle(int current, boolean[] visited, boolean[] recursionStack) {
        visited[current] = true;
        recursionStack[current] = true;

        for (int neighbor : adjacencyList[current]) {
            if (!visited[neighbor] && dfsCycle(neighbor, visited, recursionStack)) {
                return true;
            } else if (recursionStack[neighbor]) {
                return true; // Cycle detected
            }
        }

        recursionStack[current] = false;
        return false;
    }
}

// Main class to test the graph for a cycle
public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(4);

        // Add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0); // This edge creates a cycle
        graph.addEdge(2, 3);

        if (graph.hasCycle()) {
            System.out.println("The graph contains a cycle.");
        } else {
            System.out.println("The graph does not contain a cycle.");
        }
    }
}
