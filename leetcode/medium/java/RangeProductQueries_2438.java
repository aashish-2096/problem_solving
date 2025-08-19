import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RangeProductQueries_2438 {
    List<Integer> pathSum = new ArrayList<>();
    int mod = 1000000007;
    private long modPow(long base, long exp) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1)
                result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    private void checkPathSum(int target, int currVal, List<Integer> res) {
        if (target == 0) {
            this.pathSum = new ArrayList<>(res);
            return;
        }
        if (target >= currVal) {
            res.add(currVal);
            checkPathSum(target - currVal, currVal, res);
            res.remove(res.size() - 1);
        } else {
            checkPathSum(target, currVal / 2, res);
        }
    }

    public int[] productQueries(int n, int[][] queries) {
        int[] res = new int[queries.length];
        int maxPositive = Integer.highestOneBit(n);
        if ((n & (n - 1)) == 0) {
            maxPositive = n;
        }
        checkPathSum(n, maxPositive, new ArrayList<>());
        Collections.reverse(this.pathSum);
        long prod = this.pathSum.get(0);
        long[] prodArr = new long[this.pathSum.size()];
        prodArr[0] = prod;
        for (int i = 1; i < this.pathSum.size(); i++) {
            prod *= this.pathSum.get(i);
            prod = prod % mod;
            prodArr[i] = prod;
        }
        for (int i = 0; i < queries.length; i++) {
            int low = queries[i][0];
            int high = queries[i][1];
            if (low == 0) {
                res[i] = (int) prodArr[high];
            } else {
                long inv = modPow(prodArr[low - 1], mod - 2);
                res[i] = (int) ((prodArr[high] * inv) % mod);
            }
        }
        return res;
    }
}
