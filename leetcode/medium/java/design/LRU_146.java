package design;

import java.util.HashMap;
import java.util.Map;

/**
 * Asked in Arista Networks.
 */
public class LRU_146 {
    class Node {
        Node next;
        Node prev;
        int value;
        int key;

        Node(int key, int value) {
            this.value = value;
            this.key = key;
        }
    }

    Node head;
    Node tail;
    int capacity;
    Map<Integer, Node> map = new HashMap<>();

    public LRU_146(int capacity) {
        this.capacity = capacity;
    }

    private void moveToFront(Node currNode) {
        if (currNode == head)
            return;
        if (currNode.prev != null)
            currNode.prev.next = currNode.next;
        if (currNode.next != null)
            currNode.next.prev = currNode.prev;
        if (currNode == tail) {
            tail = tail.prev;
        }
        currNode.prev = null;
        currNode.next = head;
        if (head != null)
            head.prev = currNode;
        head = currNode;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node current = map.get(key);
            moveToFront(current);
            return current.value;
        }
        return -1;
    }

    private void printMap() {
        for (var mp : map.keySet()) {
            System.out.println(mp);
        }
    }

    public void put(int key, int value) {
        Node currentNode = new Node(key, value);
        if (map.containsKey(key)) {
            currentNode = map.get(key);
            moveToFront(currentNode);
            head.value = value;
        } else {
            if (head == null) {
                head = currentNode;
                tail = currentNode;
                map.put(key, currentNode);
            } else {
                head.prev = currentNode;
                currentNode.next = head;
                head = currentNode;
                map.put(key, currentNode);
            }
            if (map.size() > capacity) {
                int currKey = tail.key;
                map.remove(currKey);
                if (tail.prev != null) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    head = tail = null;
                }
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
