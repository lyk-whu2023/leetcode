//给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。

class Solution {
    public String addBinary(String a, String b) {
        int carry=0;
        StringBuffer answer = new StringBuffer();
        for (int i = a.length()-1,j = b.length()-1; i>=0||j>=0 ; i--,j--) {
            int num1=i>=0?a.charAt(i)-'0':0;
            int num2=j>=0?b.charAt(j)-'0':0;
            int sum=num1+num2+carry;
            carry=sum/2;
            answer.append(sum%2);
        }
        if (carry==1) {
            answer.append(carry);
        }
        return answer.reverse().toString();
    }
}