//给定一个整数数组  nums，处理以下类型的多个查询:
//计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
//实现 NumArray 类：
//NumArray(int[] nums) 使用数组 nums 初始化对象
//int sumRange(int i, int j) 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，
// 包含 left 和 right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] )

class NumArray {
    int[] sums;
    public NumArray(int[] nums) {
        int n=nums.length;
        sums = new int[n + 1];
        int sum=0;
        for (int i = 0; i < n; i++) {
            sum+=nums[i];
            sums[i+1]=sum;
        }
    }

    public int sumRange(int left, int right) {
        return sums[right + 1] - sums[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */