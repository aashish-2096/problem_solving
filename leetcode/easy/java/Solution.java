package leetcode.easy.java;
import leetcode.pojo.ListNode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        boolean hasCycle = false;
        while (slow != null && fast != null) {
            slow = slow.next;
            if (fast.next != null)
                fast = fast.next.next;
            else {
                hasCycle = false;
                break;
            }
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        return hasCycle;
    }
}