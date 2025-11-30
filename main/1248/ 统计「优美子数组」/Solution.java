//给你一个整数数组 nums 和一个整数 k。如果某个连续子数组中恰好有 k 个奇数数字，
// 我们就认为这个子数组是「优美子数组」。
//请返回这个数组中 「优美子数组」 的数目。

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n=nums.length;
        int ans=0;
        int count=1;
        int[]odd =new int[n+2];
        odd[0]=-1;
        for (int i = 0; i < n; i++) {
            if (nums[i]%2==1){
                odd[count]=i;
                count++;
            }
        }
        odd[count]=n;
        for (int i = 1; i+k <= count; i++) {
            ans+=(odd[i]-odd[i-1])*(odd[i+k]-odd[i+k-1]);
        }
        return ans;
    }
}

class Solution2 {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] cnt = new int[n + 1];
        int odd = 0, ans = 0;
        cnt[0] = 1;
        for (int i = 0; i < n; ++i) {
            odd += nums[i] & 1;
            ans += odd >= k ? cnt[odd - k] : 0;
            cnt[odd] += 1;
        }
        return ans;
    }
}