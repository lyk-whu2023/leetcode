//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val>list2.val){
            return mergeTwoLists(list2,list1);
        }
        ListNode node1=list1;
        ListNode node2=list2;
        while (node1.next!=null && node2!=null){
            if (node2.val<=node1.next.val){
                ListNode tmp=node2.next;
                node2.next=node1.next;
                node1.next=node2;
                node2=tmp;
            }
            else {
                node1=node1.next;
            }
        }
        if (node2 != null) {
            node1.next = node2;
        }
        return list1;
    }
}

class Solution2 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        current.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }
}