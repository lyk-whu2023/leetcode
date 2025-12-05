//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组
// [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
//0 <= a, b, c, d < n
//a、b、c 和 d 互不相同
//nums[a] + nums[b] + nums[c] + nums[d] == target
//你可以按 任意顺序 返回答案 。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>>result=new ArrayList<>();
        Arrays.sort(nums);
        int n= nums.length;
        for (int i = 0; i < n - 3; i++) {
            if (i>0&&nums[i]==nums[i-1]){
                continue;
            }
            for (int j = i+1; j < n-2; j++) {
                if (j > i + 1 &&nums[j]==nums[j-1]){
                    continue;
                }
                int a=j+1;
                int b=n-1;
                while (a<b){
                    long sum = (long) nums[i] + nums[j] + nums[a] + nums[b];
                    if (sum==target){
                        result.add(Arrays.asList(nums[i], nums[j], nums[a], nums[b]));
                        while (a<b&&nums[b]==nums[b-1]){
                            b--;
                        }
                        while (a<b&&nums[a]==nums[a+1]){
                            a++;
                        }
                        a++;
                        b--;
                    } else if (sum<target) {
                        a++;
                    }else {
                        b--;
                    }
                }
            }
        }
        return result;
    }
}