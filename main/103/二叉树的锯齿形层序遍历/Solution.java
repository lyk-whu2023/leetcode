//给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
//（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
import java.util.*;

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root==null){
            return ret;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        boolean isOrderLeft = true;
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int currentLevelSize = queue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode node=queue.poll();
                level.add(node.val);
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
            ret.add(isOrderLeft?level:level.reversed());
            isOrderLeft=!isOrderLeft;
        }
        return ret;
    }
}