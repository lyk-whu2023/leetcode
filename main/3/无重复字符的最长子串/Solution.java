//给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans=0;
        Set<Character> set=new HashSet<Character>();
        int n=s.length();
        for (int right = 0,left=0; right <n; right++) {
            while (set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
}