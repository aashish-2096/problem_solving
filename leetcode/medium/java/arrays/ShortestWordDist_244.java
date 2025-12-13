package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDist_244 {
    Map<String, List<Integer>> map = new HashMap<>();
    int length = -1;

    public ShortestWordDist_244(String[] wordsDict) {
        for (int i = 0; i < wordsDict.length; i++) {
            if (!map.containsKey(wordsDict[i])) {
                map.put(wordsDict[i], new ArrayList<>());
            }
            map.get(wordsDict[i]).add(i);
        }
        length = wordsDict.length;
    }

    public int shortest(String word1, String word2) {
        if (map.containsKey(word1) && map.containsKey(word2)) {
            List<Integer> w1D = map.get(word1);
            List<Integer> w2D = map.get(word2);
            return getMinN(w2D, w1D);
        }
        return -1;
    }

    int getMinN2(List<Integer> first, List<Integer> second) {
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < first.size(); i++) {
            for (int j = 0; j < second.size(); j++) {
                int diff = Math.abs(first.get(i) - second.get(j));
                distance = Math.min(distance, diff);
            }
        }
        return distance;
    }

    int getMinN(List<Integer> first, List<Integer> second) {
        int distance = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while(i < first.size() && j<second.size()){
            int diff = Math.abs(first.get(i) - second.get(j));
            distance = Math.min(distance, diff);
            if(first.get(i) > second.get(j)){
                j++;
            } else {
                i++;
            }
        }
        return distance;
    }
}
