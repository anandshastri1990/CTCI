package arrays;

import utils.PrintHelper;

//Given two string, write a method to decide if one is a permutation of the other

public class OneDotTwoPermutation {
    public static void main(String[] args) {
        PermutationHelper helper = new PermutationHelper();
        String input1 = "String1";
        String input2 = "S1tring";
        String input3 = "abcdef";
        String input4 = "abcdeg";

        PrintHelper.printOutput(helper.isSame(PrintHelper.printInput(input1), PrintHelper.printInput(input2)));
        PrintHelper.printOutput(helper.isSame(PrintHelper.printInput(input3), PrintHelper.printInput(input4)));
    }
}

class PermutationHelper {

    //    Time complexity is O(A + B + A + B) = O(2(A+B)) = O(A+B) = O(2A) = O(A)
    public boolean isSame(String input1, String input2) {
        int count = 0;
        if (input1.length() != input2.length()) {
            return false;
        }

        int[] intArray = new int[256];
        for (char c : input1.toCharArray()) {
            count++;
            intArray[(int) c]++;
        }
        for (char c : input2.toCharArray()) {
            count++;
            intArray[(int) c]--;
            if (intArray[(int) c] < 0) {
                System.out.println("Time complexity is: " + count);
                return false;
            }
        }
        System.out.println("Time complexity is: " + count);
        return true;
    }
}