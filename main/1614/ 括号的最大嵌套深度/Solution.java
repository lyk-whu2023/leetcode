//给定 有效括号字符串 s，返回 s 的 嵌套深度。嵌套深度是嵌套括号的 最大 数量。


class Solution {
    public int maxDepth(String s) {
        int max=0;
        int cur=0;
        char[] temp= s.toCharArray();
        for (char ch :
                temp) {
            if (ch=='('){
                cur ++;
                max=Math.max(max,cur);
            } else if (ch == ')') {
                cur--;
            }
        }
        return max;
    }
}