//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
//每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<String>> ans=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int[] queens=new int[n];
        boolean[] col= new boolean[n];
        boolean[] diag1= new boolean[n * 2 - 1];
        boolean[] diag2= new boolean[n * 2 - 1];
        dfs(0,queens,col,diag1,diag2);
        return ans;
    }
    private void dfs(int x, int[] queens, boolean[] col, boolean[] diag1, boolean[] diag2){
        int n = queens.length;
        if (x==n){
            List<String> board=new ArrayList<>(n);
            for (int c:queens){
                char[] row=new char[n];
                Arrays.fill(row,'.');
                row[c]='Q';
                board.add(new String(row));
            }
            ans.add(board);
            return;
        }
        for (int y = 0; y < n; y++) {
            if (!col[y] && !diag1[x + y] && !diag2[x - y + n - 1]){
                queens[x]=y;
                col[y]=true;
                diag1[x+y]=true;
                diag2[x-y+n-1]=true;
                dfs(x+1,queens,col,diag1,diag2);
                col[y]=false;
                diag1[x+y]=false;
                diag2[x-y+n-1]=false;
            }
        }
    }
}