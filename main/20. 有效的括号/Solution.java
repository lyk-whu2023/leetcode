//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//有效字符串需满足：
//左括号必须用相同类型的右括号闭合。
//左括号必须以正确的顺序闭合。
//每个右括号都有一个对应的相同类型的左括号。

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;
        Stack<Character> stack=new Stack<Character>();
        char[] charArray =s.toCharArray();
        for (int i = 0; i <charArray.length;i++) {
            char c=charArray[i];
            if (c=='('){
                stack.push(c);
            }
            else if (c=='['){
                stack.push(c);
            }
            else if (c=='{'){
                stack.push(c);
            }
            else {
                if (stack.isEmpty()){
                    return false;
                }
                else {
                    char top=stack.peek();
                    if( top == '(' && c == ')' || top == '[' && c == ']' || top == '{' && c == '}' ){
                        stack.pop();
                    }else{
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}