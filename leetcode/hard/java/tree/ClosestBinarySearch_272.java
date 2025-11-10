package leetcode.hard.java.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import leetcode.pojo.*;

public class ClosestBinarySearch_272 {

    class Pair{
        int key;
        double value;
        public Pair(int key, double value){
            this.key = key;
            this.value = value;
        }

        public double getValue(){
            return this.value;
        }
         public int getKey(){
            return this.key;
        }

    }
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
    private void traverse(TreeNode root, double target, PriorityQueue<Pair> pq) {
        if (root == null)
            return;
        traverse(root.left, target, pq);
        traverse(root.right, target, pq);
        double diff = Math.abs((double) root.val - target);
        pq.add(new Pair(root.val, diff));
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(Pair::getValue));
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            traverse(root, target, pq);
            if (pq.size() >= k) {
                while (k > 0) {
                    Pair res = pq.poll();
                    result.add(res.getKey());
                    k--;
                }
            }
        }
        return result;
    }
}
