package com.at.home.sort.linear;

import java.util.Arrays;

public class RadixSortTest {
    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("排序前: " + Arrays.toString(arr));

        radixSort(arr);

        System.out.println("排序后: " + Arrays.toString(arr));
    }


    /**
     * 基数排序：
     *     基数排序对要排序的数据是有要求的，只适用于整数或能表示为整数的数据，需要可以分割出独立的“位”来比较，
     *     而且位之间有递进的关系，如果 a 数据的高位比 b 数据大，那剩下的低位就不用比较了。除此之外，每一位的数据
     *     范围不能太大，要可以用线性排序算法来排序，否则，基数排序的时间复杂度就无法做到 O(n) 了。
     *
     * 适用场景：
     *      计数排序只能用在数据范围不大的场景中，如果数据范围 k 比要排序的数据 n 大很多，就不适合用计
     *      数排序了。而且，计数排序只能给非负整数排序，如果要排序的数据是其他类型的，要将其在不改变相
     *      对大小的情况下，转化为非负整数。
     *      例如：假设我们有 10 万个手机号码，希望将这 10 万个手机号码从小到大排序，你有什么比较快速的排序方法呢？
     *
     * 复杂度：
     *      时间复杂度：O(nk)，当k较小时效率很高
     *      空间复杂度：O(n+k)
     * @param arr
     */
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 找出最大值确定位数
        int max = 0;
        for(int num : arr) {
            if(num > max) {
                max = num;
            }
        }

        // 进行基数排序
        int exp = 1; // 从个位开始
        int[] output = new int[arr.length];

        while (max / exp > 0) {
            int[] count = new int[10];

            // 统计每个数字出现的次数
            for (int num : arr) {
                count[(num / exp) % 10]++;
            }

            // 计算累计次数
            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }

            // 根据当前位排序
            for (int i = arr.length - 1; i >= 0; i--) {
                int current = (arr[i] / exp) % 10;
                output[count[current] - 1] = arr[i];
                count[current]--;
            }

            // 将排序结果复制回原数组
            System.arraycopy(output, 0, arr, 0, arr.length);

            exp *= 10; // 处理下一位
        }
    }
}
