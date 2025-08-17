public class LongestUnivaluePath_687 {
    public class Pair{
        int key; int value;
        Pair(int key, int value){
            this.key = key;
            this.value = value;
        }
        public int getKey(){
            return this.key;
        }
        public int getValue(){
            return this.value;
        }
    }
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    int maxLen = 0;
    public Pair traverse(TreeNode root) {
        if (root == null)
            return new Pair(-1001, 0);
        Pair left = traverse(root.left);
        Pair right = traverse(root.right);
        int currVal = root.val;
        int pairLeft = (int) left.getKey();
        int pairRight = (int) right.getKey();
        int lenRight = (int) right.getValue();
        int lenLeft = (int) left.getValue();
        if (currVal == pairLeft && currVal == pairRight && pairLeft != -1001 && pairRight != -1001) {
            int len = lenRight + lenLeft + 1;
            this.maxLen = Math.max(this.maxLen, len);
            return new Pair(currVal, Math.max(lenRight, lenLeft) + 1);
        } else if (currVal == pairLeft && currVal != pairRight && pairLeft != -1001) {
            this.maxLen = Math.max(this.maxLen, lenLeft + 1);
            return new Pair(currVal, lenLeft + 1);
        } else if (currVal != pairLeft && currVal == pairRight && pairRight != -1001) {
            this.maxLen = Math.max(this.maxLen, lenRight + 1);
            return new Pair(currVal, lenRight + 1);
        }
        return new Pair(root.val, 1);
    }

    public int longestUnivaluePath(TreeNode root) {
        traverse(root);
        return this.maxLen > 0 ? this.maxLen - 1 : 0;
    }
}
