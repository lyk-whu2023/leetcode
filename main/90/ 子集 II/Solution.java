//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的 子集（幂集）。
//解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private List<Integer> currentSubset = new ArrayList<>();
    private List<List<Integer>> allSubsets = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        generateSubsets(0,nums);
        return allSubsets;
    }
    private void generateSubsets(int currentIndex, int[] nums){
        if (currentIndex==nums.length){
            allSubsets.add(new ArrayList<>(currentSubset));
            return;
        }
        //包含当前元素
        currentSubset.add(nums[currentIndex]);
        generateSubsets(currentIndex+1,nums);
        //回溯
        currentSubset.remove(currentSubset.size()-1);
        //不包含当前元素，并且跳过所有重复元素
        int nextIndex = currentIndex + 1;
        while (nextIndex < nums.length && nums[nextIndex] == nums[currentIndex]) {
            nextIndex++;
        }
        generateSubsets(nextIndex, nums);
    }
}