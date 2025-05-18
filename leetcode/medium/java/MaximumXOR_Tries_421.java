class Node {
    Node[] links = new Node[2];
    boolean isEnd;

    public Node() {

    }

    public boolean containsKey(int bit) {
        return links[bit] != null;
    }

    public Node get(int bit) {
        return links[bit];
    }

    public void put(int bit, Node newNode) {
        links[bit] = newNode;
    }

    public void setFlag() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}

class Trie {

    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(int num) {
        Node node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = num >> i & 1;
            if (!node.containsKey(bit)) {
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
        node.setFlag();
    }

    public int searchMax(int num) {
        Node node = root;
        int maxNum = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = num >> i & 1;
            if (node.containsKey(1 - bit)) {
                maxNum = maxNum | 1 << i;
                node = node.get(1 - bit);
            } else {
                node = node.get(bit);
            }
        }
        return maxNum;
    }
}

public class MaximumXOR_Tries_421 {
    public int findMaximumXOR(int[] nums) {
        Trie root = new Trie();
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            root.insert(nums[i]);
        }
         for (int i = 0; i < nums.length; i++) {
            int num = root.searchMax(nums[i]);
            maxNum = Math.max(num, maxNum);
        }
        return maxNum;
    }
}
