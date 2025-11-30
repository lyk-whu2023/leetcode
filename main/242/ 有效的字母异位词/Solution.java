//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的 字母异位词。

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }
        int[]num=new int[26];
        int length=s.length();
        for (int i = 0; i < length; i++) {
            num[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < length; i++) {
            num[t.charAt(i)-'a']--;
            if (num[t.charAt(i)-'a']<0  ){
                return false;
            }
        }
        return true;
    }
}