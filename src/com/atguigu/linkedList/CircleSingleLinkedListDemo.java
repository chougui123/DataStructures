package com.atguigu.linkedList;

public class CircleSingleLinkedListDemo {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.countBoy(1,2,5);
    }


}
class CircleSingleLinkedList{
    Boy first=null;
      public void addBoy(int num){

          if(num<1){
              System.out.println("孩子太少");
              return;
          }
          Boy curBoy=null;

          for (int i=1;i<=num;i++){
              Boy boy = new Boy(i);
              if(i==1){
                  first=boy;
                  curBoy=first;
                  curBoy.setNext(first);

              }else {
                  curBoy.setNext(boy);
                  boy.setNext(first);
                  curBoy=boy;
              }
          }
      }
      public void showBoy(){
          if(first==null){
              System.out.println("没有小孩");
              return;
          }
          Boy curBoy=first;
          while (true){
              System.out.printf("孩子编号为：%d \n",curBoy.getNo());
              if(curBoy.getNext()==first){
                  break;
              }
              curBoy=curBoy.getNext();
          }
      }

      public void countBoy(int startNo,int countNum,int num){
          if(first ==null || startNo<0 || startNo>num){
              System.out.println("数据的数据有误");
              return;
          }
          Boy helper=first;
          while (true){
              if(helper.getNext()==first){
                  break;
              }
              helper=helper.getNext();
          }
          for (int i=1;i<=startNo-1;i++){
              first=first.getNext();
              helper=helper.getNext();
          }
          while (true){
              if(first==helper){
                  break;
              }
              for (int i=1;i<=countNum-1;i++){
                  first=first.getNext();
                  helper=helper.getNext();
              }
              System.out.printf("出列的小孩编号是%d \n",first.getNo());
              first=first.getNext();
              helper.setNext(first);

          }
          System.out.printf("最后的小孩编号是%d \n",first.getNo());
      }
    }

class Boy{
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
