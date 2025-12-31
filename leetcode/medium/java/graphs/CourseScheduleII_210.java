package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseScheduleII_210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] incomingEdges = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            adjList.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
            incomingEdges[to] += 1;
        }
        Queue<Integer> qu = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (incomingEdges[i] == 0) {
                qu.add(i);
            }
        }
        List<Integer> schedule = new ArrayList<>();
        while (!qu.isEmpty()) {
            Integer val = qu.poll();
            schedule.add(val);
            if (!adjList.containsKey(val)) {
                continue;
            }
            for (int item : adjList.get(val)) {
                incomingEdges[item]--;
                if (incomingEdges[item] == 0) {
                    qu.add(item);
                }
            }
        }
        if (schedule.size() != numCourses)
            return new int[0];
        return schedule.stream().mapToInt(Integer::intValue).toArray();
    }
}
