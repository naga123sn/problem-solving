package day10;
import java.util.*;

// Class to represent an edge in the graph
class Edge implements Comparable<Edge> {
    int source, destination, weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    // Compare edges by weight
    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

// Class to represent a union-find data structure
class UnionFind {
    private int[] parent, rank;

    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent[vertex]); // Path compression
        }
        return parent[vertex];
    }

    public boolean union(int vertex1, int vertex2) {
        int root1 = find(vertex1);
        int root2 = find(vertex2);

        if (root1 == root2) {
            return false; // Cycle detected
        }

        // Union by rank
        if (rank[root1] > rank[root2]) {
            parent[root2] = root1;
        } else if (rank[root1] < rank[root2]) {
            parent[root1] = root2;
        } else {
            parent[root2] = root1;
            rank[root1]++;
        }
        return true;
    }
}

// Class to represent a graph and implement Kruskal's algorithm
class Graph {
    private int vertices;
    private List<Edge> edges;

    public Graph(int vertices) {
        this.vertices = vertices;
        edges = new ArrayList<>();
    }

    public void addEdge(int source, int destination, int weight) {
        edges.add(new Edge(source, destination, weight));
    }

    public void kruskalMST() {
        // Sort edges by weight
        Collections.sort(edges);

        // Initialize union-find structure
        UnionFind uf = new UnionFind(vertices);

        List<Edge> mst = new ArrayList<>();
        int mstWeight = 0;

        for (Edge edge : edges) {
            if (uf.union(edge.source, edge.destination)) {
                mst.add(edge);
                mstWeight += edge.weight;
            }
        }

        // Print the MST
        System.out.println("Minimum Spanning Tree:");
        for (Edge edge : mst) {
            System.out.println("Edge: " + edge.source + " - " + edge.destination + " | Weight: " + edge.weight);
        }
        System.out.println("Total Weight: " + mstWeight);
    }
}

// Main class to test the program
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

        // Find the MST using Kruskal's algorithm
        graph.kruskalMST();
    }
}
