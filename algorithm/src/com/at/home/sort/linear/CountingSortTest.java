package com.at.home.sort.linear;

import java.util.Arrays;

public class CountingSortTest {

    public static void main(String[] args) {
        int[] test = {2,3,4,5,6,7,8,8,1,1,9,9,9};
        countingSort(test);
        System.out.println(Arrays.toString(test));
    }

    /**
     * 计数排序：
     *     是一种特殊的桶排序，当要排序的 n 个数据，所处的范围并不大的时候，比如最大值是 k，
     *     我们就可以把数据划分成 k 个桶。每个桶内的数据值都是相同的，省掉了桶内排序的时间。
     *
     * 适用场景：
     *      计数排序只能用在数据范围不大的场景中，如果数据范围 k 比要排序的数据 n 大很多，就不适合用计
     *      数排序了。而且，计数排序只能给非负整数排序，如果要排序的数据是其他类型的，要将其在不改变相
     *      对大小的情况下，转化为非负整数。
     *      例如：有 50 万考生（总分900），如何通过成绩快速排序得出名次呢？
     * 复杂度：
     *      时间复杂度：O(n+k)
     *      空间复杂度：O(n)
     * @param arr
     */
    public static void countingSort(int[] arr) {
        // 1. 找出数组中的最大值（用于确定桶的大小）
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

        int len = arr.length;

        // 桶的大小应该是 max + 1，而不是 len + 1
        int[] buckets = new int[max + 1]; // 创建计数桶，大小为最大值 + 1

        // 2. 统计每个数字出现的次数
        for (int num : arr) {
            buckets[num]++;
        }

        // 3. 回写排序结果
        int index = 0;
        for (int i = 0; i < buckets.length; i++) {
            while (buckets[i]-- > 0) {  // 当前数字 i 出现了几次就写几次
                arr[index++] = i;
            }
        }
    }
}
