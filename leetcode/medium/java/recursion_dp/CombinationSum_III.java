package recursion_dp;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_III {
    List<List<Integer>> resultSet = new ArrayList<>();
    public void recursion(int start, int n, int k, List<Integer> takenElements) {
        if (n == 0 && k == 0) {
            resultSet.add(new ArrayList<>(takenElements));
            return;
        }
        if (k < 0 || n < 0)
            return;
        for (int i = start; i < 10; i++) {
            takenElements.add(i);
            recursion(i + 1, n - i, k - 1, takenElements);
            takenElements.remove(takenElements.size() - 1);
        }
    }


    public List<List<Integer>> combinationSum3(int k, int n) {
        recursion(1, n, k, new ArrayList<>());
        return resultSet;
    }
}
