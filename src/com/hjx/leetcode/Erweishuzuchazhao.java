package com.hjx.leetcode;

public class Erweishuzuchazhao {
    public static void main(String[] args){
        int target = 7;
        int[][] array = {{1,2,4}, {2, 3, 6}, {4, 7, 9}};
        System.out.println(Find(target, array));
        System.out.println(Find1(array, target));
    }

    public static boolean Find(int target, int [][] array) {
        if(array.length == 0 || array[0].length == 0) return false;
        if(target < array[0][0] || target > array[array.length - 1][ array[0].length - 1]) return false;
        int rowLength = array[0].length;
        int columLength = array.length;
        int i = 0;
        int j = 0;
        for(i = 0; i < rowLength; i ++){
            if(array[j][i] == target) return true;
            if(target < array[j][i]) {
                i --;
                j ++;
                break;
            }
        }
        if(i == rowLength){
            i --;
            j ++;
        }
        while(i >= 0 && j < columLength){
            if(target == array[j][i]) return true;
            if(target > array[j][i]) {
                j ++;
                continue;
            }
            if(target < array[j][i]){
                i --;
                continue;
            }
        }
        return false;
    }

    public static boolean Find1(int [][] array,int target) {
        int row=0;
        int col=array[0].length-1;
        while(row<=array.length-1&&col>=0){
            if(target==array[row][col])
                return true;
            else if(target>array[row][col])
                row++;
            else
                col--;
        }
        return false;

    }
}
