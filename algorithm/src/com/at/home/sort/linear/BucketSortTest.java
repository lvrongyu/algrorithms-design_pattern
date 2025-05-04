package com.at.home.sort.linear;

import com.at.home.sort.QuickSortTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BucketSortTest {

    /**
     * 桶排序:
     *      核心思想是将要排序的数据分到几个有序的桶里，每个桶里的数据再单独进行排序。
     *      桶内排完序之后，再把每个桶里的数据按照顺序依次取出，组成的序列就是有序的了
     *
     * 算法复杂度：
     *      时间复杂度：O(n + k + n log(n/k))：n 是输入数组的大小，k 是桶的数量。每个桶内使用 O(log(n/k)) 排序算法（如快排）
     *      空间复杂度：O(n + k)：O(n)：用于存储输入元素被分配到桶中的临时结构。O(k)：用于存储桶列表（通常为 List<List<>> 或数组的数组）。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        bucketSort(arr, 10);
        System.out.println(Arrays.toString(arr));
    }

    public static void bucketSort(int[] array, int bucketCount) {
        if (array == null || array.length == 0) return;

        // 初始化桶
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        // 找出最大值和最小值
        int maxValue = array[0];
        int minValue = array[0];
        for (int num : array) {
            maxValue = Math.max(maxValue, num);
            minValue = Math.min(minValue, num);
        }

        // 将每个元素分配到对应的桶
        for (int num : array) {
            int bucketIndex = (int) ((long)(num - minValue) * bucketCount / (maxValue - minValue + 1));
            buckets.get(bucketIndex).add(num);
        }

        // 对每个桶内元素进行排序并合并回原数组
        int index = 0;
        for (List<Integer> bucket : buckets) {
            // Arrays.sort(array);
            // 使用插入排序或者快排
            int[] arr = QuickSortTest.quickSort(bucket);
            for (int num : arr) {
                array[index++] = num;
            }
        }
    }
}
