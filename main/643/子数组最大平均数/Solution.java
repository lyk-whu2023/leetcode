//给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
//请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
//任何误差小于 10-5 的答案都将被视为正确答案。

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        double maxAverage = Integer.MIN_VALUE;
        int left=0;
        int right=0;
        while (right < nums.length){
            sum+=nums[right];
            if(right - left + 1== k){
                maxAverage = Math.max(maxAverage, sum/k);
            }
            if(right - left + 1>= k){
                sum-=nums[left];
                left++;
            }
            right++;
        }
        return maxAverage;
    }
}