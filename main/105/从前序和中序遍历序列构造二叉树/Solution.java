//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历，
//inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。

import java.util.Stack;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0){
            return null;
        }
        Stack<TreeNode>stack=new Stack<>();
        TreeNode root=new TreeNode(preorder[0]);
        stack.push(root);
        int inorderIndex=0;
        for (int preIndex = 1; preIndex < preorder.length; preIndex++) {
            TreeNode node = new TreeNode(preorder[preIndex]);
            TreeNode top = stack.peek();
            if (top.val != inorder[inorderIndex]) {
                // 当前节点是栈顶节点的左子节点
                top.left = node;
            }else {
                // 栈顶节点在中序遍历中已到，弹出
                //while (!stack.isEmpty() )
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    top = stack.pop();
                    inorderIndex++;
                }
                // 弹出的最后一个节点的右子节点是当前节点
                top.right = node;
            }
            stack.push(node);
        }
        return root;
    }
}