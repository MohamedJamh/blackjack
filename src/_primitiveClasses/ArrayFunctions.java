package _primitiveClasses;


public class ArrayFunctions {
    public static int[][] pushXInto2D(int length, int[][] arr , int[] x ){
        int[][] newArr = new int[length + 1][x.length];
        System.arraycopy(arr,0,newArr,0,length);
        newArr[length][0] = x[0];
        newArr[length][1] = x[1];
        return newArr;
    }


}
