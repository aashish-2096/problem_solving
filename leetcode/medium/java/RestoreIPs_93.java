import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RestoreIPs_93 {
    Set<String> validIPlIst = new HashSet<>();

    private void parseIps(String s, String tempString, int sections) {
        int strLen = s.length() - 1;
        if (strLen < 0)
            return;
        if (sections == 1) {
            Integer num = Integer.parseInt(s);
            if (num >= 0 && num <= 255) {
                if (!String.valueOf(num).equals(s)) {
                    return;
                }
                tempString = s + "." + tempString;
                validIPlIst.add(tempString);
                return;
            }
        }
        int maxIterationIndex = s.length() > 3 ? 3 : s.length() - 1;
        for (int i = 0; i < maxIterationIndex; i++) {
            String temp = s.substring(strLen - i);
            Integer num = Integer.parseInt(temp);
            if (num >= 0 && num <= 255) {
                String res;
                if (!String.valueOf(num).equals(temp)) {
                    continue;
                }
                if (tempString.equals("")) {
                    res = temp;
                } else
                    res = temp + "." + tempString;
                String remaining = s.substring(0, strLen - i);
                parseIps(remaining, res, sections - 1);
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {
        if(s.length() > 12) return new ArrayList<>();
        parseIps(s, "", 4);
        return new ArrayList<>(validIPlIst);
    }
}
