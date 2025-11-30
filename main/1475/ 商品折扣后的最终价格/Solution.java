//给你一个数组 prices ，其中 prices[i] 是商店里第 i 件商品的价格。
//商店里正在进行促销活动，如果你要买第 i 件商品，那么你可以得到与 prices[j] 相等的折扣，
//其中 j 是满足 j > i 且 prices[j] <= prices[i] 的 最小下标 ，如果没有满足条件的 j ，你将没有任何折扣。
//请你返回一个数组，数组中第 i 个元素是折扣后你购买商品 i 最终需要支付的价格。

import java.util.Stack;

class Solution {
    public int[] finalPrices(int[] prices) {
        int n=prices.length;
        int[] ans=new int[n];
        Stack<Integer>stack=new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            int tmp=prices[i];
            while (!stack.isEmpty()&&tmp<stack.peek()){
                stack.pop();
            }
            if (!stack.isEmpty()){
                ans[i] = tmp - stack.peek();
            }else {
                ans[i]=tmp;
            }
            stack.push(tmp);
        }
        return ans;
    }
}