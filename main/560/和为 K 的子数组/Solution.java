//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
//子数组是数组中元素的连续非空序列。

//注意避免出现数组两端的i和j反向

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        int count=0;
        int sum=0;
        Map<Integer,Integer>map=new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < n; i++) {
            sum+=nums[i];
            if (map.containsKey(k-nums[i])){
                count+=map.get(k-nums[i]);
            }
            map.put(sum, map.getOrDefault(sum+1,1));
        }
        return  count;
    }
}