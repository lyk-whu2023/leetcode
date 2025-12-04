//给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。
// 返回 需要移除区间的最小数量，使剩余区间互不重叠 。
//注意 只在一点上接触的区间是 不重叠的。例如 [1, 2] 和 [2, 3] 是不重叠的。

import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int count=0;
        int end=intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (end>intervals[i][0]){
                count++;
                end=Math.min(intervals[i][1],end);
            }
            else {
                end=intervals[i][1];
            }
        }
        return count;
    }
}