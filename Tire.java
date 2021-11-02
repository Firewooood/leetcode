class TireNode{
    boolean isWord; //若为true，则表示该字符为一字符串的结尾。
    TireNode[] children = new TireNode[26];
}

class Trie {
    TireNode root;
    //构造一个空的树
    public Trie() {
        root = new TireNode();
    }
    
    public void insert(String word) {
        TireNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int w = word.charAt(i) - 'a';
            if (cur.children[w] == null) {
                cur.children[w] = new TireNode();
            }
            cur = cur.children[w];
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        int len = word.length();
        TireNode cur = root;
        for (int i = 0; i < len; i++) {
            int w = word.charAt(i) - 'a';
            if (cur.children[w] == null) {
                return false;
            }
            cur = cur.children[w];
        }
        if (cur.isWord)
            return true;
        return false;
    }
    
    public boolean startsWith(String prefix) {
        int len = prefix.length();
        TireNode cur = root;
        for (int i = 0; i < len; i++) {
            int w = prefix.charAt(i) - 'a';
            if (cur.children[w] == null) {
                return false;
            }
            cur = cur.children[w];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        System.out.println(trie.search("apple"));
        System.out.println(trie.startsWith("ap"));
        System.out.println(trie.search("apl"));
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */