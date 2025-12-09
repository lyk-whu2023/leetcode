//实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。

class Solution {
    public double myPow(double x, int n) {
        return (long) n >= 0 ? quickMul(x, n) : 1.0 / quickMul(x, -(long) n);
    }
    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }
}
class Solution1 {
    public double myPow(double x, int n) {
        return (long) n >= 0 ? quickMul(x, n) : 1.0 / quickMul(x, -(long) n);
    }
    public double quickMul(double x, long N){
        if (N == 0) {
            return 1.0;
        }
        double ans=1.0;
        double x_contribute = x;
        while (N > 0) {
            if (N % 2 == 1) {
                ans *= x_contribute;
            }
            x_contribute *= x_contribute;
            N/=2;
        }
        return ans;
    }
}

class Solution2 {
    public double myPow(double x, int n) {
        // 边界条件：0的任何次幂都是0（0^0在数学上未定义，这里按0处理）
        if (x == 0.0f) return 0.0d;

        // 将n转换为long类型，防止n=-2147483648时取反溢出
        long b = n;
        double res = 1.0;

        // 处理负指数：x^(-n) = 1 / x^n
        if (b < 0) {
            x = 1 / x;  // 取倒数
            b = -b;     // 将指数转为正数
        }

        // 快速幂算法核心
        while (b > 0) {
            // 判断二进制最低位是否为1：(b & 1) == 1
            // 如果当前位为1，则将当前的x乘入结果
            if ((b & 1) == 1) {
                res *= x;
            }

            // 平方操作：x = x^2
            // 对应于指数的二进制表示中，下一位的基数是当前位的平方
            x *= x;

            // 右移一位：b >>= 1
            // 相当于 b = b / 2，检查下一个二进制位
            b >>= 1;
        }

        return res;
    }
}
