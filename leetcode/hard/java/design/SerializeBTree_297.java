package leetcode.hard.java.design;

import java.util.LinkedList;
import java.util.Queue;
import leetcode.pojo.TreeNode;

public class SerializeBTree_297 {
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    private void inorder(TreeNode root, StringBuilder stringBuilder) {
        if (root == null) {
            stringBuilder.append("null:");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                stringBuilder.append("null:");
            } else {
                stringBuilder.append(node.val);
                stringBuilder.append(":");
                queue.add(node.left);
                queue.add(node.right);
            }
        }
    }

    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        inorder(root, result);
        return result.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.equals("null:"))
            return null;
        String[] arr = data.split(":");
        int n = arr.length;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(arr[0]));
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < n) {
            TreeNode temp = queue.poll();
            String val = arr[i++];
            if (!val.equals("null")) {
                TreeNode left = new TreeNode(Integer.valueOf(val));
                temp.left = left;
                queue.add(left);
            }
            String val2 = arr[i++];
            if (!val2.equals("null")) {
                TreeNode right = new TreeNode(Integer.valueOf(val2));
                temp.right = right;
                queue.add(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
}
