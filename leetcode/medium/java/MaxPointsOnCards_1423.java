import java.util.Arrays;

public class MaxPointsOnCards_1423 {
    public int maxScore(int[] cardPoints, int k) {
        int maxSum = Integer.MIN_VALUE;
        int len = cardPoints.length;
        int sum = Arrays.stream(cardPoints).sum();
        if (k == len) {
            return sum;
        }
        int secondIndexSum = 0;
        for (int i = len - k; i < len; i++) {
            secondIndexSum += cardPoints[i];
        }
        int left = -1, right = len - k - 1;
        while (right < len) {
            if (left == -1) {
                left++;
                right++;
                maxSum = Math.max(maxSum, secondIndexSum);
            }
            secondIndexSum += cardPoints[left];
            secondIndexSum -= cardPoints[right];
            left++;
            right++;
            maxSum = Math.max(maxSum, secondIndexSum);
        }
        return maxSum;
    }
}
