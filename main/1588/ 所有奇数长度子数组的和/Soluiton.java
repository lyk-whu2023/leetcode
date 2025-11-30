//给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
//子数组 定义为原数组中的一个连续子序列。
//请你返回 arr 中 所有奇数长度子数组的和 。
//可以翻找官方题解理解，左右必为同奇或者同偶

class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum=0;
        int n=arr.length;
        for (int i = 0; i < n; i++) {
            int leftCount=i;
            int rightCount=n-i-1;
            int leftOdd=(leftCount+1)/2;
            int rightOdd=(rightCount+1)/2;
            int leftEven=(leftCount)/2+1;
            int rightEven=(rightCount)/2+1;
            sum += arr[i] * (leftOdd * rightOdd + leftEven * rightEven);
        }
        return sum;
    }
}