//给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的 回文串 的长度。
//在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestPalindrome(String s) {
        int[]  count=new int[58];
        for (char c :
                s.toCharArray()) {
            count[c-'A']++;
        }
        int ans=0;
        boolean hasOdd = false;
        for (int num:
                count){
            if (num%2==0) {
                ans += num;
            }else {
                hasOdd = true;
                ans+=num-1;
            }
        }
        return hasOdd ? ans + 1 : ans;
    }
}