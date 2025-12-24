//给定一个 row x col 的二维网格地图 grid ，
//其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
//网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，
//但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
//岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。
//网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。

class Solution {
    private int m, n;
    private int[][] grid;
    private boolean[][] vis;
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};
    public int islandPerimeter(int[][] grid) {
        this.grid=grid;
        this.m= grid.length;
        this.n=grid[0].length;
        this.vis=new boolean[m][n];
        // 找第一块陆地启动 DFS
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return dfs(i, j);   // 只有 1 个岛，直接返回
                }
            }
        }
        return 0; // 无陆地
    }

    private int dfs(int x, int y) {
        if (vis[x][y]){
            return 0;
        }
        vis[x][y]=true;
        int count=0;
        for (int k = 0; k < 4; k++) {
            int nx=x+dx[k];
            int ny=y+dy[k];
            if (nx<0||nx>=m||ny<0||ny>=n||grid[nx][ny]==0){
                count++;
            }
            else {
                count+=dfs(nx,ny);
            }
        }
        return count;
    }
}