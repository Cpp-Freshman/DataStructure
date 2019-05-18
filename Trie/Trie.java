package DSandAL.Trie;
/*
  Trie
 */

import java.util.TreeMap;

public class Trie {

    private class Node{
        private boolean isWord;
        private TreeMap<Character,Node> map;

        public Node(boolean isWord){
            this.isWord = isWord;
            map = new TreeMap<>();
        }
        public Node(){
           this(false);
        }
    }
    private Node root;
    private int size;

    public Trie(){
        root = new Node();
        size = 0;
    }

    public int getSize(){return size;}

    public void add(String word){
        Node cur = root;
        for(int i = 0;i < word.length();i++){
            char c = word.charAt(i);
            //cur的next已经有c节点了
            if(cur.map.get(c) == null){
                cur.map.put(c, new Node());
            }
            cur = cur.map.get(c);
        }
        //当前cur不一定是叶子节点
        if(!cur.isWord){
            cur.isWord = true;
            size++;
        }
    }
    public boolean contains(String word){
        Node cur = root;
        for(int i = 0;i < word.length();i++){
            char c = word.charAt(i);
            if(cur.map.get(c) == null)
                return false;
            cur = cur.map.get(c);
        }
        return cur.isWord;
    }
    public boolean prefix(String s){
        Node cur = root;
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            if(cur.map.get(c) == null)
                return false;
            cur = cur.map.get(c);
        }
        return true;
    }

}
