package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {
    public static void main(String[] args) {
//         int [] arr={101,34,119,-1,4,5,8,84,3,7,3,2};
        int arr[]=new int[80000];

        for(int i=0;i<80000;i++){
            arr[i]=(int) (Math.random()*800000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1String = simpleDateFormat.format(date1);
        System.out.println("排序前的时间："+date1String);
         insertSort(arr);
        Date date2= new Date();

        String date2String = simpleDateFormat.format(date2);
        System.out.println("排序后的时间："+date2String);
    }

    public static void insertSort(int[] arr) {
       for(int i=1;i<arr.length;i++) {
           int insertValue = arr[i];
           int insertIndex = i - 1;

           while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
               arr[insertIndex + 1] = arr[insertIndex];
               insertIndex--;
           }
           if(insertIndex != i-1 ){
               arr[insertIndex + 1] = insertValue;
           }

           System.out.println("第"+i+"轮结果：");
           System.out.println(Arrays.toString(arr));

       }
    /*      insertValue=arr[2];
          insertIndex=2-1;

        while (insertIndex>=0 && insertValue<arr[insertIndex] ){
            arr[insertIndex+1]=arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex+1]=insertValue;
        System.out.println("第二轮结果：");
        System.out.println(Arrays.toString(arr));

        insertValue=arr[3];
        insertIndex=3-1;

        while (insertIndex>=0 && insertValue<arr[insertIndex] ){
            arr[insertIndex+1]=arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex+1]=insertValue;
        System.out.println("第三轮结果：");
        System.out.println(Arrays.toString(arr));*/
    }
}
