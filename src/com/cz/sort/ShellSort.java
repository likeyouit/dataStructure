package com.cz.sort;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * 希尔排序：交换法157s，移位法40s
 *  以一定的下标增量分组进行排序，随着分的组数越少，越趋近于最终的排序结果，当下标增量为1时使用插入排序
 */
public class ShellSort {
    public static void main(String[] args) {
//        int[] arr = {101,43,94,0,-4,25,33,5};
//        shellSort(arr,2);

        Random random = new Random();

        int maxSize = 800000;
        int[] arr = new int[maxSize];
        for (int i = 0; i < maxSize; i++) {
            arr[i] = random.nextInt(800000);
        }

        long front = System.currentTimeMillis();
        System.out.println("front time:"+new Date(front));
        Move2ShellSort(arr,2);
        long hind = System.currentTimeMillis();
        System.out.println("hind time:"+new Date(hind));
    }

    /**
     * 交换法希尔排序
     * @param arr
     * @param group 数组分组
     */
    public static void shellSort(int[] arr,int group){
        int temp = 0 ;

        for (int k = group; group > 0; group /= 2) {
//            System.out.println("继续分组....");
            for (int i = 0; i <group ; i++) {
                for (int j = i; j < arr.length -group; j+=group) {
                    if (arr[j] > arr[j+group]){
                        temp = arr[j+group];
                        arr[j+group] = arr[j];
                        arr[j] = temp;
                    }
//                System.out.println("排序后的数组："+ Arrays.toString(arr));
                }
//                System.out.println("第"+(i+1)+"组排序："+ Arrays.toString(arr));
//                System.out.println("=========================================");
            }
//            System.out.println("分组执行完毕...");
        }

        insertSort.insertSort(arr);

        System.out.println("交换法最终结果："+ Arrays.toString(arr));
    }

    /**
     *
     */
    public static void exchangeShellSort(int[] arr,int group){
        int temp = 0;
        int count = 0;
        //进行新的分组(减少分组)
        for (int k = group;k>0;k /= 2){
            //新的分组进行分组排序
            for (int i = group; i < arr.length ; i++) {
                for (int j = i - group; j >=0 ; j -= group) {
                    count = j + group;
                    if ( temp < arr[j]){
                        temp = arr[count];
                        arr[count] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }

//        insertSort.insertSort(arr);
        System.out.println("==="+Arrays.toString(arr));
    }

    public static void Move2ShellSort(int[] arr,int group){
        int temp = 0;
        int count = 0;
        for (int k = group; k > 0 ; k /= 2) {
            for (int i = group; i < arr.length ; i++) {
                count = i;
                if (arr[count] < arr[count - group]){
                    temp = arr[count];
                    while(count - group >= 0 && temp < arr[count - group]){
                        arr[count] = arr[count - group];
                        count -= group;
                    }
                    arr[count] = temp;
                }
            }
        }
    }
    /**
     * 移位法希尔排序
     * @param arr
     * @param group
     */
    public static void moveShellSort(int[] arr,int group){
        int temp = 0 ;
        int index = 0;
        for (int k = group; group > 0; group /= 2) {
//            System.out.println("分组....");
            for (int i = 0; i <group ; i++) {

                //j是一组的下一个元素的索引
                for (int j = i + group; j <= arr.length - 1; j+=group) {
                    //保存下一个元素
                    temp = arr[j];
                    //记录有序表最后一个元素的索引
                    index = j - group;
                    if (temp < arr[j-group]){
                        //从无序表中把元素插入到有序表的适当位置
                        while(index >= 0 && temp < arr[index]){
                            arr[index+group] = arr[index];
                            arr[index] = temp;
                            index-=group;
//                            System.out.println("移位操作："+ Arrays.toString(arr));
                        }
                    }
//                    System.out.println("当前分组的下一个元素移位操作："+Arrays.toString(arr));
                }
//                System.out.println("移位排序后的数组====>"+ Arrays.toString(arr));
            }
        }

//        insertSort.insertSort(arr);

//        System.out.println("移位法最终结果："+ Arrays.toString(arr));
    }
}
