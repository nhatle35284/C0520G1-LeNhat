package array_method_in_java.bai_tap;

public class Array2D {
    public static void main(String[] args) {
        int[][] arr2d={
                {1,3,4},
                {2,4,0}
        };
        int min=arr2d[0][0];
        for (int i=0;i<arr2d.length;i++) {
            for (int j=0;j<arr2d[i].length;j++){
                if (min>arr2d[i][j]){
                    min=arr2d[i][j];
                }
            }
        }
    }
}
