//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。


import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    /* ===== 前序遍历（题目已给出） ===== */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                res.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == null) {          // 第一次来到 cur
                    pre.right = cur;              // 建线索
                    res.add(cur.val);             // 前序：第一次访问就输出
                    cur = cur.left;
                } else {                          // 第二次回到 cur
                    pre.right = null;             // 拆线索
                    cur = cur.right;
                }
            }
        }
        return res;
    }

    /* ===== 中序遍历 ===== */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                res.add(cur.val);                 // 中序：左子空时输出
                cur = cur.right;
            } else {
                TreeNode pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == null) {          // 第一次来到 cur
                    pre.right = cur;              // 建线索
                    cur = cur.left;
                } else {                          // 第二次回到 cur
                    pre.right = null;             // 拆线索
                    res.add(cur.val);             // 中序：第二次访问才输出
                    cur = cur.right;
                }
            }
        }
        return res;
    }

    /* ===== 后序遍历 =====
     * Morris 后序需要额外处理“第二次访问”时，逆序输出左子树的右边界。
     * 这里用反转链表的方式实现 O(1) 空间的逆序输出。
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        TreeNode dump = new TreeNode(0);   // 辅助头节点
        dump.left = root;
        TreeNode cur = dump;

        while (cur != null) {
            if (cur.left == null) {
                cur = cur.right;
            } else {
                TreeNode pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == null) {      // 第一次来到 cur
                    pre.right = cur;
                    cur = cur.left;
                } else {                      // 第二次回到 cur
                    pre.right = null;
                    // 逆序输出 cur.left 到 pre 的右边界
                    reverseAdd(cur.left, res);
                    cur = cur.right;
                }
            }
        }
        return res;
    }

    /* 反转以 head 为起点的右指针链，同时收集节点值，最后再反转回来 */
    private void reverseAdd(TreeNode head, List<Integer> res) {
        TreeNode tail = reverse(head);
        TreeNode node = tail;
        while (node != null) {
            res.add(node.val);
            node = node.right;
        }
        reverse(tail);   // 恢复原树结构
    }

    /* 反转单链表（右指针当作 next） */
    private TreeNode reverse(TreeNode head) {
        TreeNode prev = null, cur = head;
        while (cur != null) {
            TreeNode next = cur.right;
            cur.right = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}