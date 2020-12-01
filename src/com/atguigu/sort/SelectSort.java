package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SelectSort {
    public static void main(String[] args) {
        int arr[]=new int[80000];

        for(int i=0;i<80000;i++){
            arr[i]=(int) (Math.random()*80000);
        }


        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1String = simpleDateFormat.format(date1);
        System.out.println("排序前的时间："+date1String);
        slectSort(arr);
        Date date2= new Date();

        String date2String = simpleDateFormat.format(date2);
        System.out.println("排序后的时间："+date2String);
    }

    public static void slectSort(int[] arr) {

        for(int i=0;i<arr.length-1;i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if(minIndex!=i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }



       /* min=arr[1];
        minIndex=1;
        for (int j=1+1;j<arr.length;j++){
            if(min>arr[j]){
                min=arr[j];
                minIndex=j;
            }
        }
        arr[minIndex]=arr[1];
        arr[1]=min;
        System.out.println("第二次排序后：");
        System.out.println(Arrays.toString(arr));

         min=arr[2];
         minIndex=2;
        for (int j=2+1;j<arr.length;j++){
            if(min>arr[j]){
                min=arr[j];
                minIndex=j;
            }
        }
        arr[minIndex]=arr[2];
        arr[2]=min;
        System.out.println("第三次排序后：");
        System.out.println(Arrays.toString(arr));*/
            }
        }
}
