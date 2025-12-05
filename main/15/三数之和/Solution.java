//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
// 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。
// 请你返回所有和为 0 且不重复的三元组。
//注意：答案中不可以包含重复的三元组。

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[k] == nums[k - 1]) k--;   // 向左跳过重复 k
                    while (j < k && nums[j] == nums[j + 1]) j++;   // 向右跳过重复 j
                    k--;
                    j++;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }
}

class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Map<Integer,Integer>map=new HashMap<>();
        List<List<Integer>>result=new ArrayList<>();
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }
            else {
                map.replace(nums[i],i );
            }
        }
        for (int i = 0; i < nums.length-2; i++) {
            if (i>0&&nums[i] == nums[i - 1]){
                continue;
            }
            for (int j = i+1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                sum=nums[i]+nums[j];
                if (map.containsKey(-sum)){
                    int k=map.get(-sum);
                    if (k > j){
                        result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    }
                }
            }
        }
        return result;
    }
}