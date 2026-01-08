//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' 组成，捕获 所有 被围绕的区域：
//连接：一个单元格与水平或垂直方向上相邻的单元格连接。
//区域：连接所有 'O' 的单元格来形成一个区域。
//围绕：如果您可以用 'X' 单元格 连接这个区域，并且区域中没有任何单元格位于 board 边缘，则该区域被 'X' 单元格围绕。
//通过 原地 将输入矩阵中的所有 'O' 替换为 'X' 来 捕获被围绕的区域。你不需要返回任何值。
class Solution {
    int m;
    int n;
    char[][] board;
    boolean[][] vis;
    int[] dx={-1,+1,0,0};
    int[] dy={0,0,-1,+1};
    public void solve(char[][] board) {
        this.board=board;
        this.m= board.length;
        this.n=board[0].length;
        this.vis=new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(i,0);
            dfs(i,n-1);
        }
        for (int i = 0; i < n-1; i++) {
            dfs(0,i);
            dfs(m-1,i);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j]=='O'&& !vis[i][j]){
                    board[i][j]='X';
                }
            }
        }
    }

    private void dfs(int x, int y) {
        if (x<0||y<0||x>=m||y>=n||vis[x][y]){
            return;
        }
        if (board[x][y]=='X'){
            return;
        }
        vis[x][y]=true;
        for (int i = 0; i < 4; i++) {
            dfs(x+dx[i],y+dy[i]);
        }
    }
}