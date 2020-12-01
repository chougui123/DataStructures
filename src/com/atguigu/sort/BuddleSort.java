package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BuddleSort {
    public static void main(String[] args) {
        int arr[]=new int[80000];

        for(int i=0;i<80000;i++){
            arr[i]=(int) (Math.random()*80000);
        }


        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1String = simpleDateFormat.format(date1);
        System.out.println("排序前的时间："+date1String);
        bubble(arr);
        Date date2= new Date();

        String date2String = simpleDateFormat.format(date2);
        System.out.println("排序后的时间："+date2String);

      /*  for (int j=0;j<arr.length-1-1;j++){
            if(arr[j]>arr[j+1]){
                temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }

        }
        System.out.println("第二次排序后的结果：");
        System.out.println(Arrays.toString(arr));

        for (int j=0;j<arr.length-1-2;j++){
            if(arr[j]>arr[j+1]){
                temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }

        }
        System.out.println("第三次排序后的结果：");
        System.out.println(Arrays.toString(arr));

        for (int j=0;j<arr.length-1-3;j++){
            if(arr[j]>arr[j+1]){
                temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }

        }
        System.out.println("第四次排序后的结果：");
        System.out.println(Arrays.toString(arr));*/
    }

    public static void bubble(int[] arr) {
        int temp;
        boolean flag=false;
        for(int i=0;i<arr.length-1;i++){
            for (int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    flag=true;
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }

            if(!flag){
                break;
            }else {
                flag=false;
            }
        }
    }
}
