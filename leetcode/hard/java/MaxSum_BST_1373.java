package leetcode.hard.java;
import leetcode.pojo.*;

public class MaxSum_BST_1373 {
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
class Solution {
    private int maxSum = 0;

    class NodeInfo {
        boolean isBST;
        int min, max, sum;

        NodeInfo(boolean isBST, int min, int max, int sum) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }

    private NodeInfo binaryTreeTraverse(TreeNode root) {
        if (root == null) {
            return new NodeInfo(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        NodeInfo left = binaryTreeTraverse(root.left);
        NodeInfo right = binaryTreeTraverse(root.right);
        if (left.isBST && right.isBST && root.val > left.max && root.val < right.min) {
            int currSum = root.val + left.sum + right.sum;
            this.maxSum = Math.max(maxSum, currSum);
            return new NodeInfo(true,
                    Math.min(root.val, left.min),
                    Math.max(root.val, right.max),
                    currSum);
        }
        return new NodeInfo(false, 0, 0, 0);
    }

    /**
    Pair Implementation missed checking the entire node if it's a Btree or Not based on range of values it can contain.
    */
    /*
    public Pair<Boolean, Integer> maxSumTree(TreeNode root) {
        if (root == null)
            return new Pair<>(true, 0);
        boolean binaryTreeNode = false;
        Pair<Boolean, Integer> leftSum = maxSumTree(root.left);
        Pair<Boolean, Integer> rightSum = maxSumTree(root.right);
        if (leftSum.getKey() && rightSum.getKey()) {
            int sum = leftSum.getValue() + rightSum.getValue() + root.val;
            if (binaryTreeNode && sum > this.maxSum) {
                System.out.println("MaxSumUpdatedTo--" + sum + "--" + root.val);
                this.maxSum = sum;
            }
            return new Pair(binaryTreeNode, sum);
        }
        return new Pair(false, 0);
    
    }
    */
    public int maxSumBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        binaryTreeTraverse(root);
        return this.maxSum;
    }
}
}
