//给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
//完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
//并且最下面一层的节点都集中在该层最左边的若干位置。
//若最底层为第 h 层（从第 0 层开始），则该层包含 1~ 2h 个节点。
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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root, true);  // 左子树高度
        int rightHeight = getHeight(root, false); // 右子树高度

        if (leftHeight == rightHeight) {
            // 左右子树高度相等，说明该树是满二叉树
            return (1 << leftHeight) - 1;  // 2^h - 1
        } else {
            // 左右子树高度不等，递归计算
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    // 获取以node为根的子树的高度
    // isLeft: true表示计算左子树高度，false表示计算右子树高度
    private int getHeight(TreeNode node, boolean isLeft) {
        int height = 0;
        while (node != null) {
            height++;
            node = isLeft ? node.left : node.right;
        }
        return height;
    }
}

//二分法

class Solution2 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 计算树的高度（根节点深度为0）
        int h = 0;
        TreeNode cur = root;
        while (cur.left != null) {
            h++;
            cur = cur.left;
        }
        // 如果树的高度为0，只有根节点
        if (h == 0) {
            return 1;
        }
        // 二分查找最后一层中最后一个节点的位置
        int left = 0, right = (1 << h) - 1;  // 最后一层最多有2^h个节点
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (exists(mid, h, root)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 总节点数 = 前h层满二叉树节点数(2^h - 1) + 最后一层节点数(right + 1)
        return (1 << h) - 1 + (right + 1);
    }

    // 检查在高度为h的树中，最后一层索引为idx的节点是否存在
    private boolean exists(int idx, int h, TreeNode root) {
        TreeNode node = root;
        int bit = 1 << (h - 1);  // 用于提取idx的最高位
        for (int i = 0; i < h; i++) {
            if ((idx & bit) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            if (node == null) {
                return false;
            }
            bit >>= 1;
        }
        return true;
    }
}