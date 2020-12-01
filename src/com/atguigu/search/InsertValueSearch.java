package com.atguigu.search;

public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr=new int[100];
        for(int i=0;i<arr.length;i++){
            arr[i]=i+1;
        }
        int index = insertValueSearch(arr, 0, arr.length - 1, 44);
        System.out.println(index);
    }
    public static int insertValueSearch(int[] arr,int left,int right,int value){
        System.out.println("调用次数");
        if(left>right || value<arr[0] || value>arr[arr.length-1]){
            return -1;
        }
        int mid=left+(right-left)*(value-arr[left])/(arr[right]-arr[left]);
        if(value<arr[mid]){
            return insertValueSearch(arr,left,mid-1,value);
        }else if(value>arr[mid]){
            return insertValueSearch(arr,mid+1,right,value);
        }else {
            return mid;
        }

    }
}
