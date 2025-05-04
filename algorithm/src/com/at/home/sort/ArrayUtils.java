package com.at.home.sort;

public class ArrayUtils {

    /**
     * 交换数组中两个元素的位置。
     *
     * @param array 目标数组
     * @param i     第一个元素的索引
     * @param j     第二个元素的索引
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
