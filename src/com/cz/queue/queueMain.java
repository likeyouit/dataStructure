package com.cz.queue;

/**
 *模拟数组队列
 */
public class queueMain {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.addQueue(1);
        arrayQueue.addQueue(2);
        arrayQueue.showQueue();
        System.out.println();
        System.out.println("队列的头数据："+arrayQueue.getQueue());
        System.out.println("队列的头数据："+arrayQueue.getQueue());
        System.out.println("队列的头数据："+arrayQueue.getQueue());
        System.out.println("队列的头数据："+arrayQueue.getQueue());
        System.out.println("队列的头数据："+arrayQueue.getQueue());
        System.out.println("队列的头数据："+arrayQueue.getQueue());
    }
}

class ArrayQueue{
    private int maxSize; //数组的最大容量
    private int front;  //队列头
    private int rear;  //队列尾
    private int[] arr;  //该数据用于存放数据，模拟队列

    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; //指向队列头部，分析出front是指向队列头的前一个位置
        rear = -1;  //指向队列尾，指向队列尾的数据
    }

    //判断队列是否满
    public boolean isFull(){
        return rear == maxSize-1;
    }

    //判断队列是否空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列满.....");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    //显示队列的头数据
    public int getQueue(){
        if (isEmpty()){
            System.out.println("队列为空.....");
            throw new RuntimeException("队列空，无数据");
        }
        front++;
        int headData = arr[front];
        if (front == rear){
            front = -1;
        }
        return headData;
    }

    //显示队列的所有数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列没有数据");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\t",i,arr[i]);
        }
    }
}
