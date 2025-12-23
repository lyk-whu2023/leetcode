import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给定一个候选人编号的集合 candidates 和一个目标数 target ，
//找出 candidates 中所有可以使数字和为 target 的组合。
//candidates 中的每个数字在每个组合中只能使用 一次 。
//注意：解集不能包含重复的组合。
class Solution {
    List<List<Integer>>res=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer>path=new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,target,path,0);
        return res;
    }
    private void backtrack(int[] nums,int target,List<Integer> path,int start){
        if (target<0){
            return;
        }
        if (target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <nums.length ; i++) {
            // 剪枝操作：同一层相同数值的结点，从第 2 个开始，结果一定发生重复，因此跳过，用 continue
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            backtrack(nums,target-nums[i],path,i+1);
            path.remove(path.size()-1);
        }
    }
}