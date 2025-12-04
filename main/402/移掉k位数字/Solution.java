//给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，
// 使得剩下的数字最小。请你以字符串形式返回这个最小的数字。

import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character>stack =new Stack<>();
        StringBuilder result=new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            char digit = num.charAt(i);
            while (!stack.isEmpty()&&stack.peek()>digit&&k>0){
                stack.pop();
                k--;
            }
            if (digit==0&&stack.isEmpty()){
                continue;
            }
            stack.push( digit);
        }
        if (stack.isEmpty()) return "0";
        while (!stack.isEmpty()&&k>'0'){
            stack.pop();
            k--;
        }
        while (!stack.isEmpty()){
            result.append(stack.pop());
        }
        result.reverse();
        return result.toString();
    }
}