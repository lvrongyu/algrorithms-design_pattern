package com.at.home.sort;

import java.util.Arrays;
import java.util.Objects;

public class BubbleSortTest {
    public static void main(String[] args) {
        int[] array = { 5, 4, 1, 2, 3 };
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 冒泡排序：
     *   每次冒泡操作都会对相邻的两个元素进行比较，看是否满足大小关系要求。如果不满足就让它俩互换。
     *   一次冒泡会让至少一个元素移动到它应该在的位置，重复 n 次，就完成了 n 个数据的排序工作。
     *
     * 时间复杂度为：O(n2), 空间复杂度为：O(1)-原地排序
     *
     * @param nums: 待排序数组
     */
    public static void bubbleSort(int[] nums){
        // 如果数组为空或长度为0，直接返回
        if (Objects.isNull(nums) || nums.length == 0) return;

        // 外层循环控制排序的轮数，每轮确定一个元素的最终位置
        for (int i = 0; i < nums.length; i++) {
            // 标志位，用来判断本轮是否发生了交换
            boolean isSorted = true;

            // 内层循环进行相邻元素两两比较，并根据大小进行交换
            // 注意：内层循环的终点是 nums.length - 1 - i，因为每轮结束后，末尾的 i 个元素已经排好序了
            for (int j = 0; j < nums.length - 1 - i; j++) {
                // 如果前一个元素比后一个元素大，交换它们
                if (nums[j] > nums[j + 1]) {
                    // 调用工具方法进行交换
                    ArrayUtils.swap(nums, j, j + 1);
                    // 本轮发生了交换，说明数组还未完全有序
                    isSorted = false;
                }
            }

            // 如果一整轮下来都没有交换，说明数组已经有序，可以提前结束
            if (isSorted) {
                return;
            }
        }
    }

}
