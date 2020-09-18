package com.cz.sort;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * 快速排序 80w 82ms  800w 696ms
 */
public class quickSort {

    public static void main(String[] args) {
//        int[] arr = {2,3,-1,0,4,5,1};
//          int maxSize = arr.length;

        Random random = new Random();

        int maxSize = 8000000;
        int[] arr = new int[maxSize];
        arr[0] = maxSize / 4;
        for (int i = 1; i < maxSize-1; i++) {
            arr[i] = random.nextInt(8000000);
        }

//        System.out.println(Arrays.toString(arr));
        long front = System.currentTimeMillis();
        System.out.println("front time:"+new Date(front));
        quickSort(arr,0,maxSize-1);
        long hind = System.currentTimeMillis();
        System.out.println("hind time:"+new Date(hind));

        Long l = Long.valueOf(hind - front);
        System.out.println((double)l/1000 + "s");
//        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快速排序:挖坑填数+递归
     * 以第一个数为基准数
     * @param arr
     */
    public static void quickSort(int[] arr,int left, int right){

        if (left >= right){
            return;
        }
        int l = left;
        int r = right;

        //基准值
        int value = arr[l];


        while(l < r){

            while (l < r && arr[r] >= value){
                r--;
            }

            //右边值比基准值小，左移
            if ( l < r && arr[r] < value){
                arr[l] = arr[r];
                l++;
            }

            while (l < r && arr[l] <= value){
                l++;
            }

            //左边值比基准值大，右移
            if (l < r && arr[l] > value){
                arr[r] = arr[l];
                r--;
            }

        }
        arr[l] = value;

        //值的左边递归
        quickSort(arr,left,l-1);
        //值的右边递归
        quickSort(arr,r+1,right);

    }

    /**
     *  快速排序，以索引在中间的值为基准值
     * @param arr
     * @param left
     * @param right
     */
    public static void QSort(int[] arr,int left,int right){

        int l = left;
        int r = right;
        int index = (left + right)/2;
        int value = arr[index];

        int temp = 0;
        while(l < r){

            //限制l在arr[index]的左边，即：l <= index
            while(arr[l] < value){
                l++;
            }

            //限制r在arr[index]的右边，即：r >= index

            while (arr[r] > value){
                r--;
            }

            //左右交换完毕
            if (l >= r){
                break;
            }

            //交换
            temp = arr[r];
            arr[r] = arr[l];
            arr[l] = temp;

            //防止左右出现与value值相同的值导致死循环
            if (arr[l] == value){
                r--;
            }

            if (arr[r] == value){
                l++;
            }

        }

        //
        if (l == r){
            l++;
            r--;
        }

        //向左递归
        if (left < r){
            QSort(arr,left,r);
        }

        //向右递归
        if (right > l){
            QSort(arr,l,right);
        }
    }
}
