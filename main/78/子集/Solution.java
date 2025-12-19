//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int n= nums.length;
        for (int i = 0; i < 1 << n; i++) {
            List<Integer> tmp=new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i>>j&1)==1){
                    tmp.add(nums[j]);
                }
            }
            ans.add(tmp);
        }
        return ans;
    }
}

class Solution1 {
    private List<Integer> currentSubset = new ArrayList<>();
    private List<List<Integer>> allSubsets = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        generateSubsets(0, nums);
        return allSubsets;
    }

    /**
     * 深度优先搜索生成所有子集
     * @param currentIndex 当前处理的元素索引
     * @param nums 原始数组
     */
    private void generateSubsets(int currentIndex, int[] nums) {
        // 如果已经处理完所有元素，将当前子集加入结果
        if (currentIndex == nums.length) {
            allSubsets.add(new ArrayList<>(currentSubset));
            return;
        }

        // 情况1：包含当前元素
        currentSubset.add(nums[currentIndex]);
        generateSubsets(currentIndex + 1, nums);

        // 回溯：移除当前元素
        currentSubset.remove(currentSubset.size() - 1);

        // 情况2：不包含当前元素
        generateSubsets(currentIndex + 1, nums);
    }
}
