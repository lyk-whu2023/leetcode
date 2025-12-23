//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
//你可以按 任何顺序 返回答案。

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> path = new ArrayList<>();
        backtrack(n,k,path,1);
        return res;
    }
    private void backtrack(int n,int k,List<Integer> path,int start){
        if (k==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n; i++) {
            path.add(i);
            backtrack(n, k - 1 , path , i+1 );
            path.remove(path.size()-1);
        }
    }
}