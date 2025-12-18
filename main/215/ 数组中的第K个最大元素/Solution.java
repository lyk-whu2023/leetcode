//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。


class Solution {
    /**
     * 查找数组中第k大的元素
     * 时间复杂度: 平均O(n)，最坏O(n²)，但可以通过随机化pivot避免最坏情况
     * 空间复杂度: 平均O(log n)，最坏O(n)（递归栈深度）
     *
     * @param nums 输入整数数组
     * @param k 要找的第k大元素（1-based，即k=1表示最大元素）
     * @return 第k大的元素
     */
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        // 将"第k大"转换为"第(n-k)小"的索引（0-based）
        // 例如：数组[3,2,1,5,4]，n=5，k=2（第2大）
        // 排序后：[1,2,3,4,5]，第2大是4
        // 等价于第(5-2)=3小的元素，索引为3
        int kthSmallestIndex = n - k;

        // 调用快速选择算法
        return quickSelect(nums, 0, n - 1, kthSmallestIndex);
    }

    /**
     * 快速选择算法 - 找到数组中第targetIndex小的元素（0-based索引）
     * 原理：基于快速排序的分区思想，但只递归处理包含目标元素的那一半
     *
     * @param nums 数组
     * @param left 当前处理的左边界（包含）
     * @param right 当前处理的右边界（包含）
     * @param targetIndex 目标元素的索引（要找第targetIndex小的元素）
     * @return 第targetIndex小的元素值
     */
    private int quickSelect(int[] nums, int left, int right, int targetIndex) {
        // 递归终止条件：区间只有一个元素，这个元素就是结果
        if (left == right) {
            return nums[left];
        }

        // 选择分区基准元素(pivot) - 这里使用最左边的元素
        // 注意：这可能导致最坏情况O(n²)，建议使用随机pivot优化
        int pivot = nums[left];

        // 初始化指针：
        // i从left-1开始，向右移动，寻找>=pivot的元素
        // j从right+1开始，向左移动，寻找<=pivot的元素
        int i = left - 1;
        int j = right + 1;

        // 荷兰国旗问题(three-way partition)的分区算法
        while (i < j) {
            // 步骤1: 从左向右找到第一个>=pivot的元素
            // 跳过所有<pivot的元素
            do {
                i++;
            } while (i <= right && nums[i] < pivot);

            // 步骤2: 从右向左找到第一个<=pivot的元素
            // 跳过所有>pivot的元素
            do {
                j--;
            } while (j >= left && nums[j] > pivot);

            // 步骤3: 如果i和j还没有交错，交换这两个元素
            // 使得<pivot的元素在左边，>pivot的元素在右边
            if (i < j) {
                swap(nums, i, j);
            }
        }
        // 循环结束后：
        // 1. 所有left...j位置的元素都<=pivot
        // 2. 所有j+1...right位置的元素都>=pivot
        // 3. j是最后一个<=pivot的元素的位置

        // 根据目标索引的位置决定递归方向
        if (targetIndex <= j) {
            // 目标索引在左半部分（包含j），递归处理左半部分
            return quickSelect(nums, left, j, targetIndex);
        } else {
            // 目标索引在右半部分，递归处理右半部分
            return quickSelect(nums, j + 1, right, targetIndex);
        }
    }

    /**
     * 交换数组中两个位置的元素
     *
     * @param nums 数组
     * @param i 第一个位置的索引
     * @param j 第二个位置的索引
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}