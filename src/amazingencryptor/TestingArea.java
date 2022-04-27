package amazingencryptor;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class TestingArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Creation of Ascii Characters Array:
        String asciiCodes = new String(IntStream.rangeClosed(32, 126).toArray(), 0, 95);
        char[] asciiCharacters = asciiCodes.toCharArray();

        //Inputting string:
        System.out.println("Enter a 8 digit password below:");
        String password = scanner.nextLine();

        //Creating brute force:
        //char[] passGuess = new char[password.length()];
        //char[] passChar = password.toCharArray();

        char[] pswTry = new char[8];
        long startTime = System.nanoTime();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < asciiCharacters.length; j++) {
                pswTry[i] = asciiCharacters[j];
            }
        }
        long endTime = System.nanoTime() - startTime;

        //System.out.println("I guess your password is: " + String.valueOf(passGuess));
        double convertion = (double) endTime/1_000_000_000;
        System.out.println("And it took this much time: " + convertion + "s");
        System.out.println("And it took this much time: " + TimeUnit.MICROSECONDS.convert(endTime, TimeUnit.NANOSECONDS) + " Microseconds");
    }
}
