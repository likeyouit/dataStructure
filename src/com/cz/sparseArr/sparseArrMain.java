package com.cz.sparseArr;


import java.io.*;

public class sparseArrMain {
    public static void main(String[] args) throws IOException {
        //创建11*11棋盘
        int chessArr[][] = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;

        System.out.println("========原始的二维数组========");
        for (int[] row:
             chessArr) {
            for (int data:
                 row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        //----------------获取稀疏数组的第一行数据和有效数据----------------------------
        int sum=0;
        int[][] sparseArr= null;
        int sparseRow = chessArr.length;
        int sparseColumn = 0;
        for (int[] row:
             chessArr) {
            sparseColumn = row.length;
            for (int data:row){
                if (data != 0){
                    ++sum;
                }
            }
        }

        //创建稀疏数组
        sparseArr = new int[sum + 1][3];
        //存入棋盘的有效数据
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        int countRow = 1;
        for (int i = 0;i<sparseRow;i++){
            for (int j = 0;j<sparseColumn;j++){
                if (chessArr[i][j] != 0){
                    sparseArr[countRow][0] = i;
                    sparseArr[countRow][1] = j;
                    sparseArr[countRow][2] = chessArr[i][j];
                    countRow++;
                }
            }
        }

        //--------------得到的稀疏数组-------------------
        System.out.println();
        System.out.println("=======得到的稀疏数组=======");
        for (int[] row:
                sparseArr) {
            for (int data:
                    row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //----------------根据稀疏数组还原二维数组----------------
        int[][] newChessArr = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            newChessArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        //--------------还原得到的二维数组-------------------
        System.out.println();
        System.out.println("=======还原得到的二维数组=======");
        for (int[] row:
                newChessArr) {
            for (int data:
                    row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //=================将稀疏数组保存在磁盘==================
        FileOutputStream fos =
                new FileOutputStream("C:\\Users\\jiao\\Desktop\\ss.txt");
        DataOutputStream dos = new DataOutputStream(fos);
        for (int i = 0; i < sparseArr.length; i++) {

            System.out.println("写入数据："+sparseArr[i][0]+"\t"+sparseArr[i][1]+"\t"+sparseArr[i][2]);
            dos.writeInt(sparseArr[i][0]);
            dos.writeInt(sparseArr[i][1]);
            dos.writeInt(sparseArr[i][2]);

            fos.flush();
        }
        fos.close();


        System.out.println("===========");
        FileInputStream fis = new FileInputStream("C:\\Users\\jiao\\Desktop\\ss.txt");
        DataInputStream dis = new DataInputStream(fis);

        for (int i = 0;i < sparseArr.length * 3;i++){
            System.out.println(dis.readInt());
        }
        fis.close();
    }
}
