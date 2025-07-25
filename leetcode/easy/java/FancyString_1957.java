package leetcode.easy.java;

public class FancyString_1957 {
    public String makeFancyString(String s) {
        int size = s.length();
        if (size < 3) {
            return s;
        }
        char[] charArray = s.toCharArray();
        char prev1 = charArray[1], prev2 = charArray[0];
        int index = 2;
        StringBuilder result = new StringBuilder();
        result.append(prev2).append(prev1);
        while (index < size) {
            if (charArray[index] == prev1 && charArray[index] == prev2) {
                index++;
            } else {
                prev2 = prev1;
                prev1 = charArray[index];
                result.append(charArray[index]);
                index++;
            }
        }
        return result.toString();
    }
}
