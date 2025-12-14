package leetcode.easy.java;

/**
 * Attempted on Maintaining a set with O(N2) compleixity. 
 * On helps as left and right checks are to be made only.
 */
public class CanPlaceFlower_605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 0) {
                int leftCheck = i == 0 ? 0 : flowerbed[i - 1];
                int rightCheck = i == len - 1 ? 0 : flowerbed[i + 1];
                if(leftCheck == 0 && rightCheck == 0){
                    flowerbed[i] = 1;
                    count++;
                }
            }
            if (count == n || n == 0) {
                return true;
            }
        }
        return false;
    }
}
