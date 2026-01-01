package leetcode.hard.java.linkedlist;
import leetcode.pojo.ListNode;

public class MergeKSortedList_23 {
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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        ListNode prev = null;
        while (true) {
            boolean isEmpty = true;
            int index = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) continue;
                if (index == -1 || (lists[i] != null && lists[index].val > lists[i].val)) {
                    isEmpty = false;
                    index = i;
                }
            }

            if (!isEmpty && index != -1) {
                ListNode nextNode = lists[index];
                lists[index] = nextNode.next;
                nextNode.next = null;
                if (result == null) {
                    result = nextNode;
                    prev = nextNode;
                } else {
                    prev.next = nextNode;
                    prev = nextNode;
                }
            } else {
                break;
            }
        }
        return result;
    }
}
