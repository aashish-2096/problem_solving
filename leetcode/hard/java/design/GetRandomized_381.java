package leetcode.hard.java.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GetRandomized_381 {
    List<Integer> arr;
    Map<Integer, Set<Integer>> randomMap = new HashMap<>();
    public GetRandomized_381() {
        this.randomMap = new HashMap<>();
        this.arr = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (randomMap.containsKey(val)) {
            randomMap.get(val).add(arr.size());
            arr.add(val);
            return false;
        }
        randomMap.put(val, new LinkedHashSet<>());
        randomMap.get(val).add(arr.size());
        arr.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!randomMap.containsKey(val))
            return false;
        int removalIndex = randomMap.get(val).iterator().next();
        int lastElement = arr.get(arr.size() - 1);
        randomMap.get(val).remove(removalIndex);
        if (removalIndex != arr.size() - 1) {
            arr.set(removalIndex, lastElement);
            randomMap.get(lastElement).add(removalIndex);
        }  
        randomMap.get(lastElement).remove(arr.size() - 1);
        arr.remove(arr.size() - 1);
        if (randomMap.get(val).isEmpty()) {
            randomMap.remove(val);
        }
        return true;
    }

    public int getRandom() {
        int size = arr.size();
        int randomNumber = (int) (Math.random() * (size));
        return arr.get(randomNumber);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
