//搜索旋转数组。给定一个排序后的数组，包含n个整数，
// 但这个数组已被旋转过很多次了，次数不详。
// 请编写代码找出数组中的某个元素，假设数组元素原先是按升序排列的。
// 若有多个相同元素，返回索引值最小的一个。

class Solution {
    public int search(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        if(arr[0] == target){
            return 0;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                int result = mid;
                while (result > 0 && arr[result - 1] == target) {
                    result--;
                }
                return result;
            }
            //如果不加判断则会默认左半边有序，对实际数据有影响
            if (arr[left] == arr[mid] && arr[mid] == arr[right]) {
                left++;
                right--;
                continue;
            }
            if(arr[left] <= arr[mid]) {
                if (arr[left] <= target && target <= arr[mid]) {
                    right = mid - 1;
                }
                else
                {
                    left = mid + 1;
                }
            }
            else {
                if(target>=arr[mid]&&target<=arr[right]) {
                    left = mid + 1;
                }
                else
                {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
class Solution1 {
    public boolean search(int[] nums, int target) {
        // left 指向当前区间的最左边位置，所以初始化为 0
        int left = 0;

        // right 指向当前区间的最右边位置，所以初始化为 nums.length - 1
        int right = nums.length - 1;

        // 循环进行二分查找，直到左端点位置超过了右端点
        // 或者在循环过程中找到了 target
        while( left <= right){

            // 计算当前区间的中间位置，向下取整
            int mid = (left + right) / 2;

            // 如果中间位置数字 nums[mid] 等于目标值 target，那么说明找到了
            // 返回当前的下标 mid
            if(nums[mid] == target) return true;

            // 按顺序遍历一样，一个个向右移动
            if(nums[mid] == nums[left]){

                left++;

                continue;
            }

            // 否则的话需要先确定 mid 的左边还是右边为有序区间

            // 如果当前区间最左端的值 nums[left] 小于 nums[mid]
            // 说明从 left 到 mid 这段区间是递增的，为有序区间
            // 即 mid 的左侧为有序区间，右侧为无序区间
            if(nums[left] < nums[mid]){

                // 先去判断 target 是否在左侧有序区间内
                // 如果目标值 target 大于这段有序区间的最小值 nums[left] 同时小于这段有序区间的最大值 nums[mid]
                // 那么说明需要在这段有序区间去寻找 target
                if(target >= nums[left] && target <= nums[mid]){

                    // 所以缩小范围为 left 到 mid - 1
                    // 当前区间的左侧为 left，右侧 right = mid - 1
                    right = mid - 1;

                    // 否则说明需要在 mid 的右侧无序区间搜索
                }else{

                    // 所以缩小范围为 mid + 1 到 right
                    // 当前区间的左侧为 left = mid + 1，右侧 right
                    left = mid + 1;
                }

                // 否则说明当前区间最左端的值 nums[left] 大于 nums[mid]
                // 说明从 left 到 mid 这段区间是无序区间
                // 即 mid 的左侧为无序区间，右侧为有序区间
            }else{

                // 先去判断 target 是否在右侧有序区间内
                // 如果目标值 target 大于这段有序区间的最小值 nums[mid] 同时小于这段有序区间的最大值 nums[right]
                // 那么说明需要在这段有序区间去寻找 target
                if(target >= nums[mid] && target <= nums[right]){

                    // 所以缩小范围为 mid + 1 到 right
                    // 当前区间的左侧为 left = mid + 1，右侧 right
                    left = mid + 1;

                    // 否则说明需要在 mid 的左侧无序区间搜索
                }else{

                    // 所以缩小范围为 left 到 mid - 1
                    // 当前区间的左侧为 left，右侧 right = mid - 1
                    right = mid - 1;

                }
            }
        }

        // 目标值不存在，返回 -1
        return false;

    }
}