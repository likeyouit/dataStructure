package com.cz.stack;


/**
 * 单链表模拟栈
 */
public class LinkedListStack {
    public static void main(String[] args) {
        SingleListStack stack = new SingleListStack();
        stack.push(new LinkedListNode(1));
        stack.push(new LinkedListNode(2));
        stack.push(new LinkedListNode(3));
        stack.pop();
        stack.showSingleListStack();
    }
}

class SingleListStack{
    LinkedListNode head = new LinkedListNode(-1);
    LinkedListNode tempNode = head;

    //使用头插法实现pop更简单
    public void push(LinkedListNode node){
        node.next = head.next;
        head.next = node;
    }

    public LinkedListNode pop(){
        if (head.next == null){
            throw new RuntimeException("栈空...");
        }
        tempNode = head.next;
        head.next = tempNode.next;
        return tempNode;
    }

    public void showSingleListStack(){
        LinkedListNode tempNode = head;
        while(true){
            if (tempNode.next == null){
                break;
            }
            System.out.println("stack::"+tempNode.next.getNo());
            tempNode = tempNode.next;
        }
    }
}

class LinkedListNode{
    int no;
    LinkedListNode next;

    public LinkedListNode(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "LinkedListNode{" +
                "no=" + no +
                '}';
    }
}
