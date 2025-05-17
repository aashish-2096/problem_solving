import java.util.HashMap;
import java.util.Map;

public class LargestCountSender_2284 {
    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> mp = new HashMap<>();
        String maxWord = "";
        int maxWordSize = 0;
        for (int i = 0; i < messages.length; i++) {
            String msg = messages[i];
            String[] msgSplit = msg.split(" ");
            mp.computeIfAbsent(senders[i], p -> 0);
            mp.computeIfPresent(senders[i], (p, v) -> v + msgSplit.length);
            if (mp.get(senders[i]) > maxWordSize) {
                maxWordSize = mp.get(senders[i]);
                maxWord = senders[i];
            }
            if (mp.get(senders[i]) == maxWordSize) {
                if (senders[i].compareTo(maxWord) > 0) {
                    maxWordSize = mp.get(senders[i]);
                    maxWord = senders[i];
                }
            }
        }
        return maxWord;
    }
}
