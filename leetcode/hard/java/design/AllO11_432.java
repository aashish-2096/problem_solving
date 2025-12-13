package leetcode.hard.java.design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllO11_432 {
    class Node {
        Set<String> keys;
        int count;
        Node prev;
        Node next;

        Node(int value) {
            count = value;
            prev = null;
            next = null;
            keys = new HashSet<>();
        }
    };

    Node head = null;
    Node tail = null;
    Map<String, Node> map;

    public AllO11_432() {
        map = new HashMap<>();
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    public void inc(String key) {
        if (map.containsKey(key)) {
            Node currNode = map.get(key);
            int count = currNode.count;
            currNode.keys.remove(key);
            Node nextNode = currNode.next;
            if (nextNode == tail || nextNode.count != count + 1) {
                Node newNode = new Node(count + 1);
                newNode.keys.add(key);
                newNode.next = currNode.next;
                newNode.prev = currNode;
                currNode.next.prev = newNode;
                currNode.next = newNode;
                map.put(key, newNode);
            } else {
                nextNode.keys.add(key);
                map.put(key, nextNode);
            }
            if (currNode.keys.isEmpty()) {
                currNode.prev.next = currNode.next;
                currNode.next.prev = currNode.prev;
            }
        } else {
            Node firstNode = head.next;
            if (firstNode == tail || firstNode.count > 1) {
                Node newNode = new Node(1);
                newNode.keys.add(key);
                newNode.next = firstNode;
                newNode.prev = head;
                firstNode.prev = newNode;
                head.next = newNode;
                map.put(key, newNode);
            } else {
                firstNode.keys.add(key);
                map.put(key, firstNode);
            }
        }
    }

    public void dec(String key) {
        Node currNode = map.get(key);
        int count = currNode.count;
        currNode.keys.remove(key);
        if (count == 1) {
            map.remove(key);
        } else {
            Node prevNode = currNode.prev;
            if (prevNode == head || prevNode.count < count - 1) {
                Node newNode = new Node(count - 1);
                newNode.keys.add(key);
                newNode.next = currNode;
                newNode.prev = prevNode;
                prevNode.next = newNode;
                currNode.prev = newNode;
                map.put(key, newNode);
            } else {
                prevNode.keys.add(key);
                map.put(key, prevNode);
            }
        }
        if (currNode.keys.isEmpty()) {
            currNode.prev.next = currNode.next;
            currNode.next.prev = currNode.prev;
        }
    }

    public String getMaxKey() {
        if (tail == head.next)
            return "";
        return tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        if (head == tail.prev)
            return "";
        return head.next.keys.iterator().next();
    }
}
