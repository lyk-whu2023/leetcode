//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
//注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。

import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        int n= nums.length;
        String[] strNums=new String[n];
        for (int i = 0; i < n; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strNums,(a,b)->(b + a).compareTo(a + b));
        if ("0".equals(strNums[0])) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        for (String str : strNums) {
            result.append(str);
        }
        return result.toString();
    }
}