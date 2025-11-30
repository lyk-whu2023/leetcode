import java.util.Stack;

//给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
//请你计算该表达式。返回一个表示表达式值的整数。
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> result = new Stack<>();
        int rightNum;
        int leftNum;
        int ans;
        for (String token :
                tokens) {
            if ("+".equals(token)){
                rightNum=result.pop();
                leftNum=result.pop();
                ans=leftNum+rightNum;
            }
            else if ("-".equals(token)){
                rightNum=result.pop();
                leftNum=result.pop();
                ans=leftNum-rightNum;
            }
            else if ("*".equals(token)){
                rightNum=result.pop();
                leftNum=result.pop();
                ans=leftNum*rightNum;
            }
            else if ("/".equals(token)){
                rightNum=result.pop();
                leftNum=result.pop();
                ans=leftNum/rightNum;
            }
            else{
                ans=Integer.parseInt(token);
            }
            result.push(ans);
        }
        return result.peek();
    }
}