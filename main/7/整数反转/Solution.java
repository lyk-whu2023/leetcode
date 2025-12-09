//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
//如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
//假设环境不允许存储 64 位整数（有符号或无符号）。
class Solution {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int last = x % 10;
            if (result > 214748364 || ( result == 214748364 && (last == 8 || last == 9 ))) {
                return 0;
            }
            if (result < -214748364 || (result == -214748364 && last == -9 )) {
                return 0;
            }
            result = result*10 + last;
            x = x / 10;
        }
        return result;
    }
}