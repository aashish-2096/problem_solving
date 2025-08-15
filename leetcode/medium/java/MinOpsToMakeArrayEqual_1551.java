public class MinOpsToMakeArrayEqual_1551 {
     public int minOperations(int n) {
        int left = 0, right = n-1;
        int sum = 0;
        while(left < right){
            sum+= right-left;
            left++;
            right--;
        }
        return sum;
    }
}
