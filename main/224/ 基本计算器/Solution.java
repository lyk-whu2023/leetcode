import java.util.Stack;

//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
//注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval()
class Solution {
    public int calculate(String s) {
        Stack<Integer>stack = new Stack<Integer>();
        int sign=1;
        int result=0;
        int length=s.length();
        for (int i = 0; i < length; i++) {
            char ch=s.charAt(i);
            if (Character.isDigit(ch)){
                int value=ch-'0';
                while (i+1<length && Character.isDigit(s.charAt(i+1))){
                    i++;
                    value=value*10+s.charAt(i)-'0';
                }
                result+=sign*value;
            } else if (ch=='+') {
                sign=1;
            } else if (ch == '-') {
                sign=-1;
            } else if (ch=='(') {
                stack.push(result);
                result=0;
                stack.push(sign);
                sign = 1;
            } else if (ch==')') {
                int formerSign = stack.pop();
                int formerRes = stack.pop();
                result = formerRes +  formerSign * result ;
            }
        }
        return result;
    }
}