import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGraph {
    public int vertices;
    public int edges;
    final int MAX_LIMIT = 20;
    Random random = new Random();
    public List<List<Integer>> adjacencyList;

    public RandomGraph() {
        this.vertices = random.nextInt(MAX_LIMIT) + 1;
        this.edges = random.nextInt(computeMaxEdges(vertices)) + 1;
        adjacencyList = new ArrayList(vertices);

        for (int i = 0; i < this.vertices; i++) {
            this.adjacencyList.add(new ArrayList());
        }

        for (int i = 0; i < edges; i++) {
            int v = random.nextInt(vertices);
            int w = random.nextInt(vertices);
            addEdge(v, w);
        }
    }

    int computeMaxEdges(int numOfVertices) {
        return numOfVertices * ((numOfVertices - 1) / 2);
    }

    void addEdge(int v, int w) {
        adjacencyList.get(v).add(w);
        adjacencyList.get(w).add(v);
    }
}
