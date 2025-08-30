import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MinGeneticMutation_433 {
    private boolean isDiffOne(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;
        int diff = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                diff++;
                if (diff > 1)
                    return false;
            }
        }
        return diff == 1;
    }

    public int minMutation(String beginWord, String endWord, String[] wordList) {
        Map<String, List<String>> paths = new HashMap<>();
        int size = wordList.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                String src = wordList[i];
                String dest = wordList[j];
                if (isDiffOne(src, dest)) {
                    paths.computeIfAbsent(src, k -> new ArrayList<>()).add(dest);
                }
            }
        }
        for (String str : wordList) {
            if (isDiffOne(beginWord, str)) {
                paths.computeIfAbsent(beginWord, k -> new ArrayList<>()).add(str);
            }
        }
        Set<String> visited = new HashSet<>();
        Queue<String> qu = new LinkedList<>();
        qu.add(beginWord);
        visited.add(beginWord);
        int length = 0;
        while (!qu.isEmpty()) {
            int level = qu.size();
            for (int i = 0; i < level; i++) {
                String str = qu.poll();
                if (endWord.equals(str))
                    return length;
                List<String> stList = paths.getOrDefault(str, new ArrayList<>());
                for (String st : stList) {
                    if (!visited.contains(st)) {
                        qu.add(st);
                        visited.add(st);
                    }
                }
            }
            length += 1;
        }
        return -1;
    }
}
