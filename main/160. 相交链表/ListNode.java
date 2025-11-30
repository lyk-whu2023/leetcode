//给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
// 如果两个链表不存在相交节点，返回 null 。

public class ListNode {
  int val;
  ListNode next;
  ListNode(int x) {
      val = x;
      next = null;
  }
}
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null || headB==null){
            return null;
        }
        ListNode nodeA=headA;
        ListNode nodeB=headB;
        while (nodeA!=nodeB){
            if( nodeA == null){
                nodeA = headB;
            }else{
                nodeA = nodeA.next;
            }
            if( nodeB == null){
                nodeB = headA;
            }else{
                nodeB = nodeB.next;
            }
        }
        return nodeA;
    }
}