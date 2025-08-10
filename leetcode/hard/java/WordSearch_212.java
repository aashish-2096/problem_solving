package leetcode.hard.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch_212 {
    Set<String> allWordsWithChar = new HashSet<>();
    public void collectAllWords(char[][] board, int x, int y, String st, int maxLen, int minLen) {
        int row = board.length;
        int col = board[0].length;
        if (x < 0 || y < 0 || x >= row || y >= col)
            return;
        if (board[x][y] == '#')
            return;
        char current = board[x][y];
        String effective = st + current;
        if (effective.length() > maxLen)
            return;

        if (effective.length() >= minLen && effective.length() <= maxLen) {
            allWordsWithChar.add(effective);
        }
        board[x][y] = '#';
        collectAllWords(board, x + 1, y, effective, maxLen, minLen);
        collectAllWords(board, x - 1, y, effective, maxLen, minLen);
        collectAllWords(board, x, y + 1, effective, maxLen, minLen);
        collectAllWords(board, x, y - 1, effective, maxLen, minLen);
        board[x][y] = current;
    }

    public List<String> findWords(char[][] board, String[] words) {
        Set<Character> charList = new HashSet<>();
        Set<String> reqList = new HashSet<>();
        int maxLen = Integer.MIN_VALUE;
        int minLen = Integer.MAX_VALUE;
        ;
        for (String word : words) {
            charList.add(word.charAt(0));
            maxLen = Math.max(maxLen, word.length());
            minLen = Math.min(minLen, word.length());
            reqList.add(word);
        }
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char curr = board[i][j];
                if (charList.contains(curr)) {
                    collectAllWords(board, i, j, "", maxLen, minLen);
                }
            }
        }
        List<String> res = new ArrayList<>();
        for (String st : reqList) {
            if (allWordsWithChar.contains(st)) {
                res.add(st);
            }
        }
        return res;
    }
}
