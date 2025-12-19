//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。

import java.util.ArrayList;
import java.util.List;
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>result=new ArrayList<>();
        List<Integer>current=new ArrayList<>();
        boolean[] visited=new boolean[nums.length];
        backtrack(nums, visited, current, result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] visited, List<Integer> current, List<List<Integer>> result) {
        if (current.size()==nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i]=true;
            current.add(nums[i]);
            backtrack(nums, visited, current, result);
            current.remove(current.size()-1);
            visited[i]=false;
        }
    }
}