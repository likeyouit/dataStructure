package com.cz.sort;

import java.util.Arrays;
import java.util.Date;

/**
 * 插入排序:149s
 */
public class insertSort {

    public static void main(String[] args) {
//        int[] arr = {101,34,169,11};

        int maxSize = 800000;
        int[] arr = new int[maxSize];
        for (int i = maxSize - 1; i >= 0; i--) {
            arr[maxSize - i -1] = i;
        }

        long front = System.currentTimeMillis();
        System.out.println("front time:"+new Date(front));
        insertSort(arr);
        long hind = System.currentTimeMillis();
        System.out.println("hind time:"+new Date(hind));
//        insertSort(arr);
    }

    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            //待排序的元素
            int data = arr[i];
            //前一个元素索引
            int index = i - 1;
            while(index >= 0 && data < arr[index]){
                //有序表被比较的元素后移
                arr[index+1] = arr[index];
                arr[index] = data;
                index--;
            }
//            System.out.printf("第%d轮比较后的数组%s：",i,Arrays.toString(arr));
//            System.out.println();
        }
    }
}
