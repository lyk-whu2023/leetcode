import java.util.Stack;

//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号 子串 的长度。
//左右括号匹配，即每个左括号都有对应的右括号将其闭合的字符串是格式正确的，比如 "(()())"。
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer>stack=new Stack<Integer>();
        int maxLength=0;
        int start=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='('){
                stack.add(i);
            }
            else {
                if (stack.isEmpty()){
                    start=i+1;
                }
                else {
                    stack.pop();
                    if(stack.isEmpty()){
                        maxLength =  Math.max(maxLength,i - start + 1);
                    }else{

                        maxLength =  Math.max(maxLength,i - (stack.peek() + 1) + 1);
                    }
                }
            }
        }
        return maxLength;
    }
}