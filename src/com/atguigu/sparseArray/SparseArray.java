package com.atguigu.sparseArray;

public class SparseArray {
    public static void main(String[] args) {

        int chessArray1 [][] =new int[11][11];
        chessArray1[1][2]=1;
        chessArray1[2][3]=2;
        System.out.println("原始二维数据为：");
        for (int [] row:chessArray1){
            for (int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        int sum=0;
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if (chessArray1[i][j] != 0){
                    sum++;
                }
            }
        }


        int sparseArray [][] =new int[sum+1][3];
        sparseArray[0][0]=11;
        sparseArray[0][1]=11;
        sparseArray[0][2]=sum;

        int count=0;
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if (chessArray1[i][j] != 0){
                     count++;
                     sparseArray[count][0]=i;
                     sparseArray[count][1]=j;
                     sparseArray[count][2]=chessArray1[i][j];
                }
            }
        }
        System.out.println("得到的稀疏数组为：");
        for(int i=0;i<sparseArray.length;i++){
            System.out.printf("%d\t%d\t%d\t\n",sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
        }

       int chessArray2  [][]=new int[sparseArray[0][0]][sparseArray[0][1]];

        for(int i=1;i<sparseArray.length;i++){
            chessArray2[sparseArray[i][0]][sparseArray[i][1]]=sparseArray[i][2];
        }
        System.out.println("恢复后的二维数组为：");
        for (int [] row:chessArray2){
            for (int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }



    }
}
