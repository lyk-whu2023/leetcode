//在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，
// 气球直径的开始和结束坐标。由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。
// 开始坐标总是小于结束坐标。
//一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，
// 若有一个气球的直径的开始和结束坐标为 x(start)，x(end)， 且满足 x(start)，≤ x ≤ x(end)，
// 则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。
// 我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
//给你一个数组 points ，其中 points [i] = [start,end] ，返回引爆所有气球所必须射出的最小弓箭数。

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length==0){
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] point1, int[] point2) {
                if (point1[0] > point2[0]) {
                    return 1;
                } else if (point1[0] < point2[0]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int arrows=1;
        int minEnd=points[0][1];
        for (int i = 1; i < points.length; i++) {
            int start=points[i][0];
            int end=points[i][1];
            if (start>minEnd){
                arrows++;
                minEnd=end;
            }else {
                minEnd=Math.min(end,minEnd);
            }
        }
        return arrows;
    }
}