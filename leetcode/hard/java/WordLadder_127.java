package leetcode.hard.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder_127 {
    int pathLength = Integer.MAX_VALUE;
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

    public void traverse(String beginWord, String endWord, Map<String, List<String>> paths, Set<String> visited,
            int length) {
        if (visited.size() == paths.size()) {
            return;
        }
        if (beginWord.equals(endWord)) {
            this.pathLength = Math.min(length, this.pathLength);
            return;
        }
        if (visited.contains(beginWord)) {
            return;
        }
        List<String> reachables = paths.getOrDefault(beginWord, new ArrayList<>());
        visited.add(beginWord);
        for (String str : reachables) {
            if (endWord.equals(str)) {
                int current = length + 1;
                this.pathLength = Math.min(current, this.pathLength);
            } else {
                traverse(str, endWord, paths, visited, length + 1);
            }
        }
        visited.remove(beginWord);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> paths = new HashMap<>();
        int size = wordList.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                String src = wordList.get(i);
                String dest = wordList.get(j);
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
        int length = 1;
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
        return 0;
    }

}
