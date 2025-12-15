//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的 排列。
// 如果是，返回 true ；否则，返回 false 。
//换句话说，s1 的排列之一是 s2 的 子串 。

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] needs=new int[26];
        for(char c : s1.toCharArray()){
            needs[c - 'a']++;
        }
        int left=0;
        int right=0;
        int require=0;
        for(int a : needs){
            if (a > 0){
                require++;
            }
        }
        while (right < s2.length()){
            int rightChar = s2.charAt(right)-'a';
            needs[rightChar]--;
            if (needs[rightChar] == 0){
                require--;
            }
            if (require == 0&&right - left + 1==s1.length()){
                return  true;
            }
            if (right - left + 1==s1.length()){
                int leftIdx = s2.charAt(left) - 'a';
                if (needs[leftIdx] ==0)
                {
                    require++;
                };
                needs[leftIdx]++;
                left++;
            }
            right++;
        }
        return false;
    }
}