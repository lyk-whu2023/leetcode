import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>ans=new ArrayList<>();
        Queue<TreeNode>queue=new LinkedList<>();
        if (root==null){
            return ans ;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            int num=queue.size();
            for (int i = 0; i < num; i++) {
                TreeNode node=queue.poll();
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
                if (i==num-1){
                    ans.add(node.val);
                }
            }
        }
        return ans;
    }
}