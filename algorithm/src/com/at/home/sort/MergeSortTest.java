package com.at.home.sort;

import java.util.Arrays;

public class MergeSortTest {

    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        mergeSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 归并排序：
     *      归并排序使用的就是分治思想。分治，顾名思义，就是分而治之，把数组从中间分成前后两部分，然后
     *      对前后两部分分别排序，再将排好序的两部分合并在一起，这样整个数组就都有序了。
     *
     * 算法复杂度：
     *      时间复杂度：O(nlogn)
     *      空间复杂度：O(n)
     *
     * @param arr 待排序数组
     * @param left 左数组起始下标
     * @param right 右数组起始下标
     */
    public static void mergeSort(int[] arr, int left, int right) {
        // 只在区间有效且至少有两个元素时才递归
        if (left < right) {
            // 避免整型溢出写法
            int mid = left + (right - left) / 2;

            // 递归排序左半边
            mergeSort(arr, left, mid);

            // 递归排序右半边
            mergeSort(arr, mid + 1, right);

            // 合并左右两个有序子数组
            merge(arr, left, mid, right);
        }
    }
    //  合并两个有序子数组：arr[left..mid] 和 arr[mid+1..right]
    public static void merge(int[] arr, int left, int mid, int right){
        // 创建临时数组存放合并后的结果
        int[] tmpArr = new int[right - left + 1];

        int leftIndex = left;       // 左子数组的起始位置
        int rightIndex = mid + 1;   // 右子数组的起始位置
        int arrIndex = 0;           // 临时数组索引

        // 两个数组都未遍历完，按大小合并
        while (leftIndex <= mid && rightIndex <= right) {
            if (arr[leftIndex] < arr[rightIndex]) {
                tmpArr[arrIndex++] = arr[leftIndex++];
            } else {
                tmpArr[arrIndex++] = arr[rightIndex++];
            }
        }

        // 如果左边有剩余，拷贝进临时数组
        while (leftIndex <= mid) {
            tmpArr[arrIndex++] = arr[leftIndex++];
        }

        // 如果右边有剩余，拷贝进临时数组
        while (rightIndex <= right) {
            tmpArr[arrIndex++] = arr[rightIndex++];
        }

        // 将合并后的数组拷贝回原数组对应的位置
        for (int i = 0; i < tmpArr.length; i++) {
            arr[left + i] = tmpArr[i];
        }
    }

}
