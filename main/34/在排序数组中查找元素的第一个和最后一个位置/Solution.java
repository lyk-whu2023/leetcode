//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。
// 请你找出给定目标值在数组中的开始位置和结束位置。
//如果数组中不存在目标值 target，返回 [-1, -1]。
//你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstIdx = findBeginPostion(nums,target);
        int lastIdx = findEndPostion(nums,target);
        return new int[]{firstIdx,lastIdx};
    }

    private int findBeginPostion(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if(mid==0||nums[mid-1] < target){
                    return mid;
                }
                right = mid - 1;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            else  {
                right = mid - 1;
            }
        }
        return -1;
    }

    private int findEndPostion(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if(mid==nums.length-1||nums[mid+1] > target){
                    return mid;
                }
                left = mid + 1;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            else  {
                right = mid - 1;
            }
        }
        return -1;
    }
}