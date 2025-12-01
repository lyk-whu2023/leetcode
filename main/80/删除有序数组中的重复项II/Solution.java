//给你一个有序数组 nums ，请你 原地 删除重复出现的元素，
// 使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
//不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        if (n<2){
            return n;
        }
        int slow = 2; // 慢指针，指向下一个要填充的位置
        for (int fast = 2; fast < nums.length; fast++) {
            // 如果当前元素与慢指针前两个位置的元素不同，说明可以保留
            if (nums[fast] != nums[slow - 2]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}