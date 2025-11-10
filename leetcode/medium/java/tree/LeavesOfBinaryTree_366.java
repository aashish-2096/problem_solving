package tree;

import java.util.ArrayList;
import java.util.List;
import leetcode.pojo.TreeNode;
public class LeavesOfBinaryTree_366 {
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
    List<List<Integer>> leavesCollected = new ArrayList<>();
    List<Integer> leaves = new ArrayList<>();
    public boolean traverseAndCollect(TreeNode root, TreeNode parent, boolean left) {
        if (root != null) {
            if (root.left == null && root.right == null && parent != null) {
                leaves.add(root.val);
                if (left)
                    parent.left = null;
                else {
                    parent.right = null;
                }
                return false;
            } else if (root.left == null && root.right == null && parent == null) {
                leaves.add(root.val);
                return true;
            } else {
                traverseAndCollect(root.left, root, true);
                traverseAndCollect(root.right, root, false);
                return false;
            }
        }
        return true;
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        if (root == null)
            return leavesCollected;
        while (root != null) {
            leaves = new ArrayList<>();
            boolean status = traverseAndCollect(root, null, false);
            leavesCollected.add(leaves);
            if (status) {
                break;
            }
        }
        return leavesCollected;
    }
}
