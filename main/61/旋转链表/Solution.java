//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。class ListNode {

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null){
            return head;
        }
        ListNode tail=head;
        int length=1;
        while (tail.next!=null){
            tail=tail.next;
            length++;
        }
        k%=length;
        ListNode finalHead=head;
        ListNode finalTail=head;
        for (int i = 0; i < length - k - 1; i++) {
            finalTail=finalTail.next;
        }
        finalHead=finalTail.next;
        finalTail.next=null;
        tail.next=head;
        return finalHead;
    }
}