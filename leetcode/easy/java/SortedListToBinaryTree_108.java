package leetcode.easy.java;
import leetcode.pojo.TreeNode;
public class SortedListToBinaryTree_108 {
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
    public TreeNode buildTree(int[] nums, int low, int high) {
        int mid = low + (high - low) / 2;
        if (high == low)
            return new TreeNode(nums[low]);
        if (low > high)
            return null;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, low, mid - 1);
        root.right = buildTree(nums, mid + 1, high);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        return buildTree(nums, low, high);
    }
}
