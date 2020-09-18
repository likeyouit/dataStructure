package com.cz.stack;


/**
 * 数组模拟栈
 */
public class ArrayStack {
    public static void main(String[] args) {
        ArrStack arrStack = new ArrStack(4);
        arrStack.push(1);
        arrStack.push(2);
        arrStack.push(1);
        arrStack.push(2);
        arrStack.pop();
        arrStack.push(3);
        arrStack.showArrStack();

    }
}

class ArrStack{
    int top = -1;  //索引值
    int[] stack;  //存放数据
    int maxSize;  //栈容量

    public ArrStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public boolean isFull(){
        return top == this.maxSize - 1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int value){
        if (isFull()){
            System.out.println("栈满...");
            return;
        }
        stack[++top] = value;
    }

    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空..");
        }
        return stack[top--];
    }

    public void showArrStack(){
        for (int i = top; i >= 0 ; i--) {
            System.out.println("stack::"+stack[i]);
        }
    }
}
