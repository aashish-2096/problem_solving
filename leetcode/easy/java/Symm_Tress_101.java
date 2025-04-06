package leetcode.easy.java;
import leetcode.pojo.*;

public class Symm_Tress_101 {
    boolean isSymm(TreeNode p, TreeNode q) {
        if (p == null || q == null)
            return p == q;
        return p.val == q.val && isSymm(p.right, q.left) && isSymm(p.left, q.right);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymm(root.right, root.left);
    }
}
