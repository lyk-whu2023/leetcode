//给你一个整数 n ，请你找出并返回第 n 个 丑数 。
//丑数 就是质因子只包含 2、3 和 5 的正整数。

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class Solution {
    public int nthUglyNumber(int n) {
        int[] dp=new int[n+1];
        dp[1]= 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <=n ; i++) {
            int num2=dp[p2]*2;
            int num3=dp[p3]*3;
            int num5=dp[p5]*5;
            dp[i]=Math.min(num2,Math.min(num3,num5));
            if (dp[i]==num2){
                p2++;
            }
            if (dp[i]==num3){
                p3++;
            }
            if (dp[i]==num5){
                p5++;
            }
        }
        return dp[n];
    }
}

class Solution1 {
    public int nthUglyNumber(int n) {

        // 对任意一个丑数来说，去和 2、3、5 分别相乘，可以得到 3 个丑数
        // 那么对每一个丑数都去和 2 、3 、5 分别相乘，把那些结果进行排序即可
        // 因此，2、3、5 就是我们需要处理的质因数
        int[] factors = { 2 , 3 , 5 };

        // 由于一些丑数和 2 、 3 、5 相乘会出现重复元素的情况
        // 比如丑数 2 和 2 、 3 、5 相乘得到了 4、【6】、10
        // 而丑数 3 和 2 、 3 、5 相乘得到了 【6】、9 、 15
        // 其中 【6】重复了，所以需要采取去重操作
        // 由于题目说明 n 最大为 1690，会导致丑数的范围超过了 int 范围，所以使用 long 来保存
        Set<Long> seen = new HashSet<Long>();

        // 使用优先队列来获取每次集合中最小的数字
        // 由于题目说明 n 最大为 1690，会导致丑数的范围超过了 int 范围，所以使用 long 来保存
        PriorityQueue<Long> pq = new PriorityQueue<Long>();

        // 集合中第一个数字是 1
        // 常量后面跟这种一般是指类型
        // 1L 表示 1 是长整型，如果是 1f 表示是 float 型
        seen.add(1L);

        // 优先队列里面的元素来源于 seen
        pq.offer(1L);

        // 开始不断的迭代丑数的值，直到迭代了 n 次为止
        // 第一个丑数是 1
        int ugly = 1;

        // 开始迭代
        for (int i = 0; i < n; i++) {

            // 下一个丑数来源于优先队列的队头元素
            long curr = pq.poll();

            // 本题需要返回 int 型，所以强转一下
            ugly = (int) curr;

            // 再将获取到的丑数和 2 、3 、5 分别相乘
            for (int factor : factors) {

                // 获取到新的丑数
                long next = curr * factor;

                // 经过去重操作后
                if (seen.add(next)) {
                    // 把这个丑数加入到优先队列里面
                    // 优先队列里面会自动操作，使得最小的元素位于队头
                    pq.offer(next);
                }
            }
        }

        // 返回结果
        return ugly;
    }
}

class Solution2 {
    public int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        Set<Long> seen = new HashSet<Long>();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        seen.add(1L);
        heap.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long curr = heap.poll();
            ugly = (int) curr;
            for (int factor : factors) {
                long next = curr * factor;
                if (seen.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }
}
