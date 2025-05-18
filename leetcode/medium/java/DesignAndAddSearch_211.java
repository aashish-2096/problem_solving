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

class WordDictionary {
    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setFlag();
    }

    private boolean searchInNode(String word, int index, Node node) {
        if (node == null)
            return false;

        if (index == word.length()) {
            return node.isEnd();
        }

        char ch = word.charAt(index);

        if (ch == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.links[i] != null) {
                    if (searchInNode(word, index + 1, node.links[i])) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            if (!node.containsKey(ch)) {
                return false;
            }
            return searchInNode(word, index + 1, node.get(ch));
        }
    }

    public boolean search(String word) {
        Node node = root;
        return searchInNode(word, 0, node);
    }
}

public class DesignAndAddSearch_211 {

    
}
