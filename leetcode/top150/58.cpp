class Solution {
    public int lengthOfLastWord(String s) {
        String[] str = s.trim().split(" ");
        int size = str.length;
        return str[size - 1].length();
    }
}