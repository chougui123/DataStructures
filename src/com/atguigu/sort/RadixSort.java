package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RadixSort {
    public static void main(String[] args) {
//        int[] arr={53,3,542,748,15,214};
        int arr[]=new int[8000000];
        int[] temp=new int[arr.length];

        for(int i=0;i<8000000;i++){
            arr[i]=(int) (Math.random()*800000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1String = simpleDateFormat.format(date1);
        System.out.println("排序前的时间："+date1String);
        radixSort(arr);
        Date date2= new Date();
        String date2String = simpleDateFormat.format(date2);
        System.out.println("排序后的时间："+date2String);

    }

    public static void radixSort(int[] arr) {


        int max=arr[0];
        for (int i=1;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        int maxSize=(max+"").length();


        int [][] bucket =new int[10][arr.length];
        int [] bucketElementCounts=new int[10];

       for (int i=0,n=1;i<maxSize;i++,n*=10) {
           for (int j = 0; j < arr.length; j++) {
               int digitOfElement = arr[j] / n % 10;
               bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
               bucketElementCounts[digitOfElement]++;
           }
           int index = 0;
           for (int k = 0; k < bucketElementCounts.length; k++) {
               if (bucketElementCounts[k] != 0) {
                   for (int l = 0; l < bucketElementCounts[k]; l++) {
                       arr[index] = bucket[k][l];
                       index++;
                   }
               }
               bucketElementCounts[k] = 0;
           }
//           System.out.println("第"+(i+1)+"次排序结果为：");
//           System.out.println(Arrays.toString(arr));
       }
    /*    for (int j=0;j<arr.length;j++){
            int digitOfElement=arr[j]/10%10;
            bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[j];
            bucketElementCounts[digitOfElement]++;
        }
         index=0;
        for(int k=0;k<bucketElementCounts.length;k++){
            if(bucketElementCounts[k] !=0 ){
                for (int l=0;l<bucketElementCounts[k];l++){
                    arr[index]=bucket[k][l];
                    index++;
                }
            }
            bucketElementCounts[k]=0;
        }
        System.out.println("第二次排序结果为：");
        System.out.println(Arrays.toString(arr));


        for (int j=0;j<arr.length;j++){
            int digitOfElement=arr[j]/100%10;
            bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[j];
            bucketElementCounts[digitOfElement]++;
        }
        index=0;
        for(int k=0;k<bucketElementCounts.length;k++){
            if(bucketElementCounts[k] !=0 ){
                for (int l=0;l<bucketElementCounts[k];l++){
                    arr[index]=bucket[k][l];
                    index++;
                }
            }
            bucketElementCounts[k]=0;
        }
        System.out.println("第三次排序结果为：");
        System.out.println(Arrays.toString(arr));*/
    }
}
