//给定两个字符串 s 和 t，长度分别是 m 和 n，返回 s 中的 最短窗口 子串，
//使得该子串包含 t 中的每一个字符（包括重复字符）。如果没有这样的子串，返回空字符串 ""。
//测试用例保证答案唯一。

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        int start=0;
        int windowLength = s.length() + 1;
        int left = 0;
        int right = 0;
        int count=t.length();
        for (int i = 0; i < count; i++) {
            map[t.charAt(i)]++;
        }
        while(right < s.length()) {
            char c = s.charAt(right);
            if(map[c]>0) {
                count--;
            }

        }
    }
}