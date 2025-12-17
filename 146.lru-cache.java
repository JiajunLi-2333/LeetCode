/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */
import java.util.HashMap;
import java.util.Map;
// @lc code=start
class LRUCache {
    private static class Node{
        int key, val;
        Node prev, next;

        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    private final Node dummy = new Node(0, 0);
    private final Map<Integer, Node> mapNode= new HashMap<>();
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy.next = dummy;
        dummy.prev = dummy;
    }


    //O(1) time complexity
    public int get(int key) {
        Node node = getHelper(key);
        return node != null ? node.val : -1;
    }

    private Node getHelper(int key){
        if(!mapNode.containsKey(key)){
            return null;
        }
        Node target = mapNode.get(key);
        removeHelper(target);
        pushHelper(target);
        return target;

    }
    private void removeHelper(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void pushHelper(Node node){
        node.prev = dummy;
        node.next = dummy.next;
        dummy.next.prev = node;
        dummy.next = node;
    }
    
    public void put(int key, int value) {
        //1st: the node already exists
        Node node = getHelper(key);
        if(node != null){
            node.val = value;
            return;
        }

        //add node and  verify size
        Node newNode = new Node(key, value);
        mapNode.put(key,newNode);
        pushHelper(newNode);

        if(mapNode.size() > capacity){
            Node last = dummy.prev;
            mapNode.remove(last.key);
            removeHelper(last);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

