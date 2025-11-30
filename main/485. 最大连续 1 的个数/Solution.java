// 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        int now=0;
        for (int num : nums) {
            if (num == 1) {
                now++;
                max= Math.max(max, now);
            } else {
                now = 0;
            }
        }
        return max;
    }
}