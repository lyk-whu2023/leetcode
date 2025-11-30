//请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
//数字 1-9 在每一行只能出现一次。
//数字 1-9 在每一列只能出现一次。
//数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
//注意：
//一个有效的数独（部分已被填充）不一定是可解的。
//只需要根据以上规则，验证已经填入的数字是否有效即可。
//空白格用 '.' 表示。

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] subboxes = new int[3][3][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                rows[i][board[i][j]-'0'-1]++;
                columns[j][board[i][j]-'0'-1]++;
                subboxes[i/3][j/3][board[i][j]-'0'-1]++;
                if (rows[i][board[i][j]-'0'-1]>1||
                columns[j][board[i][j]-'0'-1]>1||
                subboxes[i/3][j/3][board[i][j]-'0'-1]>1){
                    return false;
                }
            }
        }
        return true;
    }
}