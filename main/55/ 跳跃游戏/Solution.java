//给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
//判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。

class Solution {
    public boolean canJump(int[] nums) {
        int maxReach=0;
        for (int i = 0; i < nums.length; i++) {
            if (maxReach<i){
                return false;
            }
            maxReach=Math.max(maxReach,i + nums[i]);
        }
        return true;
    }
}

class Solution1 {
    public boolean canJump(int[] nums) {
        int n = nums.length;           // 数组长度
        int rightmost = 0;             // 当前能够到达的最远位置索引

        // 遍历数组中的每个位置
        for (int i = 0; i < n; ++i) {
            // 如果当前位置 i 在可达范围内（i <= rightmost）
            if (i <= rightmost) {
                // 更新最远可达位置：取当前最远位置和（当前位置 + 可跳距离）的较大值
                rightmost = Math.max(rightmost, i + nums[i]);

                // 如果最远可达位置已经达到或超过最后一个位置
                if (rightmost >= n - 1) {
                    return true;       // 可以到达终点，提前返回
                }
            }
            // 如果 i > rightmost，说明当前位置已经不可达，循环会自动继续，
            // 但之后的 i 会一直大于 rightmost，所以不会更新 rightmost
        }
        return false;  // 遍历结束仍未到达终点，返回 false
    }
}