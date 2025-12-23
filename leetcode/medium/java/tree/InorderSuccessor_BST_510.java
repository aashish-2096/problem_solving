package tree;
public class InorderSuccessor_BST_510 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };

private Node getLeftMost(Node node) {
        if (node != null && node.left != null) {
            return getLeftMost(node.left);
        }
        return node;
    }

    private Node checkNodeOnRight(Node node) {
        if (node == null)
            return node;
        Node root = node.parent;
        if (root != null && root.right == node) {
            return checkNodeOnRight(root);
        }
        return root;
    }

    public Node inorderSuccessor(Node node) {
        if (node == null)
            return node;
        if (node.right != null) {
            return getLeftMost(node.right);
        }
        Node root = node.parent;
        if (root == null) {
            return getLeftMost(node.right);
        }
        if (root.left == node) {
            if (node.right != null)
                return getLeftMost(node.right);
            return root;
        }
        if (root.right == node) {
            return checkNodeOnRight(root);
        }
        return null;
    }
}
