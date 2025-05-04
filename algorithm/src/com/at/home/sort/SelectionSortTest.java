package com.at.home.sort;

import java.util.Arrays;

public class SelectionSortTest {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 1, 2, 3 };
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    /**
     * 对整数数组进行升序排序，使用插入排序算法。
     * 插入排序：
     *   与插入排序类似，选择排序每次会从未排序区间中找到最小的元素，将其放到已排序区间的末尾
     *
     * 时间复杂度为：O(n2), 空间复杂度为：O(1)
     *
     * @param nums 待排序的整数数组
     */
    public static void selectionSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;  // 当前轮次中最小元素的索引

            // 在未排序部分中寻找最小元素
            for (int j = i + 1; j < length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }

            // 将最小元素交换到已排序部分的末尾
            ArrayUtils.swap(nums, i, minIndex);
        }
    }
}
