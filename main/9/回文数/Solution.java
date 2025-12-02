//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
//回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//例如，121 是回文，而 123 不是。

class Solution {
    public boolean isPalindrome(int x) {
        String s= new String(String.valueOf(x));
        int left=0;
        int right=s.length()-1;
        while (right-left>=1){
            if (s.charAt(left)==s.charAt(right)){
                right--;
                left++;
                continue;
            }
            return false;
        }
        return s.charAt(left)==s.charAt(right);
    }
}