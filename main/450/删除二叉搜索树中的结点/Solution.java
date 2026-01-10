//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。
//返回二叉搜索树（有可能被更新）的根节点的引用。
//一般来说，删除节点可分为两个步骤：
//首先找到需要删除的节点；
//如果找到了，删除它。
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root==null){
            return null;
        }
        if (key<root.val){
            root.left= deleteNode(root.left,key);
        }else if (key>root.val){
            root.right= deleteNode(root.right,key);
        }else {
            if (root.left==null){
                return root.right;
            }
            if (root.right==null){
                return root.left;
            }
            TreeNode nextNode = findMin(root.right);
            root.val = nextNode.val;
            root.right = deleteNode(root.right, nextNode.val);
        }
        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}