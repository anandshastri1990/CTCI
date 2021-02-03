package utils;

public class PrintHelper {
    public static void printLine() {
        System.out.println("---------------------------------------------------------------------------------------");
    }

    public static <T> T printInput(T input) {
        System.out.println("******** Input: " + input);
        return input;
    }

    public static <T> void printOutput(T output) {
        System.out.println("******** Output: " + output);
        printLine();
    }
}
