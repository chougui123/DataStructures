package com.atguigu.linkedList;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode2 heroNode1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 heroNode2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 heroNode3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 heroNode4 = new HeroNode2(4, "林冲", "豹子头");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode3);
        doubleLinkedList.add(heroNode4);
        doubleLinkedList.show();
        HeroNode2 newHeroNode = new HeroNode2(5, "林冲冲冲", "豹子头头");
        doubleLinkedList.addByOrder(newHeroNode);
        System.out.println("顺序添加后的链表：");
        doubleLinkedList.show();
//        doubleLinkedList.delete(3);
//        System.out.println("删除后的链表：");
//        doubleLinkedList.show();

    }
}

    class DoubleLinkedList{
        private HeroNode2 head= new HeroNode2(0,"","");
        public HeroNode2 getHead() {
            return head;
        }

        public void addByOrder(HeroNode2 heroNode){
            HeroNode2 temp=head;
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

                heroNode.pre=temp;
                heroNode.next=temp.next;


                    temp.next=heroNode;
                temp.next.pre=heroNode;


            }

        }
        public void delete(int no){
            if(head.next ==null){
                System.out.println("链表为空");
                return;
            }
            HeroNode2 temp =head.next;
            Boolean flag=false;
            while (true){
                if(temp==null){
                    break;
                }
                if (temp.no==no){
                    flag=true;
                    break;
                }
                temp=temp.next;
            }
            if(flag){
                 temp.pre.next=temp.next;
                 if(temp.next!=null){
                     temp.next.pre=temp.pre;
                 }
            }else {
                System.out.printf("没有编号为%d的英雄\n",no);
            }
        }

        public void update(HeroNode2 newHeroNode){
            if(head.next==null){
                System.out.println("链表为空");
                return;
            }
            HeroNode2 temp=head.next;
            Boolean flag=false;
            while (true){
                if(temp ==null){
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

        public void add(HeroNode2 heroNode){
            HeroNode2 temp=head;
            while (true) {
                if (temp.next == null) {
                    temp.next = heroNode;
                    heroNode.pre=temp;
                    break;
                }
                temp = temp.next;
            }
        }
        public void show(){
            if(head.next==null){
                System.out.println("链表为空");
                return;
            }
            HeroNode2 temp=head;

            while (true){
                if (temp.next==null){
                    break;
                }
                System.out.println(temp.next);
                temp=temp.next;
            }
        }
    }

    class HeroNode2{
        public int no;
        public String name;
        public String nickName;
        public HeroNode2 next;
        public HeroNode2 pre;

        public HeroNode2(int no, String name, String nickName ) {
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
