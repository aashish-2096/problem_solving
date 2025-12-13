package leetcode.hard.java.design;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaxStack_716 {
    class Node {
        int index;
        int value;
        Node prev;
        Node next;
        Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    class Pair {
        int value;
        int index;

        Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Pair pair = (Pair) o;
            return index == pair.index && value == pair.value;
        }

        @Override
        public int hashCode() {
            return 31 * index + value;
        }
    }

    PriorityQueue<Pair> pqHigh;
    Node head = null;
    Map<String, Node> orderingMap;
    int index = 0;

    public MaxStack_716() {
        index = 0;
        orderingMap = new HashMap<>();
        pqHigh = new PriorityQueue<>(
                (p1, p2) -> {
                    if (p1.value != p2.value) {
                        return Integer.compare(p2.value, p1.value);
                    }
                    return Integer.compare(p2.index, p1.index);
                });
        head = null;
    }

    public void push(int value) {
        String key = index + "-" + value;
        Node node = new Node(index, value);
        if (head != null) {
            node.next = head;
            head.prev = node;
        }
        head = node;
        pqHigh.add(new Pair(index, value));
        index++;
        orderingMap.put(key, node);
    }

    public int pop() {
        Node current = head;
        orderingMap.remove(current.index + "-" + current.value);
        pqHigh.remove(new Pair(current.index, current.value));
        head = head.next;
        return current.value;
    }

    public int top() {
        return head.value;
    }

    public int peekMax() {
        Pair pr = pqHigh.peek();
        return pr.value;
    }

    public int popMax() {
        Pair pr = pqHigh.poll();
        int value = pr.value;
        int indexP = pr.index;
        String keyS = indexP + "-" + value;
        Node curr = orderingMap.get(keyS);
        if (curr == head) {
            head = curr.next;
        } else if (curr != null) {
            if (curr.prev != null)
                curr.prev.next = curr.next;
            if (curr.next != null)
                curr.next.prev = curr.prev;
        }
        return value;
    }

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
}
