package leetcode.easy.java;
import leetcode.pojo.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution160 {
    private int getLengthOfList(ListNode temp) {
        int len = 0;
        while (temp.next != null) {
            temp = temp.next;
            len += 1;
        }
        return len;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA, tempB = headB;
        int lenA = getLengthOfList(tempA);
        int lenB = getLengthOfList(tempB);
        tempA = headA;
        tempB = headB;
        if (lenA > lenB) {
            int diff = lenA - lenB;
            while (diff > 0) {
                tempA = tempA.next;
                diff--;
            }
        } else {
            int diff = lenB - lenA;
            while (diff > 0) {
                tempB = tempB.next;
                diff--;
            }
        }
        if (tempA == tempB) {
            return tempA;
        }
        while (tempA.next != null && tempB.next != null) {
            if (tempA.next == tempB.next) {
                return tempA.next;
            }
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return null;

    }
}
