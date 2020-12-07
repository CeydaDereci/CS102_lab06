import java.util.Scanner;
public class Lab06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //part 1
        String str;
        System.out.println("Enter string: ");
        str = scan.next();
        System.out.println("Length of the string is: " + strLen(str));

    }


    public static int strLen(String str) {
        if (str.equals(""))
            return 0;
        else
            return strLen(str.substring(1)) + 1;
    }
}
