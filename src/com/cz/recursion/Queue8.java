package com.cz.recursion;

/**
 * 八皇后
 */
public class Queue8 {

    static int max = 8;
    static int[] queue = new int[max];
    static int sum = 0;
    public static void main(String[] args) {
        putQueue(0);
        System.out.println("有"+sum+"种解法...");
    }

    /**
     * 放置第n个皇后:0<n<8
     */
    public static void putQueue(int n){
        if (n == max){
            //8个皇后已经放好了,已经有了一种解法
            print();
            sum++;
            return;
        }

        for (int i = 0; i < max; i++) {
            queue[n] = i;
            //如果有冲突
            if (!judge(n)){
                putQueue(n+1);
            }
        }
    }

    /**
     * 判断第n个皇后与之前的皇后是否冲突
     * @param n
     * @return
     */
    public static boolean judge(int n){
        for (int i = 0; i <n ; i++) {
            //与之前的皇后在同一列或者在同一斜线上
            if (queue[n] == queue[i] || Math.abs(n - i ) == Math.abs(queue[n] - queue[i])){
                return true;
            }
        }
        return false;
    }

    public static void print(){
        for (int i = 0; i < max; i++) {
            System.out.print(queue[i]+" ");
        }
        System.out.println();
    }
}
