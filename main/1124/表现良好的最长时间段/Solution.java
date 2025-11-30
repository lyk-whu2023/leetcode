//给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
//我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
//所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
//请你返回「表现良好时间段」的最大长度。

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int longestWPI(int[] hours) {
//        int[] cur=new int[hours.length+1];
//        cur[0]=0;
//        int max=0;
//        int sum=0;
//        Stack<Integer>stack=new Stack<>();
//        for (int i = 0; i < hours.length; i++) {
//            if (hours[i]>8){
//                if (sum==0&&i!=0){
//                    cur[i+1]=cur[i-1]+2;
//                }
//                else {
//                    cur[i+1]=cur[i]++;
//                }
//                max=Math.max(cur[i+1], max);
//                sum++;
//                stack.push(1);
//            }
//            else {
//                if (!stack.isEmpty()){
//                    stack.pop();
//                    cur[i+1]=cur[i]++;
//                    max=Math.max(cur[i+1], max);
//                    sum--;
//                }
//                else {
//                    cur[i+1]=0;
//                    sum=Math.max(0,sum-1);
//                }
//            }
//        }
//        return max;
//        int n = hours.length;
//        // 将工作小时数转换为得分：劳累为1，不劳累为-1
//        int[] score = new int[n];
//        for (int i = 0; i < n; i++) {
//            score[i] = hours[i] > 8 ? 1 : -1;
//        }
//
//        // 计算前缀和
//        int[] prefixSum = new int[n + 1];
//        for (int i = 1; i <= n; i++) {
//            prefixSum[i] = prefixSum[i - 1] + score[i - 1];
//        }
//
//        // 使用单调栈存储可能的最左端点
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i <= n; i++) {
//            if (stack.isEmpty() || prefixSum[i] < prefixSum[stack.peek()]) {
//                stack.push(i);
//            }
//        }
//
//        // 从右向左遍历，找到最大长度
//        int maxLen = 0;
//        for (int i = n; i >= 0; i--) {
//            while (!stack.isEmpty() && prefixSum[i] > prefixSum[stack.peek()]) {
//                maxLen = Math.max(maxLen, i - stack.pop());
//            }
//        }
//
//        return maxLen;
        int n = hours.length;
        // 使用哈希表记录每个前缀和第一次出现的位置
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int s = 0; // 前缀和：劳累天数记为+1，不劳累天数记为-1
        int res = 0; // 记录最大长度

        for (int i = 0; i < n; i++) {
            // 计算当前前缀和：劳累天数为+1，不劳累天数为-1
            s += hours[i] > 8 ? 1 : -1;

            // 如果当前前缀和大于0，说明从第0天到当前天的区间是表现良好的
            if (s > 0) {
                // 区间长度为i+1（因为从0开始）
                res = Math.max(res, i + 1);
            } else {
                // 如果当前前缀和<=0，我们需要找s-1
                // 因为如果存在前缀和s-1，那么从s-1的位置到当前位置的区间和就是1（大于0）
                // 即：s - (s-1) = 1 > 0，说明这个区间是表现良好的
                if (map.containsKey(s - 1)) {
                    // 计算区间长度：当前位置 - s-1第一次出现的位置
                    res = Math.max(res, i - map.get(s - 1));
                }
            }

            // 如果当前前缀和是第一次出现，记录它的位置
            // 我们只记录第一次出现的位置，因为这样可以得到更长的区间
            if (!map.containsKey(s)) {
                map.put(s, i);
            }
        }

        return res;

    }
}