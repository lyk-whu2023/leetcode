//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
//请你找出并返回这两个正序数组的 中位数 。
//算法的时间复杂度应该为 O(log (m+n)) 。

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        if (n>m){
            return findMedianSortedArrays(nums2,nums1);
        }
        int left=0;
        int right=n;
        while (left<=right){
            // 在 nums1 中切一刀，将 nums1 分为 [0, cut1-1] 和 [cut1, n-1] 两部分
            int cut1=left+(right-left)/2;
            // 在 nums2 中切一刀，使得左边的总元素数量是 (m+n+1)/2
            // 这样左边部分的总数刚好等于或比右边多1（当总数为奇数时）
            int cut2=(m+n+1)/2-cut1;
            int leftMax1=(cut1==0)?Integer.MIN_VALUE:nums1[cut1-1];
            int leftMax2=(cut2==0)?Integer.MIN_VALUE:nums2[cut2-1];
            int rightMin1=(cut1==n)?Integer.MAX_VALUE:nums1[cut1];
            int rightMin2=(cut2==m)?Integer.MAX_VALUE:nums2[cut2];
            if (leftMax1 <= rightMin2 && leftMax2 <= rightMin1){
                if ((m + n) % 2 == 0){
                    return (Math.max(leftMax1, leftMax2) + Math.min(rightMin1, rightMin2)) / 2.0;
                }
                else {
                    return Math.max(leftMax1, leftMax2);
                }
            }
            else if (leftMax1>rightMin2){
                right=cut1-1;
            }
            else {
                left=cut1+1;
            }
        }
        return 0.0;
    }
}

class Solution1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        // 确保 nums1 是较短的数组，这样可以减少二分查找的次数
        if (n > m) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int left = 0;
        int right = n;  // 在较短的数组 nums1 上进行二分查找

        while (left <= right) {
            // 在 nums1 中切一刀，将 nums1 分为 [0, cut1-1] 和 [cut1, n-1] 两部分
            int cut1 = left + (right - left) / 2;

            // 在 nums2 中切一刀，使得左边的总元素数量是 (m+n+1)/2
            // 这样左边部分的总数刚好等于或比右边多1（当总数为奇数时）
            int cut2 = (m + n + 1) / 2 - cut1;

            // 获取切分点周围的四个关键值

            // nums1 左边部分的最大值，如果切在最左边（cut1=0），则左边没有元素，设为最小值
            int leftMax1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];

            // nums2 左边部分的最大值，如果切在最左边（cut2=0），则左边没有元素，设为最小值
            int leftMax2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];

            // nums1 右边部分的最小值，如果切在最右边（cut1=n），则右边没有元素，设为最大值
            int rightMin1 = (cut1 == n) ? Integer.MAX_VALUE : nums1[cut1];

            // nums2 右边部分的最小值，如果切在最右边（cut2=m），则右边没有元素，设为最大值
            int rightMin2 = (cut2 == m) ? Integer.MAX_VALUE : nums2[cut2];

            // 检查当前切分是否满足中位数的条件
            // 条件1：nums1 左边最大值 <= nums2 右边最小值
            // 条件2：nums2 左边最大值 <= nums1 右边最小值
            // 这两个条件保证了所有左边元素 <= 所有右边元素
            if (leftMax1 <= rightMin2 && leftMax2 <= rightMin1) {
                // 找到正确的切分点

                if ((m + n) % 2 == 0) {
                    // 总数为偶数，中位数是左边最大值和右边最小值的平均数
                    return (Math.max(leftMax1, leftMax2) + Math.min(rightMin1, rightMin2)) / 2.0;
                } else {
                    // 总数为奇数，中位数是左边最大值
                    return Math.max(leftMax1, leftMax2);
                }
            } else if (leftMax1 > rightMin2) {
                // nums1 的左边部分太大了，需要减少 cut1
                // 相当于在 nums1 中向左移动切分点
                right = cut1 - 1;
            } else {
                // nums1 的左边部分太小了，需要增加 cut1
                // 相当于在 nums1 中向右移动切分点
                left = cut1 + 1;
            }
        }

        return 0.0;  // 根据题目条件，这里实际上不会执行到
    }
}