package com.at.home.sort;

import java.util.Arrays;
import java.util.List;

public class QuickSortTest {

    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快速排序：
     *     由上到下的，先分区，然后再处理子问题；选择分区的最右侧元素为分区点，根据分治、递归的处理思想，
     *     用递归排序下标left到pivotIndex和pivotIndex到right之间的数据，直到区间缩小为0，所有数据就有序了
     *
     *  算法复杂度：
     *      时间复杂度：O(nlogn)
     *      空间复杂度：O(n)
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr, int left, int right) {
        // 当排序区间至少有两个元素时才递归
        if (left < right) {
            // 将数组分区，并得到基准值（pivot）最终所在位置
            int pivotIndex = partition(arr, left, right);

            // 递归排序左半部分（小于 pivot 的部分）
            quickSort(arr, left, pivotIndex - 1);

            // 递归排序右半部分（大于 pivot 的部分）
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right]; // 选择最右边元素作为基准值
        int i = left - 1;        // i 表示“已处理小于等于 pivot 的元素的最后位置”

        // 遍历从 left 到 right - 1 的所有元素
        for (int j = left; j < right; j++) {
            // 当前元素小于等于 pivot 时，扩大“较小值区间”
            if (arr[j] <= pivot) {
                i++; // i 向右移动一位

                // 如果 i 和 j 不相等，交换元素，使小于等于 pivot 的元素排到前面
                if (i != j) {
                    ArrayUtils.swap(arr, i, j); // 自定义工具类方法，交换 arr[i] 和 arr[j]
                }
            }
        }

        // 最后将 pivot 放到正确位置：i + 1（即大于 pivot 的区间起点）
        ArrayUtils.swap(arr, i + 1, right);

        // 返回 pivot 的最终位置，用于下一步划分
        return i + 1;
    }

    public static int[] quickSort(List<Integer> list) {
        int[] arr = new int[list.size()];
        int index = 0;
        for (Integer i : list) {
            arr[index++] = i;
        }
        quickSort(arr, 0, arr.length-1);
        return arr;
    }
}
