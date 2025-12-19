import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>>result=new ArrayList<>();
        List<Integer>current=new ArrayList<>();
        boolean[] visited=new boolean[nums.length];
        Arrays.sort(nums);
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
            // 关键剪枝条件：去重核心逻辑
            // 如果当前元素与前一个元素相同，且前一个元素没有被使用，
            // 则跳过当前元素，避免生成重复排列
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
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