package com.atguigu.search;

public class SeqSearch {
    public static void main(String[] args) {
        int [] arr={1,2,4,56,34,76,-4};
        int index = seqSearch(arr, 34);
        if(index == -1){
            System.out.println("没有找到");
        }else {
            System.out.println("找到下标为"+index);
        }
    }
    public static int seqSearch(int[] arr,int value){
        for (int i=0;i<arr.length;i++){
            if(arr[i] == value){
                return i;
            }
        }
        return -1;
    }
}
