//给定两个数组 nums1 和 nums2 ，返回 它们的 交集 。
// 输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer>set1=new HashSet<>();
        Set<Integer>set2=new HashSet<>();
        for (int num:
             nums1) {
            set1.add(num);
        }
        for (int num:
                nums2) {
            set2.add(num);
        }
        set1.retainAll(set2);
        int[]result= new int[set1.size()];
        int index = 0;
        for (int num:
             set1) {
            result[index++] = num;
        }
        return result;
    }
}