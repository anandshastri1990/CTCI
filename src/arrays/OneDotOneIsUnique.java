package arrays;


//Implement an algorithm to determine if a string has all unique chars. Assuming extended ascii set

import utils.PrintHelper;

public class OneDotOneIsUnique {
    public static void main(String[] args) {
        IsUniqueHelper helper = new IsUniqueHelper();
        String input1 = "abcdefghijklmnopqrstuvwxyz 1234567890";
        String input2 = "duplicate value";

        PrintHelper.printOutput(helper.isUniqueBruteForce(PrintHelper.printInput(input1)));
        PrintHelper.printOutput(helper.isUniqueOptimized(PrintHelper.printInput(input1)));
        PrintHelper.printOutput(helper.isUniqueBruteForce(PrintHelper.printInput(input2)));
        PrintHelper.printOutput(helper.isUniqueOptimized(PrintHelper.printInput(input2)));
    }
}

class IsUniqueHelper {

    int count = 0;

    //    complexity is n squared, since each char is compared against rest of the chars
    boolean isUniqueBruteForce(String str) {
        count = 0;
        char[] allChars = new char[Math.min(str.length(), 256)];
        boolean isUnique = true;
        for (char x : str.toCharArray()) {
            int i = 0;
            count++;
            while (allChars[i] != 0) {
                count++;
                if (allChars[i] == x) {
                    isUnique = false;
                    break;
                }
                i++;
            }
            allChars[i] = x;
        }

        System.out.println("Time complexity: " + count);
        System.out.println("Space complexity: " + allChars.length);
        return isUnique;
    }

    //    complexity is O(1)
    boolean isUniqueOptimized(String str) {
        if(str.length() > 256) {
            return false;
        }
        count = 0;
        boolean isUnique = true;
        char[] allChars = new char[256];
        for (char x : str.toCharArray()) {
            count++;
            if (allChars[(int) x] != 0) {
                isUnique = false;
                break;
            }
            allChars[(int) x] = x;
        }

        System.out.println("Time complexity of optimized algorithm: " + count);
        System.out.println("Space complexity: " + allChars.length);
        return isUnique;
    }
}


