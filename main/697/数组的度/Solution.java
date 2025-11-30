//给定一个非空且只包含非负数的整数数组 nums，数组的 度 的定义是指数组里任一元素出现频数的最大值。
//你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。


//注意Map的foreach写法
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer,int[]>map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                map.get(nums[i])[0]++;
                map.get(nums[i])[2]=i;
            }
            else {
                map.put(nums[i],new int[]{1,i,i});
            }
        }
        final int[] maxNum = {0};
        final int[] minLen = {0};
        map.forEach((key,value)->{
            if (maxNum[0] <value[0]){
                maxNum[0] =value[0];;
                minLen[0] =value[2]-value[1]+1;
            } else if (maxNum[0] == value[0]) {
                minLen[0] =Math.min(value[2]-value[1]+1, minLen[0]);
            }
        });
        return minLen[0];
    }
}