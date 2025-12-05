//给你一个长度为 n 的整数数组 nums 和 一个目标值 target。
// 请你从 nums 中选出三个整数，使它们的和与 target 最接近。
// 返回这三个数的和。  假定每组输入只存在恰好一个解。

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans=nums[1]+nums[2]+nums[0];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j=i+1;
            int k=nums.length-1;
            while (j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(Math.abs(target - sum) < Math.abs(target - ans)){
                    ans = sum;
                }
                if (sum<target){
                    j++;
                }else if (sum>target){
                    k--;
                }else {
                    return ans;
                }
            }
        }
        return ans;
    }
}