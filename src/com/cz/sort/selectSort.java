package com.cz.sort;

import java.util.Arrays;
import java.util.Date;

/**
 * 选择排序:45s
 */
public class selectSort {
    public static void main(String[] args) {
//        int[] arr  = {2,1,90,65,48,-1,36};
        int maxSize = 800000;
        int[] arr = new int[maxSize];
        for (int i = maxSize - 1; i >= 0; i--) {
            arr[i] = i;
        }
        long front = System.currentTimeMillis();
        System.out.println("front time:"+new Date(front));
        selectSort(arr);
        long hind = System.currentTimeMillis();
        System.out.println("hind time:"+new Date(hind));


//        System.out.println(Arrays.toString(arr));
    }

    /**
     *选择排序；选择最小值
     */
    public static void selectSort(int[] arr){
        int min = 0;
        int minIndex = 0;

        for (int i = 0; i < arr.length-1; i++) {
            min = arr[i];
            minIndex = i;
            for (int j = i;j <= arr.length - 1; j++ ){
                if (min > arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }
            min = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = min;
        }
    }
}
