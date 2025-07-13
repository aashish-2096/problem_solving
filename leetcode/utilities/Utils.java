package leetcode.utilities;

public class Utils {
    /**
     * MSB of number.
    */ 
    public static int getMSB(int num) {
        return (int) (Math.log(num) / Math.log(2));
    }
}
