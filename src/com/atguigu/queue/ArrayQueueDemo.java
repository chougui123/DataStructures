package com.atguigu.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {

        ArrayQueue queue = new ArrayQueue(3);
        char key=' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop=true;
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("a(add):增加队列");
            System.out.println("g(get):从队列取出");
            System.out.println("h(head):显示队列头");
            System.out.println("e(exit):退出程序");
            key=scanner.next().charAt(0);
            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    int value=scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'h':
                    try {
                        int i = queue.headQueue();
                        System.out.printf("队列头的数据为%d\n",i);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        int i = queue.getQueue();
                        System.out.printf("取出的数据为%d\n",i);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop=false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出了");
    }
}
class ArrayQueue{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int arrMaxSize){
        maxSize=arrMaxSize;
        arr=new int[maxSize];
        front=-1;
        rear=-1;
    }

    public boolean isEmpty(){
       return front==rear;
    }

    public boolean isFull(){
        return rear==maxSize-1;
    }

    public void addQueue(int n){
       if(isFull()){
           System.out.println("队列已满");
           return;
       }
       rear++;
       arr[rear]=n;
    }

    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("空队列");
        }
        front++;
        return arr[front];
    }

    public void showQueue(){
        if(isEmpty()){
            System.out.println("空队列");

            return;
        }
        for (int i=0;i<arr.length;i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("空队列");
        }
        return arr[front+1];
    }

}