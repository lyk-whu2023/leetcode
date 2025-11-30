//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//求在该柱状图中，能够勾勒出来的矩形的最大面积。

import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int result=0;
        Stack<Integer> stack = new Stack<>();
        int[] newHeights=new int[heights.length+2];
        newHeights[0]=0;
        newHeights[newHeights.length-1]=0;
        for (int i = 1; i < heights.length + 1; i++) {
            newHeights[i] = heights[i - 1];
        }
        for (int i = 0; i < newHeights.length; i++) {
            while (!stack.isEmpty()&&newHeights[i]<newHeights[stack.peek()]){
                int cur=stack.pop();
                int curHeight=newHeights[cur];
                int leftIndex=stack.peek();
                int rightIndex = i;
                int curWidth = rightIndex - leftIndex - 1;
                result = Math.max(result, curWidth * curHeight);
            }
            stack.push(i);
        }
        return  result;
    }
}