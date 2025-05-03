import java.util.LinkedList;
import java.util.Queue;

class PushDominoes_838 {

    static class SimplePair{
        int index;
        char direction;

        SimplePair(int index, char direction) {
            this.index = index;
            this.direction = direction;
        }
    }
    public String pushDominoes(String dominoes) {
        Queue<SimplePair> directions = new LinkedList<>();
        int firstIndex = -1, lastIndex = -1;
        char[] chars = dominoes.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '.') {
                if (directions.isEmpty()) {
                    firstIndex = i;
                }
                directions.add(new SimplePair(i, chars[i]));
                lastIndex = i;
            }
        }
        if (firstIndex != -1 && chars[firstIndex] == 'L') {
            for (int i = 0; i < firstIndex; i++) {
                chars[i] = 'L';
            }
        }
        if (lastIndex != -1 && chars[lastIndex] == 'R') {
            for (int i = lastIndex + 1; i < chars.length; i++) {
                chars[i] = 'R';
            }
        }

        while (directions.size() >= 2) {
            SimplePair lowIndex = directions.poll();
            SimplePair highIndex = directions.peek();
            int low = lowIndex.index;
            int high = highIndex.index;
            char charL = lowIndex.direction;
            char charR = highIndex.direction;
            if (charL == 'R' && charR == 'L') {
                low++;
                high--;
                while (low < high) {
                    chars[low++] = 'R';
                    chars[high--] = 'L';
                }
            } else if (charL == 'R' && charR == 'R') {
                low++;
                while (low < high) {
                    chars[low++] = 'R';
                }
            } else if (charL == 'L' && charR == 'L') {
                high--;
                while (low < high) {
                    chars[high--] = 'L';
                }
            }
        }
        return new String(chars);
    }
}