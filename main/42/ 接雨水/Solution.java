//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int max=0;
        int ans=0;
        int sum=0;
        for (int i = 0; i < n; i++) {
            int tmp=height[i];
            if (tmp>max){
                max=tmp;
            }
            ans+=max-tmp;
            sum+=tmp;
        }
        max=0;
        for (int i = n-1; i >= 0; i--) {
            int tmp=height[i];
            if (tmp>max){
                max=tmp;
            }
            ans+=max-tmp;
        }
        ans=ans+sum-max*n;
        return ans;
    }
}

class Solution1 {
    public int trap(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }
}
