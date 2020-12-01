package com.atguigu.linkedList;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {


        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode2);
        System.out.println("原来的链表：");
        singleLinkedList.show();
        System.out.println("逆序输出的链表：");
        reversePrint(singleLinkedList.getHead());
//        reverseList(singleLinkedList.getHead());
//        System.out.println("反转后的链表：");
//        singleLinkedList.show();
//        HeroNode newHeroNode = new HeroNode(3, "小吴", "小智多星");
//        singleLinkedList.update(newHeroNode);
//        System.out.println("修改后的单链表为：");
//        singleLinkedList.show();
//        singleLinkedList.delete(2);

//        System.out.println("删除后的单链表为：");
//        singleLinkedList.show();
//
//        System.out.printf("单链表的节点数为%d\n",getLength(singleLinkedList.getHead()));
//
//        System.out.println("倒数"+getLastIndexNode(singleLinkedList.getHead(),1));
    }

    public static void reversePrint(HeroNode head){
        if(head.next ==null){
            return;
        }
        HeroNode cur=head.next;
        Stack<HeroNode> stack = new Stack<>();
        while (cur !=null){
            stack.push(cur);
            cur=cur.next;
        }
        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }


    public static void reverseList(HeroNode head){
        if(head.next==null || head.next.next==null){
            return;
        }
        HeroNode cur=head.next;
        HeroNode next=null;
        HeroNode reverseHead = new HeroNode(0,"","");
        while (cur!=null){
            next=cur.next;
            cur.next=reverseHead.next;
            reverseHead.next=cur;
            cur=next;
        }
        head.next=reverseHead.next;
    }


    public static int getLength(HeroNode head){
        int length=0;
        if(head.next==null){
            return 0;
        }
        HeroNode cur=head;
        while (cur.next!=null){
           length++;
           cur=cur.next;
        }
        return length;
    }

    public static HeroNode getLastIndexNode(HeroNode head,int index){
        if(head.next==null){
            return null;
        }
        int size = getLength(head);
        HeroNode cur=head.next;
        if(index<=0 || index>size){
            return null;
        }
        for(int i=0;i<size-index;i++){
            cur=cur.next;
        }
        return cur;
    }
}



class SingleLinkedList{
  private HeroNode head= new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

    public void add(HeroNode heroNode){
      HeroNode temp=head;
      while (true) {
          if (temp.next == null) {
              temp.next = heroNode;
              break;
          }
          temp = temp.next;
      }
  }

  public void addByOrder(HeroNode heroNode){
      HeroNode temp=head;
      Boolean flag=false;
      while (true){
          if(temp.next == null){
              break;
          }
          if (temp.no ==heroNode.no){
              flag =true;
              break;
          }else if(temp.next.no>heroNode.no){
            break;
          }
          temp=temp.next;
      }

      if(flag){
          System.out.printf("插入的英雄%d已存在\n",temp.no);
      }else {
          heroNode.next=temp.next;
          temp.next=heroNode;
      }

  }

  public void update(HeroNode newHeroNode){
      if(head.next==null){
          System.out.println("链表为空");
          return;
      }
      HeroNode temp=head;
      Boolean flag=false;
      while (true){
          if(temp.next==null){
              break;
          }
          if(temp.no==newHeroNode.no){
              flag=true;
              break;
          }
          temp=temp.next;
      }
      if(flag){
          temp.name=newHeroNode.name;
          temp.nickName=newHeroNode.nickName;
      }else {
          System.out.printf("没有编号为%d的英雄\n",newHeroNode.no);
      }
  }

  public void delete(int no){
      if(head.next ==null){
          System.out.println("链表为空");
          return;
      }
      HeroNode temp =head;
      Boolean flag=false;
      while (true){
          if(temp.next==null){
              break;
          }
          if (temp.next.no==no){
              flag=true;
              break;
          }
          temp=temp.next;
      }
      if(flag){
          temp.next=temp.next.next;
      }else {
          System.out.printf("没有编号为%d的英雄\n",no);
      }
  }
  public void show(){
      if(head.next==null){
          System.out.println("链表为空00");
          return;
      }
      HeroNode temp=head;
      while (true){
          if (temp.next==null){
           break;
          }
          System.out.println(temp.next);
          temp=temp.next;
      }
  }

}


class HeroNode{
    public int no;
    public String name;
    public String nickName;
    HeroNode next;

    public HeroNode(int no, String name, String nickName ) {
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

                '}';
    }
}