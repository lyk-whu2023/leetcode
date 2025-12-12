//给定一个长度为 n 的整数 山脉 数组 arr ，其中的值递增到一个 峰值元素 然后递减。
//返回峰值元素的下标。
//你必须设计并实现时间复杂度为 O(log(n)) 的解决方案。

//注意二分的关键在于找到所求部分，在此处就是往高处走
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 2;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] > arr[mid+1]) {
                right = mid ;
            }
            if (arr[mid] < arr[mid+1]) {
                left = mid + 1;
            }
        }
        return left;
    }
}