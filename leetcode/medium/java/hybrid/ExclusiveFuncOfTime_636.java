package hybrid;

import java.util.List;
import java.util.Stack;

public class ExclusiveFuncOfTime_636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] exTime = new int[n];
        Stack<Integer> stack = new Stack<>();
        long prevTime = -1;
        for (String log : logs) {
            String[] items = log.split(":");
            int id = Integer.valueOf(items[0]);
            String type = items[1];
            int time = Integer.valueOf(items[2]);
            if (type.equalsIgnoreCase("start")) {
                if (stack.isEmpty()) {
                    stack.push(id);
                } else {
                    int topNode = stack.peek();
                    int diff = time - (int) prevTime;
                    exTime[topNode] += diff;
                    stack.push(id);
                }
                prevTime = time;
            } else if (type.equalsIgnoreCase("end") && !stack.isEmpty()) {
                int topNode = stack.pop();
                if (topNode == id) {
                    int diff = time - (int) prevTime + 1;
                    exTime[id] += diff;
                }
                prevTime = time + 1;
            }
        }
        return exTime;
    }
}
