//给你一个链表的头节点 head 和一个整数 val ，
//请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。


public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head==null){
            return null;
        }
        ListNode dummy=new ListNode(-1,head);
        ListNode pre=dummy;
        ListNode cur=head;
        while (cur!=null){
            if (cur.val==val){
                pre.next=cur.next;
                cur=cur.next;
            }
            else {
                pre=pre.next;
                cur=cur.next;
            }
        }
        return dummy.next;
    }
}