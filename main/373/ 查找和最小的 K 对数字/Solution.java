//给定两个以 非递减顺序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。
//定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
//请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    //空间复杂度过高
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]>priorityQueue=new PriorityQueue<>((a,b)->nums1[a[0]]+nums2[a[1]]-(nums1[b[0]]+nums2[b[1]]));
        List<List<Integer>> ans = new ArrayList<>();
        int m=nums1.length;
        int n=nums2.length;
        boolean[][] visited = new boolean[m][n];
        priorityQueue.offer(new int[] {0,0});
        visited[0][0] = true;
        while (k-->0&&!priorityQueue.isEmpty()){
            int[] idxPair = priorityQueue.poll();
            int a=idxPair[0];
            int b=idxPair[1];
            List<Integer> list = new ArrayList<>();
            list.add(nums1[a]);
            list.add(nums2[b]);
            ans.add(list);
            if (a + 1 < m && !visited[a + 1][b]){
                priorityQueue.offer(new int[] {a+1,b});
                visited[a + 1][b] = true;
            }
            if (b + 1 < n && !visited[a][b + 1]){
                priorityQueue.offer(new int[] {a,b+1});
                visited[a][b + 1] = true;
            }
        }
        return ans;
    }
}


//注意思维，通过提前注入实现类似扫描的效果，从而避免重复注入
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 队列是遵循先进先出（First-In-First-Out）模式的，但有时需要在队列中基于优先级处理对象。
        // PriorityQueue 和队列 Queue 的区别在于 ，它的出队顺序与元素的优先级有关
        // 对 PriorityQueue 调用 remove() 或 poll() 方法 ，返回的总是优先级最高的元素
        // Java 中 PriorityQueue 通过二叉小顶堆实现
        // PriorityQueue 默认是一个【小顶堆】，可以通过传入自定义的 Comparator 函数来实现【大顶堆】
        // PriorityQueue 里面的每个元素是一个数组，这个数组包含了两个元素，表示 nums1 的索引和 nums2 的索引
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> nums1[a[0]] + nums2[a[1]] - (nums1[b[0]] + nums2[b[1]]));

        // 由于 nums1 和 nums2 都是升序序列，最小的组合就是 nums1[0] + nums2[0]
        // 接下来的组合需要经过比较
        // 和谁比较呢
        // 可以把 nums2 中的第一个元素和 nums1 中的每个元素都先组合一下，存放到优先队列当中
        for (int i = 0; i < nums1.length; i++) {
            // 优先队列存放的是索引
            pq.offer(new int[] {i, 0});
        }

        // 结果数组
        List<List<Integer>> ans = new ArrayList<>();

        // 访问优先队列，不断的弹出队头元素，最多弹 k 次就行
        while (k-- > 0 && !pq.isEmpty()) {

            // 取出队头元素
            // pos 是一个数组，包含两个元素，表示 nums1 的索引和 nums2 的索引
            int[] pos = pq.poll();

            int index1 = pos[0];

            int index2 = pos[1];

            // 利用这两个索引获取到对应的元素进行组合
            ans.add(Arrays.asList(nums1[index1], nums2[index2]));

            // 获取下一个索引
            index2++;

            // 判断 nums2 中是否还有元素
            if (index2 < nums2.length) {
                // 如果有，那么又是一个新的组合
                int[] newPos = { index1 ,index2 };

                // 加入到优先队列，在内部会自动进行排序操作
                pq.offer(newPos);
            }
        }

        // 返回结果
        return ans;
    }
}