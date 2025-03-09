class Solution {
public:
    int minimumRecolors(string blocks, int k) {
        int black = 0, white = 0;
        for (int i = 0; i < k; i++) {
            if (blocks[i] == 'W') {
                white += 1;
            } else {
                black += 1;
            }
        }
        int start = 0, current = k;
        int minRecolor = k - black;
        while (current < blocks.size()) {
            if (blocks[start] == 'W') {
                white--;
            } else {
                black--;
            }
            start++;
            if (blocks[current] == 'W') {
                white += 1;
            } else {
                black += 1;
            }
            int temp = k - black;
            minRecolor = min(temp, minRecolor);
            current++;
        }
        return minRecolor;
    }
};