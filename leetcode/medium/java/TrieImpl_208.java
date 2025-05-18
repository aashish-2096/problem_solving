class Node {
    Node[] links = new Node[26];
    boolean isEnd;

    public Node() {

    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public Node get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, Node newNode) {
        links[ch - 'a'] = newNode;
    }

    public void setFlag() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}

public class TrieImpl_208 {
    
        Node root;
    
        public TrieImpl_208() {
            root = new Node();
        }
    
        public void insert(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                if (!node.containsKey(word.charAt(i))) {
                    node.put(word.charAt(i), new Node());
                }
                node = node.get(word.charAt(i));
            }
            node.setFlag();
        }
    
        public boolean search(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                if (!node.containsKey(word.charAt(i))) {
                    return false;
                }
                node = node.get(word.charAt(i));
            }
            return node.isEnd();
        }
    
        public boolean startsWith(String prefix) {
            Node node = root;
            for (int i = 0; i < prefix.length(); i++) {
                if (!node.containsKey(prefix.charAt(i))) {
                    return false;
                }
                node = node.get(prefix.charAt(i));
            }
            return true;
        }
    }