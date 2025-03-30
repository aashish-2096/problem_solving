import leetcode.pojo.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count += 1;
            temp = temp.next;
        }
        int nfs = count - n;
        if (nfs == 0)
            return head.next;
        temp = head;
        while (temp != null && nfs >= 1) {
            nfs--;
            if (nfs == 0) {
                break;
            }
            temp = temp.next;
        }
        if (nfs == 0 && temp != null && temp.next != null) {
            temp.next = temp.next.next;
        }
        return head;
    }
}