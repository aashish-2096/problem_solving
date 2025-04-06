package leetcode.easy.java;
import leetcode.pojo.*;

public class SameTree_100 {
    public boolean recurion(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null && q != null) {
            return false;
        }
        if (p != null && q == null) {
            return false;
        }
        boolean status = true;
        if (p.val == q.val) {
            status &= recurion(p.left, q.left);
            status &= recurion(p.right, q.right);
        } else {
            status = false;
        }
        return status;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return recurion(p, q);
    }
    
}
