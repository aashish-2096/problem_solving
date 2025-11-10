package leetcode.easy.java;
import leetcode.pojo.TreeNode;

public class SecondMinimumBinaryTree_671 {
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
    long minValue = Long.MAX_VALUE, rootValue = Integer.MIN_VALUE;
    public void traverse(TreeNode root) {
        if (root == null)
            return;
        if (root.left != null && root.right != null) {
            int left = root.left.val;
            int right = root.right.val;
            if (rootValue != Integer.MIN_VALUE) {
                if (left > right && left > rootValue) {
                    minValue = (long) Math.min(minValue, left);
                } else if (right >= left && right > rootValue) {
                    minValue = (long) Math.min(minValue, right);
                }
            }
            traverse(root.left);
            traverse(root.right);
        }
    }

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return -1;
        rootValue = root.val;
        traverse(root);
        return minValue == Long.MAX_VALUE ? -1 : (int) minValue;
    }
}
