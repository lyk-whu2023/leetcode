//给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
//如果可以，返回 true ；否则返回 false 。
//magazine 中的每个字符只能在 ransomNote 中使用一次。
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length()>magazine.length()){
            return false;
        }
        int[] num=new int[26];
        for (char ch :
                magazine.toCharArray()) {
            num[ch-'a']++;
        }
        for (char ch:
                ransomNote.toCharArray()) {
            num[ch-'a']--;
            if (num[ch-'a']<0){
                return false;
            }
        }
        return true;
    }
}