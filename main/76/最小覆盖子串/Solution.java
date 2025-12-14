//给定两个字符串 s 和 t，长度分别是 m 和 n，返回 s 中的 最短窗口 子串，
//使得该子串包含 t 中的每一个字符（包括重复字符）。如果没有这样的子串，返回空字符串 ""。
//测试用例保证答案唯一。

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String source, String target) {
        if (source==null||target==null||target.isEmpty()) {
            return "";
        }
        Map<Character, Integer> targetFreq = new HashMap<>();
        for (char c : target.toCharArray()) {
            targetFreq.merge(c, 1, Integer::sum);
            //等价于targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> windowFreq = new HashMap<>();
        int left=0;
        int matchedChars=0;
        int minLen=Integer.MAX_VALUE;
        int bestLeft=-1;

        for (int right = 0; right < source.length(); right++) {
            char rightChar = source.charAt(right);
            if(!targetFreq.containsKey(rightChar)){
                continue;
            }
            windowFreq.merge(rightChar, 1, Integer::sum);
            if (windowFreq.get(rightChar).equals(targetFreq.get(rightChar))) {
                matchedChars++;
            }
            while (matchedChars == targetFreq.size()){
                int curLen = right-left+1;
                if (curLen < minLen) {
                    minLen = curLen;
                    bestLeft = left;
                }
                char leftChar = source.charAt(left);
                left++;
                if(!targetFreq.containsKey(leftChar)){
                    continue;
                }
                if (windowFreq.get(leftChar).equals(targetFreq.get(leftChar))) {
                    matchedChars--;
                }
                windowFreq.merge(leftChar, -1, Integer::sum);
            }
        }
        return bestLeft == -1 ? "" : source.substring(bestLeft, bestLeft + minLen);
    }
}

class Solution {
    public String minWindow(String s, String t) {
        int[] count=new int[128];
        int usedChar=0;
        for (char c : t.toCharArray()) {
            if (count[c] == 0) {
                usedChar++;
            }
            count[c]++;
        }
        char[] sources = s.toCharArray();
        int n=sources.length;
        int ansLeft = -1;
        int ansRight = n;
        int left=0;
        int right=0;
        while (right < n){
            char rightChar = sources[right];
            count[rightChar]--;
            if (count[rightChar] == 0) {
                usedChar--;
            }
            while (usedChar == 0){
                if (right - left < ansRight - ansLeft) {
                    ansLeft = left;
                    ansRight = right;
                }
                char leftChar = sources[left];
                if (count[leftChar] == 0) {
                    usedChar++;
                }
                count[leftChar]++;
                left++;
            }
            right++;
        }
        return ansLeft < 0 ? "" :s.substring(ansLeft, ansRight + 1);
    }
}

