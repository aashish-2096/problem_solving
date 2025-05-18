import java.util.List;

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

class Trie {

    Node root;

    public Trie() {
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

    public String getPrefix(String word) {
        Node node = root;
        String result = "";
        for (int i = 0; i < word.length(); i++) {
            if (node.isEnd()) {
                return result;
            }
            if (!node.containsKey(word.charAt(i))) {
                if (node.isEnd()) {
                    return result;
                }
                return "";
            }
            result += word.charAt(i);
            node = node.get(word.charAt(i));
        }
        return result;
    }
}

public class ReplaceWords_648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String str : dictionary) {
            trie.insert(str);
        }
        String str = "";
        String[] st = sentence.split(" ");
        for (int i = 0; i < st.length; i++) {
            String trieStr = trie.getPrefix(st[i]);
            if (trieStr.length() == 0) {
                str += st[i];
            } else {
                str += trieStr;
            }
            if (i != st.length - 1) {
                str += " ";
            }
        }
        return str;
    }
}
