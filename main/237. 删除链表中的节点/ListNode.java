//有一个单链表的 head，我们想删除它其中的一个节点 node。
//给你一个需要删除的节点 node 。你将 无法访问 第一个节点  head。
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}