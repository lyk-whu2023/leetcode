//给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
//一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。
//返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。

//等效于从四个边能到达

class Solution {
    private int m, n;
    private int[][] grid;
    private boolean[][] vis;

    public int numEnclaves(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.vis = new boolean[m][n];

        // 1. 从四条边上的陆地开始 DFS/BFS
        for (int i = 0; i < m; i++) {
            dfs(i, 0);
            dfs(i, n - 1);
        }
        for (int j = 1; j < n - 1; j++) {
            dfs(0, j);
            dfs(m - 1, j);
        }

        // 2. 统计未访问过的陆地
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    // 四个方向
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};

    private void dfs(int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n) return;
        if (grid[x][y] == 0 || vis[x][y]) return;
        vis[x][y] = true;
        for (int k = 0; k < 4; k++) {
            dfs(x + dx[k], y + dy[k]);
        }
    }
}