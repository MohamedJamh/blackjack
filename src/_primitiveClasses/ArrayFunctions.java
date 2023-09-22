package _primitiveClasses;


public class ArrayFunctions {
    public static int[][] pushXInto2D(int length, int[][] arr , int[] x ){
        int[][] newArr = new int[length + 1][x.length];
        System.arraycopy(arr,0,newArr,0,length);
        newArr[length][0] = x[0];
        newArr[length][1] = x[1];
        return newArr;

        // TODO: 22‏/9‏/2023 Add this logic to pushXInto2D test method
//    int[][] arr =
//            {
//                    {1, 2}, {2, 3}
//            };
//        for (int[] card : ArrayFunctions.pushXInto2D(arr.length,arr,new int[]{3, 4})){
//        System.out.println(Arrays.toString(card));
//    }
    }


}
