package com.atguigu.tree;

public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
     int[] arr={};
        ArrBinaryTree binaryTree = new ArrBinaryTree(arr);
        binaryTree.preArrBinaryTree(0);
    }
}
class ArrBinaryTree{
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preArrBinaryTree(int index){

        if(arr == null || arr.length == 0){
            System.out.println("数组二叉树为空");
            return;
        }
        System.out.println(arr[index]);

        if((index*2+1) < arr.length){
          preArrBinaryTree((index*2+1));
        }

        if((index*2+2) < arr.length){
            preArrBinaryTree((index*2+2));
        }

    }
}
