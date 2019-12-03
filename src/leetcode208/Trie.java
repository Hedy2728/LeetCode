package leetcode208;

class TrieNode {
    //存储子节点
    TrieNode[]  children=new TrieNode[26];
    //存储一条记录，即对应一个单词
    String item="";
    // Initialize your data structure here.
    public TrieNode() {

    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node=this.root;
        for(char c:word.toCharArray())
        {
            if(node.children[c-'a']==null)
            {
                node.children[c-'a']=new TrieNode();
            }
            node=node.children[c-'a'];
        }
        node.item=word;

    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node=this.root;
        for(char c:word.toCharArray())
        {
            if(node.children[c-'a']==null)
            {
                return false;
            }
            node=node.children[c-'a'];
        }
        return node.item.equals(word);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node=this.root;
        for(char c:prefix.toCharArray())
        {
            if(node.children[c-'a']==null)
            {
                return false;
            }
            node=node.children[c-'a'];
        }
        return true;
    }

}