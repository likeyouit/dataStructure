package com.cz.sort;

import java.util.Arrays;
import java.util.Date;

/**
 * 归并排序：分解+合并
 * 8w 21ms 80w 94ms 800w 937ms
 */
public class MergeSort {

    public static void main(String[] args) {
//        int[] arr = {(int)(Math.random()*100),(int)(Math.random()*100),(int)(Math.random()*100),(int)(Math.random()*100),(int)(Math.random()*100),(int)(Math.random()*100),(int)(Math.random()*100),(int)(Math.random()*100)};
//        int[] arr = {8,4,5,7,1,3,6,2};
        int[] arr = new int[8000000];
        for (int i = 0; i <8000000 ; i++) {
            arr[i] = (int)(Math.random()*8000000);
        }
//        System.out.println(Arrays.toString(arr));
        int[] temp = new int[arr.length];

        long front = System.currentTimeMillis();
        System.out.println("front time:"+new Date(front));
        mergeOfDiv(arr,0,arr.length - 1,temp);
        long hind = System.currentTimeMillis();
        System.out.println("hind time:"+new Date(hind));

        Long l = Long.valueOf(hind - front);
        System.out.println((double)l/1000 + "s");

//        System.out.println(Arrays.toString(arr));

    }

    /**
     * 分解
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeOfDiv(int[] arr,int left,int right,int[] temp){
        if (left < right){
            int mid = (left + right) / 2 ;
            mergeOfDiv(arr,left,mid,temp);
            mergeOfDiv(arr,mid + 1,right,temp);
//            System.out.println("div:"+Arrays.toString(arr));
            mergeSort(arr,left,mid,right,temp);
//            System.out.println("临时的合并数组："+Arrays.toString(arr));
        }

    }

    /**
     * 合并
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    public static void mergeSort(int[] arr,int left,int mid,int right,int[] temp){
//        System.out.println("temp:"+Arrays.toString(temp));
        //左边有序序列的初始索引
        int i = left;

        //右边有序序列的初始索引
        int j = mid + 1;

        //临时数组temp的当前索引
        int t = 0;
        //把两个数组按照顺序放进temp
        while(i <= mid && j <= right){
            if (arr[i] <= arr[j]){
                temp[t] = arr[i];
                i += 1;
                t += 1;
            }else{
                temp[t] = arr[j];
                j += 1;
                t += 1;
            }
        }

        //可能有一边会有剩余元素
        //把剩下的剩余元素依次填入temp
        while(i<=mid){
            temp[t] = arr[i];
            i += 1;
            t += 1;
        }

        while(j <= right){
            temp[t] = arr[j];
            j += 1;
            t += 1;
        }

        //复制temp到arr
        t = 0;
        int tempLeft = left;
//        System.out.println("left:"+tempLeft+"right:"+right);
        while(tempLeft <= right){
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }
}
