import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KPairSmallestSum_373 {
    class Solution {
    class PairSum {
        int sum;
        int left;
        int right;

        public PairSum(int sum, int l, int r) {
            this.sum = sum;
            this.left = l;
            this.right = r;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<PairSum> pq = new PriorityQueue<>((PairSum a, PairSum b) -> a.sum - b.sum);
        int left = 0;
        int leftSize = nums1.length;
        int rightSize = nums2.length;
        for (int i = 0; i < Math.min(leftSize, k); i++) {
            int a = nums1[i];
            int b = nums2[0];
            pq.offer(new PairSum(a + b, i, 0));
        }
        while (k > 0 && !pq.isEmpty()) {
            PairSum pr = pq.poll();
            res.add(List.of(nums1[pr.left], nums2[pr.right]));
            k--;
            if (pr.right < rightSize - 1) {
                pq.offer(new PairSum(nums1[pr.left] + nums2[pr.right + 1], pr.left, pr.right + 1));
            }
        }
        return res;
    }
}
}
