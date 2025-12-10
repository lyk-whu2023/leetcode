//已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。
// 例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
//若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
//若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
//注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组
// [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
//给你一个可能存在 重复 元素值的数组 nums ，
// 它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
//你必须尽可能减少整个过程的操作步骤。

class Solution {
    public int findMin(int[] nums) {
        int left=0, right=nums.length-1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid]>nums[right]){
                left=mid+1;
            } else if (nums[mid]<nums[right]) {
                right=mid;
            }
            else {
                int x = left;
                for(int k = left + 1; k < right; k++) {
                    if(nums[k] < nums[x]) x = k;
                }
                return nums[x];
            }
        }
        return nums[left];
    }
}

class Solution1 {
    public int findMin(int[] nums) {
        // 搜索区间的左边界
        int left = 0;
        // 搜索区间的右边界
        int right = nums.length - 1;
        // 在搜索区间 [ left , right ] 中去搜索
        // 在 while 里面就可以获取到结果
        while (left < right) {
            // 先去获取搜索区间的中间位置元素
            int mid = left + (right - left) / 2;
            // 如果 nums[mid] < nums[right]
            // 最小值一定在 mid 左侧区间或者就是 nums[mid]
            if (nums[mid] < nums[right]) {
                // right 移到 mid 的位置。
                right = mid ;
                // 由于 nums 里面的元素存在相同的情况
                // 所以，如果 nums[mid] > nums[right]
                // 最小值一定在 mid 右侧侧区间
            } else if(nums[mid] > nums[right]) {
                // left 移到 mid + 1 的位置。
                left = mid + 1;
                // 如果 nums[mid] = nums[right]
            }else{
                // right 按顺序遍历一样，一个个向左移动
                // 为什么不能让 right = mid 呢？
                // 给一个测试用例 [3,3,1,3]
                // nums[left] = 3  、 nums[right] = 3 、 nums[mid] = 3
                // 如果让  right = mid，跳过了 1
                right--;
            }
        }
        // 返回结果
        return nums[left];
    }
}