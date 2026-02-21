package leetcode.hard.LinkedIn;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public String getTransformedResult(List<String> tempList, int wordLength, boolean isLast,
            int maxWidth) {
        if (isLast || tempList.size() == 1) {
            String line = String.join(" ", tempList);
            return line + (" ".repeat(maxWidth - line.length()));
        }
        int totalSpace = maxWidth - wordLength;
        int gaps = tempList.size() - 1;
        int individualSpaces = totalSpace / gaps;
        int extraSpace = totalSpace % gaps;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < tempList.size(); i++) {
            str.append(tempList.get(i));
            if (i < gaps)
                str.append(" ".repeat(individualSpaces + (extraSpace-- > 0 ? 1 : 0)));
        }
        return str.toString();
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
        int wordLength = 0;
        for (int i = 0; i < words.length; i++) {
            int currentWordLength = words[i].length();
            if (wordLength + tempList.size() + currentWordLength > maxWidth) {
                String transformed = getTransformedResult(tempList, wordLength, false, maxWidth);
                result.add(transformed);
                tempList.clear();
                wordLength = 0;
            }
            wordLength += currentWordLength;
            tempList.add(words[i]);
        }
        String transformed = getTransformedResult(tempList, wordLength, true, maxWidth);
        result.add(transformed);
        return result;
    }
}
