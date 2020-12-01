package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QuickSort {
    public static void main(String[] args) {
//    int [] arr={-3,-9,45,0,-655,4,76,68,-5,-556,3,56,5,45,76,-5,-35};
        int arr[]=new int[8000000];

        for(int i=0;i<8000000;i++){
            arr[i]=(int) (Math.random()*800000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1String = simpleDateFormat.format(date1);
        System.out.println("排序前的时间："+date1String);
        quickSort(arr,0,arr.length-1);

        Date date2= new Date();
        String date2String = simpleDateFormat.format(date2);
        System.out.println("排序后的时间："+date2String);
//        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr,int left,int right) {
       int l=left;
       int r=right;
       int pivot=arr[(left+right)/2];
       int temp=0;

       while (l<r){

           while (arr[l]<pivot){
               l+=1;
           }
           while (arr[r]>pivot){
               r-=1;
           }
           if(l>=r){
               break;
           }
           temp=arr[l];
           arr[l]=arr[r];
           arr[r]=temp;

           if(pivot==arr[l]){
               r-=1;
           }
           if(pivot==arr[r]){
               l+=1;
           }
       }
       if(l==r){
           l+=1;
           r-=1;
       }
       if(left<r){
           quickSort(arr,left,r);
       }
       if(right>l){
           quickSort(arr,l,right);
       }


    }


}
