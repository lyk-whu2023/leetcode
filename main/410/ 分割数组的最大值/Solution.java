//给定一个非负整数数组 nums 和一个整数 k ，你需要将这个数组分成 k 个非空的连续子数组，
// 使得这 k 个子数组各自和的最大值 最小。
//返回分割后最小的和的最大值。
//子数组 是数组中连续的部份。

class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0;// 子数组和最大值下界
        int right=0;// 子数组和最大值上界
        for(int num : nums){
            left = Math.max(left, num);
            right += num;
        }
        // 在区间 [ left , right ] 中寻找出一个合理的值
        // 这个值是使得这 m 个子数组各自和的最大值最小
        while(left <= right){
            int mid = left + (right - left) / 2;
            int cnt=  subSplit( nums , mid );
            if(cnt > k){
                left = mid + 1;
            }
            else if(cnt < k){
                right = mid - 1;
            }
            else {
                right = mid - 1;//尝试接着找更小值
            }
        }
        return left;
    }
    // 根据子数组和 maxSum 划分数组，返回子数组个数
    private int subSplit(int[] nums, int maxSum){
        int cnt = 1;
        int tmpArrSum = 0;
        for(int num : nums){
            if(tmpArrSum + num > maxSum){
                cnt++;
                tmpArrSum = num;
            }
            else {
                tmpArrSum += num;
            }
        }
        return cnt;
    }
}

class Solution1 {
    public int splitArray(int[] nums, int m) {
        // m 表示将数组 nums 划分为 m 个子数组
        // 对于数组 nums 来说
        // 即可以划分为 1 个完整的子数组，子数组包含 nums 里面所有的元素
        // 也可以划分为 n 个子数组，每个子数组只包含 1 个元素
        // 也就是说，m 的取值范围为 1 <= m <= n
        // 假设 nums = [ 7 , 2 , 5 , 10 , 8 ]
        // 1、如果 m = 1 ，那么整个数组作为一部分，只有一种划法，最小的最大值为 32
        // 2、如果 m = n，那么每个元素作为一个子数组，只有一种划法，从所有元素选取最大值，最小的最大值为 10
        // 因此，最大值的最小值的范围为 [10, 32]
        // 这里说明一下最大值和最小值的概念
        // 最大值：在一个确定的划分之后，有很多个子数组，从所有子数组和里面挑选出一个最大值来
        // 最小值：在 m 等于某个数字时，有很多种划分的方法，每一种划法都能有最大值，比较这些最大值，选出最小的来

        // left 记录子数组和最大值下界
        int left = 0;

        // right记录子数组和最大值上界
        int right = 0;

        for(int num : nums){

            // 子数组和最大值下界为数组中元素的最大值，这个时候每个元素表示 1 个子数组
            left = Math.max(left, num);

            // 子数组和最大值上界位数组中所有元素和，这个时候只有 1 个子数组
            right += num;

        }

        // 在区间 [ left , right ] 中寻找出一个合理的值
        // 这个值是使得这 m 个子数组各自和的最大值最小
        while(left <= right){

            // 猜测中间值为答案
            int mid = left + (right - left) / 2;

            // 按照这种方案把数组进行划分
            // 得到的子区间数 cnt
            int cnt = subSplit( nums , mid );

            // 开始分析这种划分是否合理
            // 1、划分的子数组个数多了
            if(cnt > m){

                // 为什么会划分的子数组个数多了
                // 因为限定的子数组的元素和值小，导致只能不断地去划分子数组
                // 为了可以少划分一些，需要提高子数组的元素和值
                left = mid + 1;

                // 2、划分的子数组个数少了
            }else if(cnt < m){

                // 为什么会划分的子数组个数少了
                // 因为限定的子数组的元素和值大，导致每个子数组可以装很多元素
                // 为了可以多划分一些，需要减小子数组的元素和值
                right = mid - 1;

                // 3、划分的子数组个数刚刚好
            }else if(cnt == m){
                // 此时，找到了满足分割数 m 的子数组最大值
                // 在此基础上继续在左区间寻找
                // 这样，才能使得满足分割数且最大值最小
                right = mid - 1;

            }
        }

        // while 终止条件是 left > right
        // 最后一次跳出 while 之前，left 会等于 right
        // 1、如果此时，在这种情况下进行切分的结果刚好等于分割数 m
        // 那么为了获取更小的值，right 会向左移动，从而导致 left > right
        // 于是，left 就是那个满足分割数为 m 情况下最大值最小的数
        // 2、如果此时，在这种情况下进行切分的结果不等于分割数 m
        // left 会向右移动，从而导致 left > right
        // 最终 left 也恰好等于上一次分割数为 m 的 mid 值
        // 结合视频里面的动画进行理解
        return left;

    }

    // 根据子数组和 maxSum 划分数组，返回子数组个数
    private int subSplit(int[] nums, int maxSum){

        // 默认为划分为一个子数组，即就是 nums 数组
        int cnt = 1;

        // 当前子数组的元素和
        int tmpArrSum = 0;

        // 对每个元素进行考虑它是否有资格划分进行
        for(int num : nums){

            // 如果发现把当前元素和归纳到目前这个数组后
            // 导致子数组元素和大于了 maxSum
            if(tmpArrSum + num > maxSum){

                // 说明，这个元素需要开始另外分配一个子数组了
                // 以该元素为界限开始进行划分
                cnt++;

                // 当前子数组的元素和归零
                tmpArrSum = 0;
            }

            // 当前子数组的元素和进行累加
            tmpArrSum += num;
        }

        // 返回子数组的个数
        // 这些子数组每个子数组元素和的最大值都不会超过 maxSum
        return cnt;
    }
}