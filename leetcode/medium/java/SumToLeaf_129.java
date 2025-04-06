import leetcode.pojo.TreeNode;

public class SumToLeaf_129 {
    private int totalSum = 0;
    public void traverseSum(TreeNode root, int currSum) {
        if (root == null) {
            return;
        }
        int sum = currSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            this.totalSum += sum;
            return;
        }
        traverseSum(root.left, sum);
        traverseSum(root.right, sum);

    }

    public int sumNumbers(TreeNode root) {
        if (root != null) {
            traverseSum(root, 0);
        }
        return this.totalSum;
    }
}
