//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
//请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]>answer=new ArrayList<>();
        int left=intervals[0][0];
        int right=intervals[0][1];
        for (int i = 1; i < intervals.length; i++){
            int[] cur=intervals[i];
            if (cur[0]>right){
                answer.add(new int[]{left, right});
                left = cur[0];
                right = cur[1];
            }
            right=Math.max(right,cur[1]);
        }
        answer.add(new int[]{left, right});
        return answer.toArray(new int[answer.size()][]);
    }
}