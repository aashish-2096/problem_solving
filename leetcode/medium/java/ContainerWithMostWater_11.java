public class ContainerWithMostWater_11 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int maxQty = 0;
        while(left < right){
            int width = right - left;
            int maxHeight = Math.min(height[left], height[right]);
            int qty = width * maxHeight;
            maxQty = Math.max(qty, maxQty);
            if(height[left] < height[right]){
                left++;
            } else {
                right --;
            }
        }
        return maxQty;
    }
}
