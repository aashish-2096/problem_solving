import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidSudoku_36 {
    boolean isValid = true;
    private int getCharToCheck(char ch) {
        if (ch != '.') {
            int num = ch - '0';
            return num;
        }
        return -1;
    }

    private boolean validRow(int row, char value, Map<Integer, List<Integer>> rowMap) {
        int num = getCharToCheck(value);
        if (num == -1)
            return true;
        List<Integer> rowList = rowMap.get(row);
        return rowList.get(num) <= 1;
    }

    private boolean validCol(int col, char value, Map<Integer, List<Integer>> colMap) {
        int num = getCharToCheck(value);
        if (num == -1)
            return true;
        List<Integer> colList = colMap.get(col);
        return colList.get(num) <= 1;
    }

    private boolean validSubMat(int x, int y, char[][] board) {
        int[] arr = new int[10];
        int n = board.length;
        for (int i = x; i < x + 3 && i < n; i++) {
            for (int j = y; j < y + 3 && j < n; j++) {
                int num = getCharToCheck(board[i][j]);
                if (num != -1) {
                    if (arr[num] != 0) {
                        return false;
                    } else {
                        arr[num] += 1;
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, List<Integer>> colMap = new HashMap<>();
        Map<Integer, List<Integer>> rowMap = new HashMap<>();
        int n = board.length;
        for (int i = 0; i <= n; i++) {
            colMap.put(i, new ArrayList<>(Collections.nCopies(n + 1, 0)));
        }
        for (int i = 0; i <= n; i++) {
            rowMap.put(i, new ArrayList<>(Collections.nCopies(n + 1, 0)));
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char ch = board[i][j];
                int num = getCharToCheck(ch);
                if (num != -1) {
                    List<Integer> col_ = colMap.get(j);
                    List<Integer> row_ = rowMap.get(i);
                    int colVal = col_.get(num) + 1;
                    int rowVal = row_.get(num) + 1;
                    col_.set(num, colVal);
                    row_.set(num, rowVal);
                    if (colVal > 1 || rowVal > 1) {
                        isValid = false;
                    }
                    colMap.put(j, col_);
                    rowMap.put(i, row_);
                }
            }
        }
        if (!isValid) {
            return false;
        }
        for (Map.Entry<Integer, List<Integer>> mp : colMap.entrySet()) {
            for (Integer i : mp.getValue()) {
                System.out.print(i);
            }
        }

        for (Map.Entry<Integer, List<Integer>> mp : colMap.entrySet()) {
            for (Integer i : mp.getValue()) {
                System.out.print(i);
            }
        }
        boolean status = true;
        for (int i = 0; i < n; i++) {
            int rowValid = -1;
            for (int j = 0; j < n; j++) {
                if (rowValid == -1) {
                    boolean rowCheck = validRow(i, board[i][j], rowMap);
                    if (rowCheck) {
                        rowValid = 1;
                    } else {
                        return false;
                    }
                }
                boolean colCheck = validCol(j, board[i][j], colMap);
                if (!colCheck) {
                    return false;
                }
            }
        }
        for (int i = 0; i < n; i += 3) {
            for (int j = 0; j < n; j += 3) {
                boolean isValid = validSubMat(i, j, board);
                if (!isValid) {
                    return false;
                }
            }
        }
        return status;
    }
}
