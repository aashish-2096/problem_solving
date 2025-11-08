public class RandomPick_WithWeight_528 {
    int len = -1;
    int[] prefixSum;
    int totalSum = 0;
    public RandomPick_WithWeight_528(int[] w) {
        this.len = w.length;
        this.prefixSum = new int[len];
        for (int i = 0; i < len; i++) {
            this.totalSum += w[i];
            this.prefixSum[i] = this.totalSum;
        }
    }

    public int pickIndex() {
        int min = 0;
        int max = this.len - 1;
        if (min == max)
            return min;
        double randomSum = Math.random() * this.totalSum;
        // int result = 0;
        // for (int i = 0; i < this.prefixSum.length; i++) {
        //     if (this.prefixSum[i] > randomSum) {
        //         result = i;
        //         break;
        //     }
        // }
        int low = 0, high = this.prefixSum.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (this.prefixSum[mid] < randomSum) {
                low = mid + 1;
            } else
                high = mid;
        }
        return low;
    }
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
}
