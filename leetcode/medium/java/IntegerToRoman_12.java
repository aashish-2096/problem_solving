package leetcode.medium.java;

public class IntegerToRoman_12 {
    public String getForOnes(int num) {
        StringBuilder st = new StringBuilder();
        if (num <= 3) {
            for (int i = 0; i < num; i++) {
                st.append("I");
            }
        } else if (num == 4) {
            st.append("IV");
        } else if (num > 4 && num < 9) {
            st.append("V");
            st.append(getForOnes(num - 5));
        } else if (num == 9) {
            st.append("IX");
        }
        return st.toString();
    }

    public String getForTens(int num) {
        StringBuilder st = new StringBuilder();
        if (num <= 3) {
            for (int i = 0; i < num; i++) {
                st.append("X");
            }
        } else if (num == 4) {
            st.append("XL");
        } else if (num > 4 && num < 9) {
            st.append("L");
            st.append(getForTens(num - 5));
        } else if (num == 9) {
            st.append("XC");
        }
        return st.toString();
    }

    public String getForHundreds(int num) {
        StringBuilder st = new StringBuilder();
        if (num <= 3) {
            for (int i = 0; i < num; i++) {
                st.append("C");
            }
        } else if (num == 4) {
            st.append("CD");
        } else if (num > 4 && num < 9) {
            st.append("D");
            st.append(getForHundreds(num - 5));
        } else if (num == 9) {
            st.append("CM");
        }
        return st.toString();
    }

    public String getForTh(int num) {
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < num; i++) {
            st.append("M");
        }
        return st.toString();
    }

    public String intToRoman(int num) {
        int[] arr = new int[4];
        int size = 3;
        for (int i = 0; i < 4; i++) {
            int div = (int) Math.pow(10, size - i);
            int rem = num / div;
            num = num % div;
            arr[i] = rem;
        }
        StringBuilder st = new StringBuilder();
        st.append(getForTh(arr[0]));
        st.append(getForHundreds(arr[1]));
        st.append(getForTens(arr[2]));
        st.append(getForOnes(arr[3]));
        return st.toString();
    }
}
