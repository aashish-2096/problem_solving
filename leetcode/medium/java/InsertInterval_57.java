import java.util.ArrayList;
import java.util.List;

public class InsertInterval_57 {
    class Solution {
    class PairEntry {
        int l;
        int r;

        public PairEntry(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<PairEntry> pr = new ArrayList<>();
        int left = newInterval[0];
        int right = newInterval[1];
        int i = 0;
        int size = intervals.length;
        while (i < size && intervals[i][1] < left) {
            int currentL = intervals[i][0];
            int currentR = intervals[i][1];
            pr.add(new PairEntry(currentL, currentR));
            i++;
        }
        while (i < size && intervals[i][0] <= right) {
            int currentL = intervals[i][0];
            int currentR = intervals[i][1];
            left = Math.min(left, currentL);
            right = Math.max(right, currentR);
            i++;
        }
        pr.add(new PairEntry(left, right));
        while (i < size) {
            int currentL = intervals[i][0];
            int currentR = intervals[i][1];
            pr.add(new PairEntry(currentL, currentR));
            i++;
        }
        int size2 = pr.size();
        int[][] res = new int[size2][2];
        for (int j = 0; j < size2; j++) {
            PairEntry p = pr.get(j);
            res[j][0] = p.l;
            res[j][1] = p.r;
        }
        return res;
    }
}
}
