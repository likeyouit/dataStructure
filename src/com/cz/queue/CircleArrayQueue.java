package com.cz.queue;

/**
 * 环形数组队列
 */
public class CircleArrayQueue {
    public static void main(String[] args) {
        CircleArray circleArray = new CircleArray(3);
        circleArray.addQueue(1);
        circleArray.addQueue(2);

        circleArray.showQueue();
        System.out.println();
        System.out.println("队列的头数据："+circleArray.getQueue());
        System.out.println("队列的头数据："+circleArray.getQueue());
        circleArray.addQueue(3);
//        System.out.println("队列的头数据："+circleArray.getQueue());
        circleArray.showQueue();
//        System.out.println("队列的头数据："+circleArray.getQueue());
//        System.out.println("队列的头数据："+circleArray.getQueue());
//        System.out.println("队列的头数据："+circleArray.getQueue());
    }
}

class CircleArray{
    private int maxSize; //数组的最大容量
    private int front;  //指向队列的第一个数据
    private int rear;  //指向队列最后一个数据的后一个位置
    private int[] arr;  //该数据用于存放数据，模拟队列

    public CircleArray(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }
    //判断队列是否满
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否空
    public boolean isEmpty(){
        return rear == front;
    }

    //队列的有效数据
    public int effictivData(){
        return (rear - front + maxSize) % maxSize;
    }

    //添加数据到队列
    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列满.....");
            return;
        }
        arr[rear] = n;
        //rear后移，考虑取模
        rear = (rear + 1) % maxSize;
    }

    //显示队列的头数据
    public int getQueue(){
        if (isEmpty()){
            System.out.println("队列为空.....");
            throw new RuntimeException("队列空，无数据");
        }

        int headData = arr[front];
        front = (front + 1)% maxSize;
        return headData;
    }

    //显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列没有数据");
        }
        for (int i = front; i < front + effictivData(); i++) {
            System.out.printf("arr[%d] = %d\t", i % maxSize, arr[i % maxSize]);
        }
    }
}
