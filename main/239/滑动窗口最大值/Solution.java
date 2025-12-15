//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
//你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
//返回 滑动窗口中的最大值 。


import java.util.Deque;
import java.util.LinkedList;

//最欢复杂度为nk,不符合要求
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) return new int[0];
        int[] ans=new int[n-k+1];
        int maxNum=Integer.MIN_VALUE;
        int maxIdx=0;
        for (int i = 0; i < k; i++) {
            if (nums[i] > maxNum) {
                maxNum = nums[i];
                maxIdx = i;
            }
        }
        ans[0] = maxNum;
        for (int right = k; right < n; right++) {
            if(maxIdx<=right - k){
                maxNum=Integer.MIN_VALUE;
                   for(int j=right-k+1;j<=right;j++){
                       if (nums[j] > maxNum) {
                           maxNum = nums[j];
                           maxIdx = j;
                       }
                   }
            }
            if(maxNum<=nums[right]){
                maxNum = nums[right];
                maxIdx = right;
            }
            ans[right-k+1] = maxNum;
        }
        return ans;
    }
}

class Solution1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // 双端队列，存的是【下标】
        Deque<Integer> deque = new LinkedList<Integer>();

        /* ----------- 处理第一个窗口 [0, k-1] ----------- */
        for (int i = 0; i < k; i++) {
            // 从队尾往前扫，把小于等于当前元素的全部踢掉
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();   // 维护单调递减性质
            }
            deque.offerLast(i);     // 当前下标入队
        }

        /* ----------- 准备答案数组 ----------- */
        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];  // 队头就是第一个窗口的最大值

        /* ----------- 滑动窗口，右边界从 k 到 n-1 ----------- */
        for (int i = k; i < n; ++i) {
            // 1. 同样先维护单调性质：踢掉队尾“无用”元素
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);     // 新元素下标入队

            // 2. 检查队头是否已滑出窗口左边界（i-k+1 是新的左边界）
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();  // 滑出则弹出
            }

            // 3. 此时队头就是当前窗口最大值
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }
}
