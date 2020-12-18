package com.atguigu.tree;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HeapSort {
    public static void main(String[] args) {
//        int[] arr={4,6,8,5,9};
        int arr[]=new int[8000000];

        for(int i=0;i<8000000;i++){
            arr[i]=(int) (Math.random()*800000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1String = simpleDateFormat.format(date1);
        System.out.println("排序前的时间："+date1String);
        heapSort(arr);

        Date date2= new Date();

        String date2String = simpleDateFormat.format(date2);
        System.out.println("排序后的时间："+date2String);
    }

    public static void heapSort(int[] arr){
        System.out.println("堆排序：");

        for(int i=arr.length/2-1;i>=0;i--){
           adjustHeap(arr,i,arr.length);
        }

        for (int j=arr.length-1;j>0;j--){
            int temp=arr[j];
            arr[j]=arr[0];
            arr[0]=temp;
            adjustHeap(arr,0,j);
        }
//        System.out.println("排序后的数组："+ Arrays.toString(arr));
    }

    public static void adjustHeap(int[] arr,int i,int length){
          int temp=arr[i];

          for(int k=i*2+1;k<length;k=k*2+1){
              if(k+1<length && arr[k]<arr[k+1]){
                  k++;
              }
              if(temp<arr[k]){
                  arr[i] = arr[k];
                  i=k;
              }else {
                  break;
              }

          }
          arr[i]=temp;
    }
}
