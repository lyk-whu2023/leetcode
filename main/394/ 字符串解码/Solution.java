import java.util.Deque;
import java.util.LinkedList;

//给定一个经过编码的字符串，返回它解码后的字符串。
//编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。
//注意 k 保证为正整数。
//你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
//此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
//测试用例保证输出的长度不会超过 105。
class Solution {
    public String decodeString(String s) {
        Deque<Integer>numStack=new LinkedList<>();
        Deque<StringBuilder>strStack=new LinkedList<>();
        int dight=0;
        StringBuilder result=new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch=s.charAt(i);
            if (Character.isDigit(ch)){
                int num=ch-'0';
                dight=dight*10+num;
            }else if((ch>='a'&&ch<='z')){
                result.append(ch);
            } else if (ch == '[') {
                numStack.offerLast(dight);
                strStack.offerLast(result);
                dight=0;
                result=new StringBuilder();
            } else if (ch == ']') {
                int count = numStack.pollLast();
                StringBuilder outString = strStack.pollLast();
                for (int j = 0; j < count; j++) {
                    outString.append(result.toString());
                }
                result = outString;
            }
        }
        return  result.toString();
    }
}