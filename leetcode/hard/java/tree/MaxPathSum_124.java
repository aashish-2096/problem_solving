package leetcode.hard.java.tree;
import leetcode.pojo.*;
public class MaxPathSum_124 {
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
    int maxPathSum = Integer.MIN_VALUE;

    int pathSum(TreeNode root) {
        if (root == null)
            return 0;
        int leftSum = Math.max(0, pathSum(root.left));
        int rightSum = Math.max(0, pathSum(root.right));
        int nodeSum = leftSum + root.val + rightSum;
        maxPathSum = Math.max(maxPathSum, Math.max(nodeSum, root.val));
        return Math.max(leftSum, rightSum) + root.val;
    }

    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return maxPathSum;
    }
}
