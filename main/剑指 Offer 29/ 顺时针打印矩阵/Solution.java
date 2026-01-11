//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length==0){
            return new int[0];
        }
        int[] ans=new int[matrix.length*matrix[0].length];
        int left=0;
        int right=matrix[0].length-1;
        int top=0;
        int bottom=matrix.length-1;
        int index=0;
        while (true){
            for (int i = left; i <= right; i++) {
                ans[index]=matrix[top][i];
                index++;
            }
            top++;
            if ( top > bottom ) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                ans[index]=matrix[i][right];
                index++;
            }
            right--;
            if (left>right){
                break;
            }
            for (int i = right; i >=left ; i--) {
                ans[index]=matrix[bottom][i];
                index++;
            }
            bottom--;
            if (bottom<top){
                break;
            }
            for (int i = bottom; i >=top ; i--) {
                ans[index]=matrix[i][left];
                index++;
            }
            left++;
            if ( left > right ) {
                break;
            }
        }
//        while (index < m * n) {
//            // 1. 从左到右收最上面一行
//            for (int i = left; i <= right && index < m * n; i++) {
//                ans[index++] = matrix[top][i];
//            }
//            top++;
//            // 2. 从上到下收最右面一列
//            for (int i = top; i <= bottom && index < m * n; i++) {
//                ans[index++] = matrix[i][right];
//            }
//            right--;
//            // 3. 从右到左收最下面一行
//            for (int i = right; i >= left && index < m * n; i--) {
//                ans[index++] = matrix[bottom][i];
//            }
//            bottom--;
//            // 4. 从下到上收最左面一列
//            for (int i = bottom; i >= top && index < m * n; i--) {
//                ans[index++] = matrix[i][left];
//            }
//            left++;
//        }
        return ans;
    }
}