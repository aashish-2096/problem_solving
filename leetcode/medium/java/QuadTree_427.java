public class QuadTree_427 {
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}


class Solution {
    private Node checkAndGet(int[][] grid, int row, int col, int range) {
        if (range == 1) {
            return new Node(grid[row][col] == 1, true);
        }
        int newRange = range / 2;
        Node tLeft = checkAndGet(grid, row, col, newRange);
        Node tRight = checkAndGet(grid, row, col + newRange, newRange);
        Node bLeft = checkAndGet(grid, row + newRange, col, newRange);
        Node bRight = checkAndGet(grid, row + newRange, col + newRange, newRange);
        Node root = new Node();
        boolean val = tLeft.val || bLeft.val || tRight.val || bRight.val;
        if (tLeft.isLeaf && tRight.isLeaf && bLeft.isLeaf && bRight.isLeaf && tLeft.val == tRight.val
                && tLeft.val == bLeft.val && tLeft.val == bRight.val) {
            return new Node(tLeft.val, true);
        } else {
            root.isLeaf = false;
            root.val = val;
            root.topLeft = tLeft;
            root.topRight = tRight;
            root.bottomLeft = bLeft;
            root.bottomRight = bRight;
        }
        return root;
    }

    public Node construct(int[][] grid) {
        int n = grid.length;
        return checkAndGet(grid, 0, 0, n);
        }
    }
}
