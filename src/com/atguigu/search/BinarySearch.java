package com.atguigu.search;

import java.util.ArrayList;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={1,8,10,89,1000,1000,1000,1234};
        ArrayList<Integer> list = binarySearch2(arr, 0, arr.length - 1, 1000);
        System.out.println(list);
//        int i = binarySearch(arr, 0, arr.length - 1, 64);
//        System.out.println(i);
    }
    public static int binarySearch(int[] arr,int left,int right,int value){
        if(left > right){
            return -1;
        }
        int mid=(left+right)/2;
        if(value<arr[mid]){
            return binarySearch(arr,left,mid-1,value);
        }else if(value>arr[mid]){
            return binarySearch(arr,mid+1,right,value);
        }else {
            return mid;
        }
    }


    public static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int value){
        if(left > right){
            return new ArrayList<Integer>();
        }
        int mid=(left+right)/2;
        if(value<arr[mid]){
            return binarySearch2(arr,left,mid-1,value);
        }else if(value>arr[mid]){
            return binarySearch2(arr,mid+1,right,value);
        }else {
            ArrayList<Integer> list = new ArrayList<>();
            int temp=mid-1;
            while (true){
                if(temp<0 || arr[temp] !=value){
                    break;
                }
                list.add(temp);
                temp-=1;
            }
            list.add(mid);
            temp=mid+1;
            while (true){
                if(temp>arr.length-1 || arr[temp] !=value){
                    break;
                }
                list.add(temp);
                temp+=1;
            }
            return list;
        }
    }
}
