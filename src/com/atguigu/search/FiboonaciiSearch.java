package com.atguigu.search;

import java.util.Arrays;

public class FiboonaciiSearch {
    public static int  maxSize=20;
    public static void main(String[] args) {


        int [] arr={1,8,10,89,1000,1234};
        int i = fiboonaciiSearch(arr, 1234);
        System.out.println(i);
    }

    public static int[] fib() {
         int [] f=new int[maxSize];
         f[0]=0;
         f[1]=1;
         for (int i=2;i<maxSize;i++){
             f[i]=f[i-1]+f[i-2];
         }
         return f;
    }
    public static int fiboonaciiSearch(int[] arr,int value){
        int low=0;
        int high=arr.length-1;
        int mid=0;
        int k=0;
        int f[]=fib();
        while (high>f[k]-1){
            k++;
        }
        int[] temp= Arrays.copyOf(arr,f[k]-1);
        for (int i=high+1;i<temp.length;i++){
            temp[i]=arr[high];
        }

        while (high>=low){
          mid=low+f[k-1]-1;
          if(value<arr[mid]){
              high=mid-1;
              k--;

          }else if(value>arr[mid]){
              low=mid+1;
              k-=2;
          }else {
              if(mid<=high){
                  return mid;
              }else {
              return high;}
          }


        }
        return -1;
    }
}
