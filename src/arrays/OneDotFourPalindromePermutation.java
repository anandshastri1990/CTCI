package arrays;

import utils.PrintHelper;

public class OneDotFourPalindromePermutation {
    public static void main(String[] args) {
        PalindromePermutationHelper helper = new PalindromePermutationHelper();
        String input1 = "teneT ";
        String input2 = "S1tring";
        String input3 = "aAaA";
        String input4 = "aBba";
        String input5 = "tactcoa papa";

        PrintHelper.printOutput(helper.isPalindrome(PrintHelper.printInput(input1)));
        PrintHelper.printOutput(helper.isPalindrome(PrintHelper.printInput(input2)));
        PrintHelper.printOutput(helper.isPalindrome(PrintHelper.printInput(input3)));
        PrintHelper.printOutput(helper.isPalindrome(PrintHelper.printInput(input4)));
        PrintHelper.printOutput(helper.isPalindrome(PrintHelper.printInput(input5)));
    }
}


class PalindromePermutationHelper {

    //    Time complexity is O(A + 26) = O(A)
    public boolean isPalindrome(String input) {
        int count = 0;
        int[] intArray = new int[26];
        for (char c : input.toUpperCase().toCharArray()) {
            if (c > 'A' && c < 'Z') {
                count++;
                int asciiValue = (int) c - 'A';
                if (intArray[asciiValue] == 0) {
                    intArray[asciiValue]++;
                } else {
                    intArray[asciiValue]--;
                }
            }
        }

        boolean foundOdd = false;
        for (int i : intArray) {
            count++;

            if (i % 2 == 1) {
                if (foundOdd) {
                    System.out.println("Time complexity is: " + count);
                    return false;
                }
                foundOdd = true;
            }
        }
        System.out.println("Time complexity is: " + count);
        return true;

    }
}