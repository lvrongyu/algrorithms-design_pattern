package com.at.home.sort;

import java.util.Arrays;

public class InsertionSortTest {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 1, 2, 3 };
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插入排序：
     *   将数组划分为已排序和未排序两部分，每次将未排序部分的第一个元素插入到已排序部分的正确位置。
     *   插入算法的核心思想是取未排序区间中的元素，在已排序区间中找到合适的插入位置将其插入，并保证已排序区间数据一直有序
     *
     * 时间复杂度为：O(n2), 空间复杂度为：O(1)
     *
     * @param array 待排序的整数数组
     */
    public static void insertionSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        int length = array.length;
        for (int i = 1; i < length; i++) {
            int current = array[i];  // 当前需要插入的元素
            int prevIndex = i - 1;   // 已排序区域的最后一个元素索引

            // 从已排序区域向左扫描，找到正确的插入位置
            while (prevIndex >= 0 && array[prevIndex] > current) {
                array[prevIndex + 1] = array[prevIndex];  // 元素右移
                prevIndex--;
            }

            // 将当前元素插入到正确的位置
            array[prevIndex + 1] = current;
        }
    }


    public static void insertionSort(Integer[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        int length = array.length;
        for (int i = 1; i < length; i++) {
            int current = array[i];  // 当前需要插入的元素
            int prevIndex = i - 1;   // 已排序区域的最后一个元素索引

            // 从已排序区域向左扫描，找到正确的插入位置
            while (prevIndex >= 0 && array[prevIndex] > current) {
                array[prevIndex + 1] = array[prevIndex];  // 元素右移
                prevIndex--;
            }

            // 将当前元素插入到正确的位置
            array[prevIndex + 1] = current;
        }
    }
}
