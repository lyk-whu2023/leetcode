//给定一个单链表 L 的头节点 head ，单链表 L 表示为：
//L0 → L1 → … → Ln - 1 → Ln
//请将其重新排列后变为：
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
//不能只是单纯地改变节点内部的值，而是需要实际的进行节点交换。


  //Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
    public void reorderList(ListNode head) {
        if (head==null){
            return;
        }
        ListNode mid=middleNode(head);
        ListNode l1=head;
        ListNode l2=mid.next;
        mid.next=null;
        l2=reverseList(l2);
        mergeList(l1, l2);
    }
    public ListNode middleNode(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }

    public void mergeList(ListNode l1, ListNode l2){
        ListNode n1;
        ListNode n2;
        while (l1!=null && l2!=null){
            n1=l1.next;
            n2=l2.next;
            l1.next=l2;
            l1=n1;
            l2.next=l1;
            l2=n2;
        }
    }
}