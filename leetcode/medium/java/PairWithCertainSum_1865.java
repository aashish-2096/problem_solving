import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class PairWithCertainSum_1865 {
    Map<Integer, List<Integer>> mp1, mp2;
    ArrayList<Integer> numsList;
    private void setValues(int[] ar, Map<Integer, List<Integer>> mp) {
        if (ar.length > 0) {
            for (int i = 0; i < ar.length; i++) {
                int num = ar[i];
                if (!mp.containsKey(num)) {
                    mp.put(num, new ArrayList<>());
                }
                mp.get(num).add(i);
            }
        }
    }

    public PairWithCertainSum_1865(int[] nums1, int[] nums2) {
        this.mp1 = new TreeMap<>();
        this.mp2 = new TreeMap<>();
        this.numsList = new ArrayList<>();
        setValues(nums1, this.mp1);
        setValues(nums2, this.mp2);
        for (Integer nm : nums2) {
            this.numsList.add(nm);
        }
    }

    public void add(int index, int val) {
        int currentValue = numsList.get(index);
        int newTarget = currentValue + val;
        numsList.set(index, newTarget);
        if (!mp2.containsKey(newTarget)) {
            mp2.put(newTarget, new ArrayList<>());
        }
        mp2.get(newTarget).add(index);
        List<Integer> currentIndexes = mp2.get(currentValue);
        if (currentIndexes.size() == 1) {
            mp2.remove(currentValue);
        } else {
            List<Integer> updatedIndex = currentIndexes.stream().filter(ind -> ind != index)
                    .collect(Collectors.toList());
            mp2.put(currentValue, updatedIndex);
        }
    }

    public int count(int tot) {
        int count = 0;
        for (Map.Entry<Integer, List<Integer>> entry : mp1.entrySet()) {
            int value = entry.getKey();
            int targetDiff = tot - value;
            if(targetDiff < 0){
                break;
            }
            if (mp2.containsKey(targetDiff)) {
                count += entry.getValue().size() * mp2.get(targetDiff).size();
            }
        }
        return count;
    }
}
