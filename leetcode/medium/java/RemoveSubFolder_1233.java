import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class RemoveSubFolder_1233 {
    public List<String> removeSubfolders(String[] folder) {
        List<String> modifiedFolder = Arrays.asList(folder)
                .stream()
                .sorted((a, b) -> Integer.compare(a.length(), b.length()))
                .collect(Collectors.toList());
        Map<String, String> strMap = new TreeMap<>();
        for (int i = 0; i < modifiedFolder.size(); i++) {
            String current = modifiedFolder.get(i);
            String[] strTemp = current.split("/");
            String intermediate = "";
            boolean found = false;
            for (int j = 0; j < strTemp.length; j++) {
                intermediate += strTemp[j];
                if (strMap.containsKey(intermediate)) {
                    found = true;
                    break;
                } else {
                    intermediate += "/";
                }
            }
            if (!found) {
                strMap.put(current, current);
            }
        }
        return new ArrayList<>(strMap.values());
    }

    public List<String> removeSubfoldersImproved(String[] folder) {
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        String prev = "";
        for (int i = 0; i < folder.length; i++) {
            if (prev == "" || !folder[i].startsWith(prev + "/")) {
                result.add(folder[i]);
                prev = folder[i];
            }
        }
        return result;
    }
}
