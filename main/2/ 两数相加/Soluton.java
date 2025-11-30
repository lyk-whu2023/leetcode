//给你两个 非空 的链表，表示两个非负的整数。
// 它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//请你将两个数相加，并以相同形式返回一个表示和的链表。
//你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

 //Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         ListNode dummy =new ListNode(-1);
         int carryBit=0;
        ListNode cur = dummy;
        while (l1!=null || l2!=null){
            int x;
            if( l1 == null){
                x = 0;
            }else{
                x = l1.val;
            }
            int y;
            if( l2 == null){
                y = 0;
            }else{
                y = l2.val;
            }
            int sum = x + y + carryBit;;
            carryBit = sum / 10;
            int digit = sum % 10;
            ListNode digitNode = new ListNode(digit);
            cur.next = digitNode;
            cur = cur.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(carryBit == 1) {
            ListNode carryBitNode = new ListNode(carryBit);
            cur.next = carryBitNode;
        }
        return dummy.next;
    }
}