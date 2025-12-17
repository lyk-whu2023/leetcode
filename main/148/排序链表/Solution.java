//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
    public ListNode sortList(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode slow=head;
        ListNode fast=head;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode mid=slow.next;
        slow.next=null;
        ListNode left=sortList(head);
        ListNode right=sortList(mid);
        return merge(left,right);
    }
    private ListNode merge(ListNode l1,ListNode l2){
        ListNode dummy=new ListNode();
        ListNode pre=dummy;
        while (l1!=null&&l2!=null){
            if (l1.val<=l2.val){
                pre.next=l1;
                l1=l1.next;
            }
            else {
                pre.next=l2;
                l2=l2.next;
            }
            pre=pre.next;
        }
        if (l1!=null){
            pre.next=l1;
        }
        if (l2!=null){
            pre.next=l2;
        }
        return dummy.next;
    }
}

class Solution {
    public ListNode sortList(ListNode head) {

        // 获链表的总长度
        int length = 0;

        // 从链表的头节点开始访问
        ListNode node = head;

        // 利用 while 循环，可以统计出链表的节点个数，即长度
        while (node != null) {

            length++;

            node = node.next;

        }

        // 在原链表的头部设置一个虚拟头节点
        // 因为可能会操作到原链表的头节点
        // 设置了虚拟头节点后，原链表的头节点和原链表的其它节点地位一样
        ListNode dummyHead = new ListNode(0, head);

        // 利用 for 循环，执行合并的操作
        // 长度为 1 的链表和长度为 1 的链表合并后，形成一个长度为 2 的链表
        // 长度为 2 的链表和长度为 2 的链表合并后，形成一个长度为 4 的链表
        // 长度为 4 的链表和长度为 4 的链表合并后，形成一个长度为 8 的链表
        // 长度为 8 的链表和长度为 8 的链表合并后，形成一个长度为 16 的链表
        // 也有可能是，长度为 8 的链表和长度为 5 的链表合并后，形成一个长度为 13 的链表
        // 但是，每次合并过程中，子链表都会想要扩充为原来的两倍
        // 直到子链表想要扩充的长度超过了 length
        for (int subLength = 1; subLength < length; subLength *= 2) {

            // 整个归并过程分为三个步骤
            // 1、不停的划分，直到无法划分为止
            // 2、开始两两合并
            // 3、每次合并之后的结果都需要连接起来

            // 每次都把结果连接到 dummyHead，因此先记录一下
            // prev 表示已经排序好的链表的【尾节点】
            ListNode prev = dummyHead;

            // dummyHead 的后面节点才是原链表的节点，需要把它们进行划分
            // curr 表示所有正在准备排序的那些节点的【尾节点】
            ListNode curr = dummyHead.next;

            // 利用 while 循环，寻找出每次划分后子链表的头节点
            while (curr != null) {

                // 每次都是两个子链表开始合并

                // 1、先寻找出【左子链表】，长度为 subLength
                ListNode head1 = curr;

                // 通过 for 循环，找出 subLength 个节点来
                // curr 的索引为 0 ，需要再找 subLength - 1 个节点来
                for (int i = 1; i < subLength && curr.next != null; i++) {

                    curr = curr.next;

                }

                // 2、再寻找出【右子链表】，长度最多为 subLength，甚至有可能长度为 0
                ListNode head2 = curr.next;

                // 此时，需要将【左子链表】与【右子链表】的连接断开
                curr.next = null;

                // curr 来到【右子链表】的头部
                curr = head2;

                // 通过 for 循环，找出【右子链表】的那些节点来
                // 【右子链表】的节点个数可能达不到 subLength，甚至只有 1 个或者 0 个节点
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {

                    curr = curr.next;

                }

                // 获取到【右子链表】之后，需要把它和后续链表断开
                // next 表示接下来需要排序的那些节点的【首节点】
                ListNode next = null;

                // 如果 curr != null，那么说明【右子链表】的节点个数达到了 subLength 个，并且后续还有节点
                if (curr != null) {

                    // 记录一下后面节点
                    next = curr.next;

                    // 再将【右子链表】和后续链表断开
                    curr.next = null;

                }

                // 将【左子链表】与【右子链表】合并
                ListNode merged = mergeTwoLists(head1, head2);

                // 合并之后的结果需要连接到前一个链表
                prev.next = merged;

                // prev 来到链表的尾部，是下一个即将合成链表之后的前一个链表的尾节点
                while (prev.next != null) {

                    prev = prev.next;

                }

                // curr 来到 next，处理后面的节点
                curr = next;
            }

        }

        return dummyHead.next;
    }

    // 合并两个有序链表的代码
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 一开始设置一个虚拟节点，它的值为 -1，它的值可以设置为任何的数，因为我们根本不需要使用它的值
        ListNode dummy = new ListNode(-1);

        // 设置一个指针，指向虚拟节点
        ListNode pre = dummy;

        // 通过一个循环，不断的比较 l1 和 l2 中当前节点值的大小，直到 l1 或者 l2 遍历完毕为止
        while (l1 != null && l2 != null) {
            // 如果 l1 当前节点的值小于等于了 l2 当前节点的值
            if (l1.val <= l2.val) {
                // 让 pre 指向节点的 next 指针指向这个更小值的节点
                // 即指向 l1
                pre.next = l1;
                // 让 l1 向后移动
                l1 = l1.next;
            }else {
                // 让 pre 指向节点的 next 指针指向这个更小值的节点
                // 即指向 l2
                pre.next =l2;
                // 让 l2 向后移动
                l2 = l2.next;
            }
            // 让 pre 向后移动
            pre = pre.next;
        }

        // 跳出循环后，l1 或者 l2 中可能有剩余的节点没有被观察过
        // 直接把剩下的节点加入到 pre 的 next 指针位置

        // 如果 l1 中还有节点
        if (l1 != null) {
            // 把 l1 中剩下的节点全部加入到 pre 的 next 指针位置
            pre.next = l1;
        }

        // 如果 l2 中还有节点
        if (l2 != null) {
            // 把 l2 中剩下的节点全部加入到 pre 的 next 指针位置
            pre.next = l2;
        }

        // 最后返回虚拟节点的 next 指针
        return dummy.next;
    }
}