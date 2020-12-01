package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MergeSort {
    public static void main(String[] args) {
//        int[] arr={8,4,5,7,1,3,6,2};

        int arr[]=new int[8000000];
        int[] temp=new int[arr.length];

        for(int i=0;i<8000000;i++){
            arr[i]=(int) (Math.random()*800000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1String = simpleDateFormat.format(date1);
        System.out.println("排序前的时间："+date1String);
        mergeSort(arr,0,arr.length-1,temp);
        Date date2= new Date();
        String date2String = simpleDateFormat.format(date2);
        System.out.println("排序后的时间："+date2String);
//        System.out.println("排序后的结果：");
//        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr,int left,int right,int[] temp) {
        if(left<right){
             int mid=(left+right)/2;
             mergeSort(arr,left,mid,temp);
             mergeSort(arr,mid+1,right,temp);
             merge(arr,left,right,mid,temp);
        }
    }

    public static void merge(int[] arr,int left,int right,int mid,int[] temp) {
         int i=left;
         int j=mid+1;
         int t=0;

         while (i<=mid && j<=right){
             if(arr[i]<=arr[j]){
                 temp[t]=arr[i];
                 t+=1;
                 i+=1;
             }else {
                 temp[t]=arr[j];
                 t+=1;
                 j+=1;
             }
         }

         while (i<=mid){
             temp[t]=arr[i];
             t+=1;
             i+=1;
         }
         while (j<=right){
             temp[t]=arr[j];
             t+=1;
             j+=1;
         }


         t=0;
         int tempLeft=left;
         while (tempLeft<=right){
             arr[tempLeft]=temp[t];
             tempLeft+=1;
             t+=1;
         }
    }
}
