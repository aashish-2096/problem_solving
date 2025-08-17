import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeNeededToInform_1376 {
    class Node {
        int val;
        List<Node> child = new ArrayList<>();

        Node(int val) {
            this.val = val;
            this.child = new ArrayList<>();
        }

        public List<Node> getchild() {
            return this.child;
        }
    }

    int maxSum = 0;
    private void calculateDelay(Node root, int[] informTime, int sum) {
        if (root == null) {
            maxSum = Math.max(maxSum, sum);
            return;
        }
        if (root.getchild().isEmpty()) {
            maxSum = Math.max(maxSum, sum);
            return;
        }
        int time = informTime[root.val];
        sum += time;
        for (Node ch : root.getchild()) {
            calculateDelay(ch, informTime, sum);
        }
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, Node> nodeMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nodeMap.put(i, new Node(i));
        }
        Node root = nodeMap.get(headID);
        for (int i = 0; i < n; i++) {
            int parent = manager[i];
            if (parent == -1) {
                continue;
            }
            Node currentNode = nodeMap.get(i);
            Node parentNode = nodeMap.get(parent);
            if (parentNode == null) {
                System.out.println("Null Parent Node");
            }
            parentNode.getchild().add(currentNode);
        }
        calculateDelay(root, informTime, 0);
        return this.maxSum;
    }
}
