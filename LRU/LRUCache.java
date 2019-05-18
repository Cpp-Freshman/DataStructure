package DSandAL.LRU;
/*
   map + 双端链表，为什么要用双端链表
   也可以用LinkedHashMap实现，有点偷鸡
 */

import java.awt.event.KeyAdapter;
import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private Map<Integer,Node> map;
    private myLinkedList LS;
    private int capacity;
    private int size;
    public LRUCache(int capacity) {
         map = new HashMap<>();
         LS  = new myLinkedList();
         this.capacity = capacity;
         this.size = 0;
    }

    public int get(int key) {
        if(map.get(key) == null)
            return -1;
        Node cur = map.get(key);
        LS.update(cur);
        return cur.val;
    }

    public void put(int key, int value) {
        if(map.get(key) != null){
            Node node1 = map.get(key);
            node1.val = value;
            LS.update(node1);
        }
        else{
            Node node = new Node(key, value);
            LS.addNode(node);
            map.put(key, node);
            size++;
        }
        if(size > capacity){
            Node cur = LS.tail.pre;
            LS.remove(cur);
            map.remove(cur.key);
            size--;
        }
    }


    class myLinkedList{
        public Node head;
        public Node tail;
        Map<Integer,Integer> map = new HashMap<>();

        public myLinkedList() {
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
        }
        public void update(Node node){
            remove(node);
            addNode(node);
        }
        public void addNode(Node node){
            Node nextNode = head.next;
            head.next = node;
            node.pre = head;
            node.next = nextNode;
            nextNode.pre = node;
        }
        public void remove(Node node){
            Node preN = node.pre;
            Node nextN = node.next;
            preN.next = nextN;
            nextN.pre = preN;
        }


    }
    class Node{
        private int key;
        private int val;

        public Node pre;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
