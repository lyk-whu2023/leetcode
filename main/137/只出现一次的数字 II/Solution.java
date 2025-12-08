//给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。
//请你找出并返回那个只出现了一次的元素。
//你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。

class Solution {
    public int singleNumber(int[] nums) {
        int ans=0;
        for (int i = 0; i < 32; i++) {
            int total=0;
            for (int num:nums){
                total+=((num>>i)&1);
            }
            if (total%3!=0){
                ans |= (1<<i);
            }
        }
        return ans;
    }
}
class Solution1 {
    public int singleNumber(int[] nums) {
        int ones=0;
        int twos=0;
        for (int num:nums){
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        return ones;
    }
}