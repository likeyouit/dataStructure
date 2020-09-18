package com.cz.linkedList;

import java.util.Stack;

/**
 * 单向链表
 */
public class SingleLinkedList {
    public static void main(String[] args) {
        SingleLinkedListDemo demo = new SingleLinkedListDemo();
        demo.addNode(new HeroNode(1,"宋江","及时雨"));
        demo.addNode(new HeroNode(2,"李逵","黑旋风"));
        demo.addNode(new HeroNode(3,"张顺","浪里白条"));
        demo.addNode(new HeroNode(4,"林冲","豹子头"));
        demo.addNode(new HeroNode(5,"吴用","智多星"));

        demo.showSingleLinkedList();

        HeroNode node2 = new HeroNode(1,"11","11");
        HeroNode h2 = new HeroNode(2,"22","22");
        HeroNode h3 = new HeroNode(3,"33","33");
        HeroNode h4 = new HeroNode(4,"44","44");
        HeroNode h5 = new HeroNode(5,"55","55");

        node2.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
//        demo.updateNode(new HeroNode(6,"林冲","豹子头"));
//        demo.addNodeByNo(new HeroNode(3,"宋江","及时雨"));
//        demo.addNodeByNo(new HeroNode(3,"吴用","智多星"));
//        demo.deleteNode(5);
        System.out.println("===================================");
        //Tecent
//        SingleLinkedListDemo.temp = SingleLinkedListDemo.head;
//        HeroNode node = demo.reverseLinkedList(SingleLinkedListDemo.temp);
//        System.out.println("反转后的链表："+node);

        //Baidu
        //1
//          demo.descPrintLinkedList(SingleLinkedListDemo.head);
        //2
//          demo.descPrintList(SingleLinkedListDemo.head);

        //practice：merge LinkedList
          HeroNode node1 = SingleLinkedListDemo.head;
//          HeroNode node2 = SingleLinkedListDemo.head;

        HeroNode tempNode = demo.mergeTwoLinkedList(node1,node2);
          demo.descPrintList(tempNode);
//        System.out.println(demo.getNode(5));
//        demo.showSingleLinkedList();
    }
}

class SingleLinkedListDemo{
    static HeroNode head = new HeroNode(0,"","");

//    static HeroNode h2 = new HeroNode(0,"","");
    static HeroNode temp = head;
    //向单链表添加节点
    public void addNode(HeroNode nextNode){
        while(true){
            if (temp.next == null){
                temp.next = nextNode;
                break;
            }
            temp = temp.next;
        }
    }

    //根据编号顺序添加
    public void addNodeByNo(HeroNode nextNode){

        temp = head;
        boolean flag = false;
        while(true){
            if (temp.next == null){
                temp.next = nextNode;
                return;
            }else if (nextNode.no == temp.next.no){
                flag = true;
                break;
            }else if (nextNode.no < temp.next.no){
                //找到插入的位置
                break;
            }
            temp = temp.next;
        }
        if (flag){
            System.out.println("编号已存在");
        }else{
            nextNode.next = temp.next;
            temp.next = nextNode;
        }
    }

    //修改node信息
    public void updateNode(HeroNode newHeroNode){
        temp = head;
        while(true){
            if (temp.next == null){
                System.out.println("没有这个数据...");
                return;
            }else if (temp.next.no == newHeroNode.no){
                temp.next.name = newHeroNode.name;
                temp.next.nickName = newHeroNode.nickName;
                System.out.println("修改完成！！！");
                break;
            }else{
                temp = temp.next;
            }
        }
    }

