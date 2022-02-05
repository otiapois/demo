package com.fouo;

import java.util.Arrays;
/**
 * 冒泡排序
 *
 * @author fouo
 * @date 2020/10/30 0:09
 */
public class BubbleSortDemo {

    public static void main(String[] args) {

        int[] a = {3,1,2,4,2,4,5,2,31,543,3};
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void bubbleSort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

    }
}
