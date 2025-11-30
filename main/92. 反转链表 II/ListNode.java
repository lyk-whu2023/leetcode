//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
//请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy;
        ListNode cur=head;
        for (int i = 0; i < left-1; i++) {
            pre=pre.next;
            cur=cur.next;
        }
        for (int i = 0; i < right - left; i++) {
            ListNode tmp=cur.next;
            cur.next=cur.next.next;
            tmp.next=pre.next;
            pre.next=tmp;
        }
        return dummy.next;
    }
}