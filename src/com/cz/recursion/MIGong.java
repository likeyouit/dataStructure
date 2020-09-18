package com.cz.recursion;

/**
 * 递归实现
 * 简单迷宫
 */
public class MIGong {
    public static void main(String[] args) {
        int[][] mg = new int[8][7];
        for (int i = 0; i < 7; i++) {
            //设置墙(行)
            mg[0][i] = 1;
            mg[7][i] = 1;
            //设置墙(列)
            mg[i][0] = 1;
            mg[i][6] = 1;

            mg[7][0] = 1;
            mg[7][6] = 1;

            mg[3][1] = 1;
            mg[3][2] = 1;
        }

        for (int i = 0; i < 8 ; i++) {
            for (int j = 0;j < 7;j++){
                System.out.print("\t"+mg[i][j]);
            }
            System.out.println();
        }

        System.out.println("===================================");
        excute(mg,1,1);
    }

    /**
     *  终点在右下角,走迷宫的方向：下，右，上，左
     * @param map
     * @param startRow 决定起始点的行
     * @param startColumn 决定起始点的列
     */
    public static void excute(int[][] map,int startRow,int startColumn){

        map[startRow][startColumn] = 2;

        if (map[5][4] == 2){
            for (int[] arr: map) {
                for (int i: arr) {
                    System.out.print(i+"\t");
                }
                System.out.println();
            }
            return;
        }

        if(map[startRow+1][startColumn] != 1){
            map[startRow+1][startColumn] = 2;
            excute(map,startRow+1,startColumn);
        }else if (map[startRow][startColumn+1] != 1){
            map[startRow][startColumn+1] = 2;
            excute(map,startRow,startColumn+1);
        }else if (map[startRow-1][startColumn] != 1){
            map[startRow-1][startColumn] = 2;
            excute(map,startRow-1,startColumn);
        }else if (map[startRow][startColumn-1] != 1){
            map[startRow][startColumn-1] = 2;
            excute(map,startRow+1,startColumn);
        }

    }
}
