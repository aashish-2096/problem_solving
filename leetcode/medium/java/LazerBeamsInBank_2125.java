import java.util.ArrayList;
import java.util.List;

public class LazerBeamsInBank_2125 {
    public int numberOfBeams(String[] bank) {
        List<Integer> rowMap = new ArrayList<>();
        for (int i = 0; i < bank.length; i++) {
            int rowCount = 0;
            for (int j = 0; j < bank[i].length(); j++) {
                if (bank[i].charAt(j) == '1') {
                    rowCount += 1;
                }
            }
            rowMap.add(rowCount);
        }
        int numOfBeams = 0;
        int current = 0;
        boolean prevIsZero = true;
        for (int i = 1; i < rowMap.size(); i++) {
            if (rowMap.get(current) == 0) {
                current = i;
                continue;
            } else if (rowMap.get(current) != 0 && rowMap.get(i) != 0) {
                if (i - current == 1) {
                    numOfBeams += (rowMap.get(current) * rowMap.get(i));
                    current = i;
                } else if (i - current > 1 && prevIsZero) {
                    numOfBeams += (rowMap.get(current) * rowMap.get(i));
                    current = i;
                }
            } else if (rowMap.get(current) != 0 && rowMap.get(i) == 0) {
                prevIsZero &= true;
            }
        }
        return numOfBeams;
    }
}
