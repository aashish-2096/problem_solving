import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivison_399 {
    List<Boolean> takenList;
    public class SimplePair {
        int node;
        double weight;

        SimplePair(int node, double weight) {
            this.node = node;
            this.weight = weight;
        }

        int getNode() {
            return this.node;
        }

        double getWeight() {
            return this.weight;
        }
    }

    public List<List<SimplePair>> getAdjList(Map<String, Integer> enums, List<List<String>> equations,
            double[] values) {
        int size = enums.size();
        List<List<SimplePair>> adjList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < equations.size(); i++) {
            String first = equations.get(i).get(0);
            String second = equations.get(i).get(1);
            int a = enums.get(first);
            int b = enums.get(second);
            adjList.get(a).add(new SimplePair(b, values[i]));
            adjList.get(b).add(new SimplePair(a, 1 / values[i]));
        }
        return adjList;
    }

    public double dfs(int src, int dest, double temp, List<List<SimplePair>> adjList, int index, Set<Integer> visited) {
        if (src == dest) {
            return 1.00000;
        }
        double result = -1.0d;
        if (visited.contains(src)) {
            return -1.0000d;
        }
        visited.add(src);
        List<SimplePair> currList = adjList.get(src);
        for (int i = 0; i < currList.size(); i++) {
            int next = currList.get(i).getNode();
            double weight = currList.get(i).getWeight();
            if (next == dest) {
                if (!this.takenList.get(index)) {
                    result = temp * weight;
                    this.takenList.set(index, true);
                    return result;
                } else {
                    result = -1.00000d;
                    return result;
                }
            } else {
                result = dfs(next, dest, temp * weight, adjList, index, visited);
                if(result > 0) return result;
            }
        }
        visited.remove(src);
        return result;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Integer> enums = new HashMap<>();
        this.takenList = new ArrayList<>(Collections.nCopies(queries.size(), false));
        for (int i = 0; i < equations.size(); i++) {
            String first = equations.get(i).get(0);
            String second = equations.get(i).get(1);
            if (!enums.containsKey(first)) {
                enums.put(first, enums.size());
            }
            if (!enums.containsKey(second)) {
                enums.put(second, enums.size());
            }
        }
        double[] result = new double[queries.size()];
        Arrays.fill(result, -1);
        List<List<SimplePair>> adjList = getAdjList(enums, equations, values);
        for (int i = 0; i < queries.size(); i++) {
            int src = (int) enums.getOrDefault(queries.get(i).get(0), -1);
            int dest = (int) enums.getOrDefault(queries.get(i).get(1), -1);
            if (src != -1 && dest != -1) {
                Set<Integer> visited = new HashSet<>();
                double tempRes = dfs(src, dest, 1.00000, adjList, i, visited);
                result[i] = tempRes < 0 ? -1.0000 : tempRes;
            }
        }
        return result;
    }
}
