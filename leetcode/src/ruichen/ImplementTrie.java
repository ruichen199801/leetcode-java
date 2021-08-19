package ruichen;

public class ImplementTrie {

    // #208 https://leetcode.com/problems/implement-trie-prefix-tree/
    // Design, Trie
    // search, startsWith: TC = O(m), SC = O(1) (m = word length)
    // insert: TC = O(m), SC = O(m) (worst case: new word)

    class Trie {

        private Node root; // dummy head

        /** Initialize your data structure here. */
        public Trie() {
            root = new Node(' ');
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new Node(c); // append a new node
                }
                cur = cur.children[c - 'a'];
            }
            cur.isWord = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Node node = getNode(word);
            return node != null && node.isWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            return getNode(prefix) != null;
        }

        private Node getNode(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.children[c - 'a'] == null) {
                    return null;
                }
                cur = cur.children[c - 'a'];
            }
            return cur;
        }

        class Node {
            public char c;
            public boolean isWord;
            public Node[] children;

            public Node(char c) {
                this.c = c;
                isWord = false;
                children = new Node[26]; // 'a' - 'z'
            }
        }
    }
}
