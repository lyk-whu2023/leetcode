//给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。
// 删除子数组的 得分 就是子数组各元素之 和 。
//返回 只删除一个 子数组可获得的 最大得分 。
//如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，那么它就是 a 的一个子数组。

import java.util.HashSet;
import java.util.Set;
//滑动窗口
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int ans=0;
        int tmp=0;
        for (int right=0, left=0;right<n;right++){
            while(set.contains(nums[right])){
                set.remove(nums[left]);
                tmp-=nums[left];
                left++;
            }
            tmp+=nums[right];
            set.add(nums[right]);
            ans=Math.max(ans,tmp);
        }
        return ans;
    }
}