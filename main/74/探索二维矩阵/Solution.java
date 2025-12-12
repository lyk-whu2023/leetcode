//给你一个满足下述两条属性的 m x n 整数矩阵：
//每行中的整数从左到右按非严格递增顺序排列。
//每行的第一个整数大于前一行的最后一个整数。
//给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex = binarySearchFirstColumn(matrix, target);
        if (rowIndex < 0) {
            return false;
        }
        return binarySearchRow(matrix[rowIndex], target);
    }

    private boolean binarySearchRow(int[] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid]==target) {
                return true;
            }
            else if (matrix[mid]<target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return false;
    }

    private int binarySearchFirstColumn(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid][0]<=target){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return right;//right指向最后一个小于等于target值的位置，left指向第一个大于等于target值的位置
        //在这里，right指向最后一个满足 matrix[i][0] <= target的位置，left指向第一个满足 matrix[i][0] > target的位置
    }
}