package leetcode.utilities;

import java.util.Arrays;
import java.util.Comparator;

public class Utils {
    /**
     * MSB of number.
    */ 
    public static int getMSB(int num) {
        return (int) (Math.log(num) / Math.log(2));
    }

    public static String getSortedString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void sortStringByLenght(String [] str){
        Arrays.sort(str, Comparator.comparingInt(String::length));
    }
}
