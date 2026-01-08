//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//此外，你可以假设该网格的四条边均被水包围。

//注意num在什么时候++

class Solution {
    char[][]grid;
    int m;
    int n;
    boolean[][] vis;
    int num;
    int[] dx={-1,+1,0,0};
    int[] dy={0,0,-1,+1};
    public int numIslands(char[][] grid) {
        this.grid=grid;
        this.num=0;
        this.m=grid.length;
        this.n=grid[0].length;
        this.vis=new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    dfs(i, j);
                    num++;
                }
            }
        }
        return num;
    }

    private void dfs(int x, int y) {
        if (x<0||y<0||x>=m||y>=n||vis[x][y]){
            return;
        }
        if (grid[x][y]=='0'){
            return;
        }
        vis[x][y]=true;
        for (int i = 0; i < 4; i++) {
            dfs(x + dx[i], y + dy[i]);
        }
    }
}