package leetcode.easy.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubsequenceOfLengthKWithLargestSum_2099 {
    public int[] maxSubsequence(int[] nums, int k) {
        List<Integer> arr = new ArrayList<>();
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            arr.add(nums[i]);
            mp.putIfAbsent(nums[i], new ArrayList<>());
            mp.get(nums[i]).add(i);
        }
        Collections.sort(arr, Collections.reverseOrder());
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            List<Integer> indexes = mp.get(arr.get(i));
            res.add(indexes.get(0));
            indexes.remove(0);
            mp.put(arr.get(i), indexes);
        }
        Collections.sort(res);
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = nums[res.get(i)];
        }
        return temp;
    }
}
