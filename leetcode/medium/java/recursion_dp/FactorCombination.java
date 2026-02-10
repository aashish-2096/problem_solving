package recursion_dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FactorCombination {
    private void backTrack(LinkedList<Integer> factors, List<List<Integer>> result) {
        if (factors.size() > 1) {
            result.add(new ArrayList<>(factors));
        }
        int lastValue = factors.removeLast();
        int initial = factors.isEmpty() ? 2 : factors.peekLast();
        for (int i = initial; i <= lastValue / i; ++i) {
            if (lastValue % i == 0) {
                factors.add(i);
                factors.add(lastValue / i);
                backTrack(factors, result);
                factors.removeLast();
                factors.removeLast();
            }
        }
        factors.add(lastValue);
    }

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer>factors = new LinkedList<>();
        factors.add(n);
        backTrack(factors, result);
        return result;
    }
}
