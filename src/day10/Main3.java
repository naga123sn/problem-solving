package day10;
import java.util.*;

// Class representing a graph
class Graph {
    private int vertices; // Number of vertices
    private LinkedList<Edge>[] adjacencyList; // Adjacency list

    // Edge class to represent a weighted edge
    static class Edge {
        int destination, weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

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
    public void addEdge(int source, int destination, int weight) {
        adjacencyList[source].add(new Edge(destination, weight));
        adjacencyList[destination].add(new Edge(source, weight)); // For undirected graph
    }

    // Dijkstra's Algorithm
    public void dijkstra(int start) {
        // Priority queue to pick the vertex with the smallest distance
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
        int[] distances = new int[vertices]; // Distance from the source to each vertex
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentVertex = current.vertex;

            for (Edge edge : adjacencyList[currentVertex]) {
                int neighbor = edge.destination;
                int newDist = distances[currentVertex] + edge.weight;

                if (newDist < distances[neighbor]) {
                    distances[neighbor] = newDist;
                    pq.add(new Node(neighbor, newDist));
                }
            }
        }

        printShortestPaths(start, distances);
    }

    // Method to print the shortest paths
    private void printShortestPaths(int start, int[] distances) {
        System.out.println("Shortest paths from vertex " + start + ":");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("To vertex " + i + " - Distance: " + distances[i]);
        }
    }

    // Node class to represent a vertex and its distance
    static class Node {
        int vertex, distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }
}

// Main class to test the graph and Dijkstra's algorithm
public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(6);

        // Add edges to the graph
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 3, 5);
        graph.addEdge(2, 3, 8);
        graph.addEdge(2, 4, 10);
        graph.addEdge(3, 4, 2);
        graph.addEdge(3, 5, 6);
        graph.addEdge(4, 5, 3);

        // Find shortest paths from vertex 0
        graph.dijkstra(0);
    }
}
