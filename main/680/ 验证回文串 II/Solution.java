//给你一个字符串 s，最多 可以从中删除一个字符。
//请你判断 s 是否能成为回文字符串：如果能，返回 true ；否则，返回 false 。

class Solution {
    public boolean validPalindrome(String s) {
//        int left=0;
//        int right=s.length()-1;
//        while (right-left>=1){
//            if (s.charAt(left)==s.charAt(right)){
//                right--;
//                left++;
//                continue;
//            }
//            return false;
//        }
//        return s.charAt(left)==s.charAt(right);
        int left=0;
        int right=s.length()-1;
        while(left<right){
            char ch1=s.charAt(left);
            char ch2=s.charAt(right);
            if (ch1==ch2){
                left++;
                right--;
            }
            else {
                return validPalindrome(s, left, right - 1) || validPalindrome(s, left + 1,right);
            }
        }
        return true;
    }
    public boolean validPalindrome(String s, int left, int right) {
        for (int i = left, j = right; i < j; ++i, --j) {
            char c1 = s.charAt(i), c2 = s.charAt(j);
            if (c1 != c2) {
                return false;
            }
        }
        return true;
    }
}