package com.atguigu.hashTab;

import java.util.Scanner;

public class HashTabDemo {
    public static void main(String[] args) {

        HashTab hashTab = new HashTab(7);
        String key="";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出程序");

            key=scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id=scanner.nextInt();
                    System.out.println("输入名字");
                    String name=scanner.next();
                    Emp emp = new Emp(id,name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("输入id");
                    id=scanner.nextInt();
                    hashTab.findById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
            }
        }

    }
}
class HashTab{
    private EmpLinkedList[] empLinkedListArray;
    private int size;
    public HashTab(int size) {
        this.size=size;
        empLinkedListArray=new EmpLinkedList[size];
        for (int i=0;i<size;i++){
            empLinkedListArray[i]=new EmpLinkedList();
        }
    }
    public int hashFun(int id){
        return  id % size;
    }

    public void add(Emp emp){
        int empLinkedListNo = hashFun(emp.id);
        empLinkedListArray[empLinkedListNo].add(emp);
    }

    public void list(){
        for (int i=0;i<size;i++){
            empLinkedListArray[i].list(i);

        }
    }
    public void findById(int id){
        int empLinkedListNo = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNo].findById(id);

        if(emp == null){
            System.out.println("没有找到");
        }else {
            System.out.printf("在第%d条链表中找到，name=%s \n",(empLinkedListNo+1),emp.name);
        }
    }

}
class EmpLinkedList{
    private Emp head;

    public void add(Emp emp){
        if(head == null){
            head=emp;
            return;
        }
        Emp curEmp=head;
        while (true){
            if(curEmp.next == null){
                break;
            }
            curEmp=curEmp.next;
        }
        curEmp.next=emp;
    }

    public void list(int no){
        if(head==null){
            System.out.println("第"+(no+1)+"链表为空");
            return;
        }
        System.out.print("第"+(no+1)+"链表信息为：");
        Emp curEmp=head;
        while (true){
            System.out.printf("=> id=%d name=%s\t",curEmp.id,curEmp.name);
            if(curEmp.next==null){
                break;
            }
            curEmp=curEmp.next;
        }
        System.out.println();
    }

    public Emp findById(int id){
        if(head == null){
            System.out.println("链表为空");
            return null;
        }
        Emp curEmp=head;
        while (true){
            if(curEmp.id == id){
                break;
            }
            if(curEmp.next==null){
                curEmp=null;
                break;
            }
            curEmp=curEmp.next;

        }
       return curEmp;
    }
}


class Emp{
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
