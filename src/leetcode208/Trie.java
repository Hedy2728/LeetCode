package leetcode208;

class Trie {
    private class Node{
        Node[] childs = new Node[26];
        boolean isLeaf;
    }

    private Node root = new Node();

    public Trie() {

    }

    public void insert(String word) {
        insert(word, root);
    }

    private void insert(String word, Node node) {
        if (node == null) {
            return;
        }
        if (word.length() == 0) {
            node.isLeaf = true;
            return;
        }
        int index = indexForChar(word.charAt(0));
        if (node.childs[index] == null) {
            node.childs[index] = new Node();
        }
        insert(word.substring(1), node.childs[index]);
    }

    public boolean search(String word) {
        return search(word, root);
    }
    private boolean search(String word, Node node) {
        if (node == null) {
            return false;
        }
        if (word.length() == 0) {
            return node.isLeaf;
        }
        int index = indexForChar(word.charAt(0));
        return search(word.substring(1),node.childs[index]);
    }

    public boolean startWith(String prefix) {
        return startWith(prefix, root);
    }

    private boolean startWith(String prefix, Node node) {
        if (node == null) {
            return false;
        }
        if (prefix.length() == 0) {
            return true;
        }
        int index = indexForChar(prefix.charAt(0));
        return startWith(prefix.substring(1), node.childs[index]);
    }
    private int indexForChar(char ch) {
        return ch-'a';
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("abc");
//        boolean b = t.search("abc");
        boolean c = t.startWith("a");
        System.out.println(c);
    }

}
