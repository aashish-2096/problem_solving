import leetcode.pojo.*;

public class LCA_236 {
    TreeNode currentNode = null;
    public int traverse(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return 0;
        int left = traverse(root.left, p, q);
        int right = traverse(root.right, p, q);
        int currentMatch = (root.val == p.val || root.val == q.val) ? 1 : 0;
        int sum = left + right + currentMatch;
        if (sum == 2) {
            if (this.currentNode == null) {
                this.currentNode = root;
            }
        }
        return sum;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        this.currentNode = null;
        traverse(root, p, q);
        return this.currentNode;
    }
}
