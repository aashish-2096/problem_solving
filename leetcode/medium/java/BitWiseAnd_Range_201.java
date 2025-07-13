public class BitWiseAnd_Range_201 {
    int getMSB(int num) {
        return (int) (Math.log(num) / Math.log(2));
    }

    /**
     * Check MSB and reducing the size of comparizon window.
     */
    public int rangeBitwiseAnd(int left, int right) {
        int result = 0;
        int lMSB = getMSB(left);
        int rMSB = getMSB(right);
        while (lMSB == rMSB && left > 0) {
            int num = 1 << lMSB;
            result += num;
            left -= num;
            right -= num;
            lMSB = getMSB(left);
            rMSB = getMSB(right);
        }
        return result;
    }
}
