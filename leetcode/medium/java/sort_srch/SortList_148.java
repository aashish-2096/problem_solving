package sort_srch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import leetcode.pojo.ListNode;

public class SortList_148 {
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
    public ListNode sortList(ListNode head) {
        List<Integer> items = new ArrayList<>();
        ListNode node = head;
        if (head != null) {
            while (node != null) {
                items.add(node.val);
                node = node.next;
            }
            Collections.sort(items);
            node = head;
            int i = 0;
            while (node != null) {
                node.val = items.get(i++);
                node = node.next;
            }
        }
        return head;
    }
}
