//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

public class ListNode {
    int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) {
          this.val = val; this.next = next;
      }
}
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre=head;
        ListNode end=head;

        for (int i = 0; i < n; i++) {
            end=end.next;
        }
        if (end == null) {
            return head.next;  // 删除头节点
        }
        while (end.next!=null){
            pre=pre.next;
            end=end.next;
        }
        // 执行删除操作
        pre.next = pre.next.next;

        return head;
    }
    public ListNode removeNthFromEnd2(ListNode head, int n) {

        // 添加表头
        ListNode dummy = new ListNode(-1);

        dummy.next = head;

        // 寻找需要删除的节点节点
        ListNode cur = head;

        // 指针 latter 指向虚拟头结点
        ListNode latter = dummy;

        ListNode former = head;

        // 让 former 指针先向前走 n 步
        for (int i = 0 ; i < n; i++) {
            // former 指针向后移动
            former = former.next;
        }

        // 接下来，让这两个指针 former 和 latter 同时向前移动，直到前指针 former 指向 NULL
        while (former != null) {
            // former 指针向后移动
            former = former.next;

            // latter 来到 cur 的位置
            latter = cur;

            // cur 指针向后移动
            cur = cur.next;
        }

        // 删除 cur 这个位置的结点
        latter.next = cur.next;

        // 返回虚拟头结点的下一个结点
        return dummy.next;
    }
}