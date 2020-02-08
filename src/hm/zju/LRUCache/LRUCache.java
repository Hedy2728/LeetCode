package hm.zju.LRUCache;

import java.util.HashMap;

class DLinkedNode {
    int key;
    int value;
    DLinkedNode pre;
    DLinkedNode post;

//    DLinkedNode(int key, int value) {
//        this.key = key;
//        this.value = value;
//    }
}

public class LRUCache {
    private HashMap<Integer, DLinkedNode> hashMap;
    private DLinkedNode head, tail;
    private int capacity, size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        hashMap = new HashMap<>(capacity);
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.post = tail;
        head.pre = null;
        tail.pre = head;
        tail.post = null;
    }

    public int get(int key) {
        DLinkedNode node = hashMap.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = hashMap.get(key);
        if (node == null) {
            if (size < capacity) {
                size++;
            } else {
                hashMap.remove(tail.pre.key);
                delNode(tail.pre);
            }
            DLinkedNode newNode = new DLinkedNode();
            newNode.value = value;
            newNode.key = key;
            addNode(newNode);
            hashMap.put(key, newNode);
        } else {
            node.value = value;
            delNode(node);
            addNode(node);
        }

    }

    private void moveToHead(DLinkedNode node) {
        delNode(node);
        addNode(node);
    }

    private void delNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;

        pre.post = node.post;
        post.pre = pre;
        node.pre = null;
        node.post = null;
    }

    private void addNode(DLinkedNode node) {
        node.post = head.post;
        head.post.pre = node;
        head.post = node;
        node.pre = head;
    }

    @Override
    public String toString() {
        return hashMap.keySet().toString();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,2);
        cache.put(2,4);
        cache.get(1);
        cache.put(3,5);
        cache.put(1,3);
        cache.get(1);
        System.out.println(cache);
    }
}
