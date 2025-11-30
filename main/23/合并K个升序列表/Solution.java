//给你一个链表数组，每个链表都已经按升序排列。
//请你将所有链表合并到一个升序链表中，返回合并后的链表。

import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode>pq=new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        for (ListNode node :
                lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        ListNode dummyNode=new ListNode();
        ListNode tail=dummyNode;
        while (!pq.isEmpty()){
            ListNode cur=pq.poll();
            tail.next=cur;
            tail=cur;

            // PriorityQueue 实现了 Queue 接口，不允许放入 null 元素
            if (cur.next != null) {
                // 再把新的节点也加入到优先队列当中
                pq.offer(cur.next);
            }
        }
        return dummyNode.next;
    }
}