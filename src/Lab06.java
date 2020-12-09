import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
public class Lab06 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String str;
        int n;

        //part 1 call method
        System.out.println("Part 1");
        System.out.println("Enter string: ");
        str = scan.nextLine();
        System.out.println("Length of the string is: " + strLen(str));

        //part 2 call method
        System.out.println("Part 2");
        System.out.println("Enter string: ");
        str = scan.nextLine();
        System.out.println(countNonVowels(str));

        //part 3 call method
        System.out.println("Part 3");
        System.out.println("Enter n: ");
        n = scan.nextInt();
        generateBinary(n,"");

        //part 4 call method
        System.out.println("Part 4");
        File file = new File("/Users/Ceyda/Desktop/CS 102");
        System.out.println(Arrays.toString(file.listFiles()));
        System.out.println(count(file));

    }

    //part 1 method
    public static int strLen(String str) {
        if (str.equals(""))
            return 0;
        else
            return strLen(str.substring(1)) + 1;
    }

    //part 2 method
    public static int countNonVowels(String str) {
        int count = 0;
        if(str.length() != 0) {
            if (isNonVowel(str.charAt(0)))
                count += countNonVowels(str.substring(1)) + 1;
            else
                count += countNonVowels(str.substring(1));
        }
        return count;
    }

    //helper method for part 2
    public static boolean isNonVowel(char ch){
        ch = Character.toUpperCase(ch);
        return ch == 'B' || ch == 'C' || ch == 'D' || ch == 'F' || ch == 'G' || ch == 'H' || ch == 'J' || ch == 'K' || ch == 'L' || ch == 'M' || ch == 'N' || ch == 'P' || ch == 'Q' || ch == 'R' || ch == 'S' || ch == 'T' || ch == 'V' || ch == 'W'|| ch == 'X' || ch == 'Y' || ch == 'Z' ;

    }

    //part 3 method
    public static void generateBinary(int n, String val) {
        if (n == 0)
            System.out.println(val);
        else{
            generateBinary(n - 1, val + "0");
            if (val.length() != 0 && val.substring(val.length() - 1).equals("0"))
                generateBinary(n - 1, val + "1");
            else if (val.length() == 0)
                generateBinary(n - 1, val + "1");
        }
    }

    //part 4 method
    public static long count(File file) {
        long size;
        if (file.isDirectory()) {
            size = 0;
            for (File child : file.listFiles()) {
                size += count(child);
            }
        } else {
            size = file.length();
        }
        return size;
    }

}
