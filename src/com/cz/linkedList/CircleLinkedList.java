package com.cz.linkedList;

/**
 * 环形链表,约瑟夫问题
 */
public class CircleLinkedList {
    public static void main(String[] args) {
        CircleLinkedListDemo demo = new CircleLinkedListDemo();
        demo.createJoSephuCircle(125);
        demo.showCircleList(CircleLinkedListDemo.first);
        demo.outCircle(CircleLinkedListDemo.first,20,10);
    }


}

class CircleLinkedListDemo{
    static CircleNode first = new CircleNode(1);
    CircleNode curNode = first;

    //创建环形链表
    public void createJoSephuCircle(int nums){
        if (nums < 1 ){
            System.out.println("链表长度至少为1....");
            return;
        }

        //第一个节点已经被创建
        for (int i = 2; i <= nums; i++) {
            if (nums == 1 ){
                first.setNext(first);
            }else{
                curNode.next = new CircleNode(i);
                curNode = curNode.next;
                curNode.next = first;
            }
        }
    }

    //遍历环形链表
    public void showCircleList(CircleNode first){
        if (first == null){
            System.out.println("空链表...");
            return;
        }
        CircleNode tempNode = first;

        while(true){
            if (tempNode.getNext() == first){
                System.out.println("遍历完了....");
                break;
            }else{
                System.out.println(tempNode.next);
                tempNode = tempNode.next;
            }
        }
    }

    //出圈

    /**
     *
     * @param first 环
     * @param move 移动次数
     * @param startNo 第几个小孩开始数
     */
    public void outCircle(CircleNode first,int move,int startNo){
        if (first == null || move < 1 || startNo < 1){
            System.out.println("输入参数有误....");
            return;
        }
        //辅助指针
        CircleNode helper = first;
        while(true){
            if (helper.getNext() == first){
                break;
            }
            helper = helper.next;
        }
        //起始移动的节点
        for (int i = 0; i < startNo - 1 ; i++) {
            first = first.next;
            helper = helper.next;
        }

        //报数
        while(true){
            if (helper == first) {
                //环中只有一个节点
                break;
            }
            for (int i = 0; i < move - 1; i++) {
                first = first.next;
                helper = helper.next;
            }
            System.out.println("出环："+ first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后留在环中的节点："+first.getNo());

    }
}

class CircleNode{
    int no;
    CircleNode next;

    public CircleNode(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public CircleNode getNext() {
        return next;
    }

    public void setNext(CircleNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "CircleNode{" +
                "no=" + no +
                '}';
    }
}