package amazingencryptor;

import java.util.*;
import java.util.stream.IntStream;

public class TestingArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Creation of Ascii Characters Array:
        String s = new String(IntStream.rangeClosed(32, 126).toArray(), 0, 95);
        char[] ascii = s.toCharArray();
        //Inputting string:
        System.out.println("Enter you password below:");
        String passString = scanner.nextLine();
        //Creating brute force:
        char[] passGuess = new char[passString.length()];
        char[] passChar = passString.toCharArray();
        for (int i = 0; i < passString.length(); i++) {
            System.out.println(passGuess);
            for (int j = 0; j < ascii.length; j++) {
                if (passChar[i] == ascii[j]) {
                    passGuess[i] = passChar[i];
                    j = ascii.length;
                }
            }
        }
        System.out.println(passGuess);
        System.out.println("I guess your password is: " + String.valueOf(passGuess));
    }
}
