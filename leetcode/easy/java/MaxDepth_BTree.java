package leetcode.easy.java;
import leetcode.pojo.TreeNode;

public class MaxDepth_BTree {
    private int maxDepthVal = 0;
    public void traverse(TreeNode root, int val){
        if(root == null) return;
        this.maxDepthVal = Math.max(maxDepthVal, val);
        traverse(root.left, val+1);
        traverse(root.right, val+1);
    }
    public int maxDepth(TreeNode root) {
        if(root == null) return this.maxDepthVal;
        traverse(root, 0);
        return this.maxDepthVal+1;
    }
}
