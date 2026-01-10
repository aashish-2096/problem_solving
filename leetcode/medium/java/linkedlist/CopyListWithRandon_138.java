package linkedlist;

import java.util.HashMap;

public class CopyListWithRandon_138 {

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

    public Node copyRandomList(Node head) {
        if (head != null) {
            HashMap<Integer, Node> modified = new HashMap<>();
            HashMap<Node, Integer> original = new HashMap<>();
            Node temp = head;
            Node prev = null;
            Node modifiedHead = null;
            int i = 0;
            while (temp != null) {
                Node newNode = new Node(temp.val);
                if (modifiedHead == null) {
                    modifiedHead = newNode;
                } else {
                    prev.next = newNode;
                }
                modified.put(i, newNode);
                original.put(temp, i);
                prev = newNode;
                temp = temp.next;
                i++;
            }
            temp = head;
            Node newTemp = modifiedHead;
            while (temp != null) {
                newTemp.random = modified.get(original.get(temp.random));
                newTemp = newTemp.next;
                temp = temp.next;
            }
            return modifiedHead;
        }
        return head;

    }
}
