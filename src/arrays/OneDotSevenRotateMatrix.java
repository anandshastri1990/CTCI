package arrays;

import java.util.Arrays;

public class OneDotSevenRotateMatrix {

    public static void main(String[] args) {
        RotateMatrixHelper helper = new RotateMatrixHelper();
        int[][] input1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] input2 = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println(Arrays.deepToString(helper.rotate(input1)));
        System.out.println(Arrays.deepToString(helper.rotate(input2)));
    }
}

class RotateMatrixHelper {

    //    Time complexity is O(N squared)
    public int[][] rotate(int[][] input) {
        int n = input.length;
        int count = 0;
        for (int layer = 0; layer < (input.length) / 2; layer++) {
            count++;
            int startIndex = layer;
            int lastIndex = n - 1 - startIndex;
            for (int i = startIndex; i < lastIndex; i++) {
                count++;
                int offset = i - startIndex;
                int top = input[startIndex][i];
                input[startIndex][i] = input[lastIndex - offset][startIndex];
                input[lastIndex - offset][startIndex] = input[lastIndex][lastIndex - offset];
                input[lastIndex][lastIndex - offset] = input[startIndex + offset][lastIndex];
                input[startIndex + offset][lastIndex] = top;
            }
        }

        System.out.println("Time complexity is: " + count);
        return input;
    }
}