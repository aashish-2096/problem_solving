package leetcode.easy.java;

public class Binary_Addition_67 {
    public String addNums(String greater, String smaller, int small, int large) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int largeDiff = large - small;
        for (int i = smaller.length() - 1; i >= 0; i--) {
            int numA = smaller.charAt(i) - '0';
            int numB = greater.charAt(i + largeDiff) - '0';
            int sum = numA + numB + carry;
            result.append(sum % 2);
            carry = sum / 2;
        }
        if (small != large) {
            for (int i = large - small - 1; i >= 0; i--) {
                int numA = greater.charAt(i) - '0';
                int sum = numA + carry;
                result.append(sum % 2);
                carry = sum / 2;
            }
        }
        if (carry > 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }

    public String addBinary(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        if (lenA >= lenB) {
            return addNums(a, b, lenB, lenA);
        }
        return addNums(b, a, lenA, lenB);

    }
}