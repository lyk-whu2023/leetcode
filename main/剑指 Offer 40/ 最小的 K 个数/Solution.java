//输入整数数组 arr ，找出其中最小的 k 个数。
//例如，输入 4、5、1、6、2、7、3、8 这 8 个数字，则最小的 4 个数字是 1、2、3、4 。

class Solution {
    public int[] smallestK(int[] arr, int k) {
        int[] answer=new int[k];
        quickSelect(arr,0,arr.length-1,k);
        for (int i = 0; i < k; i++) {
            answer[i]=arr[i];
        }
        return answer;
    }
    private void quickSelect(int[] nums, int left, int right, int targetIndex){
        if (left >= right) {
            return;
        }
        int pivotIndex = left + (int)(Math.random() * (right - left + 1));
        swap(nums, left, pivotIndex);
        int pivot = nums[left];
        int i=left-1;
        int j=right+1;
        while (i<j){
            do {
                i++;
            }while (i<=right&&nums[i]<pivot);
            do {
                j--;
            }while (j>=left&&nums[j]>pivot);
            if (i<j){
                swap(nums,i,j);
            }
        }
        if (targetIndex <= j) {
            quickSelect(nums,left,j,targetIndex);
        }else {
            quickSelect(nums, j + 1, right, targetIndex);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}