package com.cz.sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;

/**
 * 基数排序：800w 959ms
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53,3,542,748,14,214};

//        int[] arr = new int[8000000];
//        for (int i = 0; i <8000000 ; i++) {
//            arr[i] = (int)(Math.random()*8000000);
//        }

        long front = System.currentTimeMillis();
        System.out.println("front time:"+new Date(front));
        radixSort(arr,1);
        long hind = System.currentTimeMillis();
        System.out.println("hind time:"+new Date(hind));

        Long l = Long.valueOf(hind - front);
        System.out.println((double)l/1000 + "s");


    }

    public static void radixSort(int[] arr,int div){
        //根据个位数排序
        int digitOfElement = 0;
        int[][] bucket = new int[10][arr.length];

        //记录哪个桶有多少个元素
        int[] count = new int[10];

        //把数组的元素放到桶里面
        for (int i = 0; i <arr.length ; i++) {
            //取不同的位数，个位，十位，百位...
            if(div == 1){
                digitOfElement = arr[i] % 10;
            }else{
                digitOfElement = (arr[i] /div) % 10;
            }

            bucket[digitOfElement][count[digitOfElement]] = arr[i];
            count[digitOfElement]++;
        }

        //把桶里面的元素形成一个新的数组
        int tempIndex = 0;
        for (int i = 0; i < count.length ; i++) {
            if (count[i] > 0){
                for (int j = 0; j < count[i]; j++) {
                    arr[tempIndex] = bucket[i][j];
                    tempIndex += 1;
                }
            }
        }
//        System.out.println("每一轮形成的新数组："+Arrays.toString(arr));
        //全部的数被装在一个桶里面
        for (int i:count) {
            if (i == arr.length){
//                System.out.println("最终数组："+Arrays.toString(arr));
                return;
            }
        }
        radixSort(arr,div*10);
    }
}
