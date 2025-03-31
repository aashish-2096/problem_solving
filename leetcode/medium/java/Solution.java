import leetcode.pojo.*;
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
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        ListNode result = null;
        while (slow != null && fast != null) {
            slow = slow.next;
            if (fast.next != null)
                fast = fast.next.next;
            else {
                return null;
            }
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                result = slow;
                break;
            }
        }
        return result;
    }
}