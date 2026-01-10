package leetcode.hard.java.design;

import java.util.HashMap;
import java.util.Map;

public class LFU_Cache_460 {

    class Node {
        int key, value;
        Node prev, next;
        int count;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.count = 1;
        }
    }

    class DoubleLL {
        Node head, tail;
        int size;

        DoubleLL() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast() {
            if (size == 0)
                return null;
            Node rm = tail.prev;
            remove(rm);
            return rm;
        }
    }

    Map<Integer, Node> itemMap = new HashMap<>();
    Map<Integer, DoubleLL> countMap = new HashMap<>();
    int minFreq = 0;
    int capacity = 0;

    public LFU_Cache_460(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!itemMap.containsKey(key))
            return -1;
        Node node = itemMap.get(key);
        updateFrequency(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;

        if (itemMap.containsKey(key)) {
            Node node = itemMap.get(key);
            node.value = value;
            updateFrequency(node);
            return;
        }
        if (itemMap.size() == capacity) {
            DoubleLL minList = countMap.get(minFreq);
            Node evict = minList.removeLast();
            itemMap.remove(evict.key);
        }
        Node node = new Node(key, value);
        itemMap.put(key, node);
        countMap.computeIfAbsent(1, k -> new DoubleLL()).addFirst(node);
        minFreq = 1;
    }

    void updateFrequency(Node node) {
        int freq = node.count;
        DoubleLL dll = countMap.get(freq);
        dll.remove(node);
        if (minFreq == freq && dll.size == 0) {
            minFreq++;
        }
        node.count++;
        countMap.computeIfAbsent(node.count, k -> new DoubleLL()).addFirst(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
