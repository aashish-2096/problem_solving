package leetcode.easy.java;
import leetcode.pojo.*;

public class PathSum_112 {
    private boolean status = false;
    private void checkSum(TreeNode root, int currSum, int targetSum) {
        if (root == null) {
            return;
        }
        currSum = currSum + root.val;
        if (root.left == null && root.right == null) {
            if (targetSum == currSum) {
                this.status = true;
                return;
            }
        }
        checkSum(root.left, currSum, targetSum);
        checkSum(root.right, currSum, targetSum);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root != null) {
            checkSum(root, 0, targetSum);
        }
        return this.status;
    }
}
