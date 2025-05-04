import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import leetcode.pojo.GraphNode;

public class CloneGraph_133 {
    private Map<GraphNode, GraphNode> visited = new HashMap<>();
    public GraphNode cloneGraph(GraphNode node) {
        if (node == null)
            return node;
        if (this.visited.containsKey(node)) {
            return this.visited.get(node);
        }
        GraphNode newNode = new GraphNode(node.val, new ArrayList<>());
        this.visited.put(node, newNode);
        if (node.neighbors != null && node.neighbors.size() > 0) {
            for (GraphNode nod : node.neighbors) {
                newNode.neighbors.add(cloneGraph(nod));
            }
        }
        return newNode;
    }
}
