package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ShellSort {
    public static void main(String[] args) {

//        int[] arr={8,9,1,7,2,3,5,4,6,0};

        int arr[]=new int[8000000];

        for(int i=0;i<8000000;i++){
            arr[i]=(int) (Math.random()*800000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1String = simpleDateFormat.format(date1);
        System.out.println("排序前的时间："+date1String);

        shellSort1(arr);

        Date date2= new Date();
        String date2String = simpleDateFormat.format(date2);
        System.out.println("排序后的时间："+date2String);
    }

    public static void shellSort(int[] arr) {
        int temp=0;
       for (int gap=arr.length/2;gap>0;gap/=2){
      for(int i=gap;i<arr.length;i++){
          for (int j=i-gap;j>=0;j-=gap){
              if(arr[j]>arr[j+gap]){
                  temp=arr[j];
                  arr[j]=arr[j+gap];
                  arr[j+gap]=temp;
              }
          }

      }
//        System.out.println("第一轮排序的结果：");
//        System.out.println(Arrays.toString(arr));
       }
      /*  for(int i=2;i<arr.length;i++){
            for (int j=i-2;j>=0;j-=2){
                if(arr[j]>arr[j+2]){
                    temp=arr[j];
                    arr[j]=arr[j+2];
                    arr[j+2]=temp;
                }
            }

        }
        System.out.println("第一轮排序的结果：");
        System.out.println(Arrays.toString(arr));

        for(int i=1;i<arr.length;i++){
            for (int j=i-1;j>=0;j-=1){
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }

        }
        System.out.println("第一轮排序的结果：");
        System.out.println(Arrays.toString(arr));*/
    }

    public static void shellSort1(int[] arr) {
        int temp=0;
        for (int gap=arr.length/2;gap>0;gap/=2){
            for(int i=gap;i<arr.length;i++){
                temp=arr[i];
                int j=i;
                while (j-gap>=0 && temp<arr[j-gap]){
                    arr[j]=arr[j-gap];
                    j-=gap;
                }
                arr[j]=temp;
            }

        }
    }
}
