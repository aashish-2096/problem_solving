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
    private void addInCaseOfCarry(ListNode prev, int carry) {
        if (carry > 0) {
            ListNode current = new ListNode(carry);
            prev.next = current;
            prev = current;
            carry = 0;
        }
    }

    private void addOtherNodes(ListNode prev, ListNode curr, int carry) {
        while (curr != null) {
            int num = curr.val + carry;
            if (num >= 10) {
                carry = num / 10;
                num = num % 10;
            } else {
                carry = 0;
            }
            ListNode current = new ListNode(num);
            prev.next = current;
            prev = current;
            curr = curr.next;
        }
        addInCaseOfCarry(prev, carry);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, prev = null;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int num = l1.val + l2.val + carry;
            if (num >= 10) {
                carry = num / 10;
                num = num % 10;
            } else {
                carry = 0;
            }
            if (head == null) {
                head = new ListNode(num);
                prev = head;
            } else {
                ListNode current = new ListNode(num);
                prev.next = current;
                prev = current;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null && l2 != null) {
            addOtherNodes(prev, l2, carry);
        } else if (l1 != null && l2 == null) {
            addOtherNodes(prev, l1, carry);
        } else if (carry > 0) {
            addInCaseOfCarry(prev, carry);
        }
        return head;
    }
}