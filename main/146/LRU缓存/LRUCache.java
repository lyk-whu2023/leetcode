//请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
//实现 LRUCache 类：
//LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
//int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
//void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；
// 如果不存在，则向缓存中插入该组 key-value 。
// 如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
//函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。

import java.util.HashMap;
import java.util.Map;

class ALNode {
    int key;
    int val;
    ALNode next;
    ALNode pre;

    public ALNode(int key,int val) {
        this.key=key;
        this.val=val;
    }

    public ALNode() {

    }
}
class LRUCache {
    Map<Integer,ALNode> maps;
    ALNode head;
    ALNode tail;
    int capacity;
    int length;
    public LRUCache(int capacity) {
        maps=new HashMap<>();
        head=new ALNode();
        tail=new ALNode();
        this.capacity=capacity;
        head.next=tail;
        tail.pre=head;
    }

    public int get(int key) {
        ALNode node=maps.get(key);
        if (node==null){
            return -1;
        }
        else {
            moveToHead(node);
            return node.val;
        }
    }

    public void put(int key, int value) {
        ALNode node=maps.get(key);
        if (node==null){
            ALNode newNode=new ALNode(key,value);
            maps.put(key,newNode);
            addToHead(newNode);
            length++;
            if (length>capacity){
                ALNode tail=removeTail();
                maps.remove(tail.key);
                length--;
            }
        }
        else {
            node.val = value;
            moveToHead(node);
        }
    }
    private void addToHead(ALNode node) {
        node.pre=head;
        node.next=head.next;
        head.next.pre=node;
        head.next=node;
    }

    private void removeNode(ALNode node) {
        node.pre.next=node.next;
        node.next.pre=node.pre;
    }

    private void moveToHead(ALNode node) {
        removeNode(node);
        addToHead(node);
    }

    private ALNode removeTail() {
        ALNode res = tail.pre;
        removeNode(res);
        return res;
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */