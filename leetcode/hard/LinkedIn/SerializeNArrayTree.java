package leetcode.hard.LinkedIn;

import java.util.ArrayList;
import java.util.List;


public class SerializeNArrayTree {
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Codec {
    public class IndexItem {
        int value;
        public IndexItem(int val) {
            this.value = val;
        }
        public int getValue() {
            return this.value;
        }
        public void increment() {
            this.value++;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root == null) {
            return "[]";
        }
        if (root.children == null) {
            return "[" + root.val + "]";
        }
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("[" + root.val);
        int len = root.children.size();
        for (int i = 0; i < len; i++) {
            String s1 = serialize(root.children.get(i));
            strBuilder.append(s1);
        }
        strBuilder.append("]");
        return strBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        Node result = null;
        if (!data.equals("[]")) {
            return deSerialize(data, new IndexItem(0));
        }
        return result;
    }

    public Node deSerialize(String data, IndexItem index) {
        Node node = null;
        if (data.charAt(index.getValue()) == '[') {
            int num = 0;
            index.increment();
            while (index.getValue() < data.length()
                    && (data.charAt(index.getValue()) != '[' && data.charAt(index.getValue()) != ']')) {
                int indexV = index.getValue();
                int val = data.charAt(indexV) - '0';
                num = (num * 10) + val;
                index.increment();
            }
            node = new Node(num, new ArrayList());
            while (index.getValue() < data.length() && data.charAt(index.getValue()) == '[') {
                node.children.add(deSerialize(data, index));
            }
            if (index.getValue() < data.length() && data.charAt(index.getValue()) == ']') {
                index.increment();
                return node;
            }
        }
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
