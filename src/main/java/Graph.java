import java.util.*;

public class Graph {
    private Map<Vertex, List<Vertex>> adjVertices = new HashMap();

    public Graph() {
    }

    public void addVertex(String label) {
        this.adjVertices.putIfAbsent(new Vertex(label), new ArrayList());
    }

    public void removeVertex(String label) {
        Vertex v = new Vertex(label);
        this.adjVertices.values().stream().forEach((e) -> {
            e.remove(v);
        });
        this.adjVertices.remove(new Vertex(label));
    }

    public void addEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        ((List) this.adjVertices.get(v1)).add(v2);
        ((List) this.adjVertices.get(v2)).add(v1);
    }

    public void removeEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        List<Vertex> eV1 = (List) this.adjVertices.get(v1);
        List<Vertex> eV2 = (List) this.adjVertices.get(v2);
        if (eV1 != null) {
            eV1.remove(v2);
        }

        if (eV2 != null) {
            eV2.remove(v1);
        }
    }

    public List<Vertex> getAdjVertices(String label) {
        return (List)this.adjVertices.get(new Vertex(label));
    }

    public String printGraph() {
        StringBuffer sb = new StringBuffer();
        Iterator var2 = this.adjVertices.keySet().iterator();

        while(var2.hasNext()) {
            Vertex v = (Vertex)var2.next();
            sb.append(v);
            sb.append(this.adjVertices.get(v));
        }

        return sb.toString();
    }

    class Vertex {
        String label;

        Vertex(String str) {
            this.label = label;
        }

        public int hashCode() {
            boolean prime = true;
            int resultx = 1;
            int result = 31 * resultx + this.getOuterType().hashCode();
            result = 31 * result + (this.label == null ? 0 : this.label.hashCode());
            return result;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            } else if (obj == null) {
                return false;
            } else if (this.getClass() != obj.getClass()) {
                return false;
            } else {
                Vertex other = (Vertex) obj;
                if (!this.getOuterType().equals(other.getOuterType())) {
                    return false;
                } else {
                    if (this.label == null) {
                        if (other.label != null) {
                            return false;
                        }
                    } else if (!this.label.equals(other.label)) {
                        return false;
                    }
                    return true;
                }
            }
        }

        public String toString() {
            return this.label;
        }

        private Graph getOuterType() {
            return Graph.this;
        }
    }
}