    //删除节点
    public void deleteNode(int no){
        temp = head;
        while(true){
            if (temp.next == null){
                System.out.println("没有你要找的编号.....");
                break;
            }else if (temp.next.no == no){
                //如果要删除的节点是最后一个节点,temp.next.next = null
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }

    //新浪面试:查找单链表中的倒数第k个节点
    public HeroNode getNode(int k){
        temp = head;
        int size = getLength(head);
        if (k <= 0 || k > size){
            return null;
        }
        for (int i = 0; i < size - k; i++) {
            temp = temp.next;
        }
        return temp.next;
    }

    //单链表的有效节点个数
    public int getLength(HeroNode head){
        int n = 0;
        while(true){
            if (head.next == null){
                return n;
            }
            head = head.next;
            n++;
        }
    }

    //腾讯面试：反转单链表(头插法实现)
    public  HeroNode reverseLinkedList(HeroNode head){
        HeroNode temp = head;

        //反转之后的链表头节点
        HeroNode reverseNode = new HeroNode(0,"rr","rr");
        //临时链表
        HeroNode reversetemp = new HeroNode(0,"tt","tt");

        if (temp.next == null || temp.next.next ==null){
            return temp;
        }


        while(true){
            if (temp.next == null){
                break;
            }

            reverseNode.next = temp.next;
            temp.next = temp.next.next;
            //3 头插操作
            reverseNode.next.next = reversetemp.next;
            //4 临时保存反转链表
            reversetemp.next = reverseNode.next;


        }

        temp.next = reverseNode.next;
        return temp;
    }

    //百度面试： 逆序打印单链表(1.递归 2.栈实现【要求】)
    //递归实现
    public void descPrintLinkedList(HeroNode head){
        if (head.next != null){
            descPrintLinkedList(head.next);
            System.out.println(head.next+"\t");
        }else{
            System.out.println("print finished!!!");
        }
    }

    //栈实现
    public void descPrintList(HeroNode head){
        HeroNode temp = head;
        HeroNode heroNode = null;
        if (head.next == null){
            System.out.println("链表为空...");
            return;
        }
        Stack<HeroNode> stack = new Stack<>();
        while (true){
            if (temp.next == null){
                break;
            }
            stack.push(temp.next);
            temp = temp.next;
        }
        int stackSize = stack.size();
        for (int i = 0; i < stackSize; i++) {
            System.out.println(stack.pop());
        }
    }

    //练习：合并两个有序链表(使用的第三个链表添加节点，在原链表删除节点的方式实现)
    public HeroNode mergeTwoLinkedList(HeroNode heroNode1,HeroNode heroNode2){
        if (heroNode1.next == null){
            return heroNode2;
        }
        if (heroNode2.next == null){
            return heroNode1;
        }
        int node1Size = getLength(heroNode1);
        int node2Size = getLength(heroNode2);

        HeroNode tempLong = heroNode1;
        HeroNode tempShort = heroNode2;
        HeroNode tempNode = new HeroNode(0,"nn","nn");
        HeroNode head = tempNode;

        //移动长度短的链表的节点
        if (node1Size < node2Size){
            tempLong = heroNode2;
            tempShort = heroNode1;
        }
        while(true){
            if (tempLong.next == null){
                //长链表走完，把短链表剩下的部分接到长链表后面
                //******
                tempNode.next = tempShort.next;
                //******
                return head;
            }
            if(tempShort.next == null){
                //短链表走完，直接返回长链表
                return head;
            }
            if (tempLong.next.no >= tempShort.next.no){
                tempNode.next = tempShort.next;
                tempShort.next =  tempShort.next.next;
                tempNode.next.next = null;
            }else{
                tempNode.next = tempLong.next;
                tempLong.next = tempLong.next.next;
                tempNode.next.next = null;
            }
            tempNode = tempNode.next;
        }
    }

    //遍历单链表
    public void showSingleLinkedList(){
        temp = head;
        while(true){
            if (temp.next == null){
                break;
            }
            System.out.println(temp.next);
            temp = temp.next;
        }
    }
}

class HeroNode{
    int no;
    String name;
    String nickName;
    HeroNode next;

    public HeroNode(int no,String name,String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
//                ", next='" + next + '\'' +
                '}';
    }
}