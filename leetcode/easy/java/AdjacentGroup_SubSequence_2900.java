package leetcode.easy.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacentGroup_SubSequence_2900 {
     List<Integer> maxList = new ArrayList<>();
    Map<Integer, List<Integer>> dpArray = new HashMap<>();
    public List<Integer> dp(int current, int[] groups, int index, List<Integer> currentArray) {
        int length = groups.length;
        if (currentArray.size() > maxList.size()) {
            maxList = new ArrayList<>(currentArray);
        }
        if (index >= length) {
            return new ArrayList<>();
        }
        if (dpArray.containsKey(index)) {
            return dpArray.get(index);
        }
        List<Integer> left = new ArrayList<>();
        List<Integer>right = new ArrayList<>();
        if (index < length && current != groups[index]) {
            int updatedVal = current != -1 ? (current + 1) % 2 : groups[index];
            List<Integer> arr = new ArrayList<>(currentArray);
            arr.add(index);
            left = dp(updatedVal, groups, index + 1, arr);
        }
        right = dp(current, groups, index + 1, currentArray);
        List<Integer> result = (left.size() > right.size()) ? left : right;
        dpArray.put(index, result);
        return result;
    }

    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> arr = new ArrayList<>();
        dp(-1, groups, 0, new ArrayList<>());
        for (int i : maxList) {
            arr.add(words[i]);
        }
        return arr;
    }
}
