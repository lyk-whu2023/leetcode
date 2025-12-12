//编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
//每行的元素从左到右升序排列。
//每列的元素从上到下升序排列。

//注意自能从右上角或者左下角开始
//从左上角开始，不知道该往左还是往下
//这种分维度有序的，要注意一边增大，一遍减小，便于确定方向
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = 0;
        int col = matrix[0].length - 1;  // 从右上角开始

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;  // 当前值太大，向左移动
            } else {
                row++;  // 当前值太小，向下移动
            }
        }
        return false;
    }
}