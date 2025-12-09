import java.util.Arrays;

//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，
// 它们的乘积也表示为字符串形式。
//注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m=num1.length(),n=num2.length();
        int[] ans=new int[m+n];
        for (int i = m-1; i >=0 ; i--) {
            int x=num1.charAt(i)-'0';
            for(int j=n-1; j>=0 ; j--) {
                int y=num2.charAt(j)-'0';
                ans[i+j+1]+=x*y;
            }
        }
        for (int k = m+n-1; k >0 ; k--) {
            ans[k - 1] += ans[k] / 10;
            ans[k] %= 10;
        }
        StringBuffer answer = new StringBuffer();
        int index = ans[0] == 0 ? 1 : 0;
        while (index < m + n) {
            answer.append(ans[index]);
            index++;
        }
        return answer.toString();
    }
}