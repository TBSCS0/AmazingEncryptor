package amazingencryptor;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class TestingArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Creation of Ascii Characters Array:
        String charString = new String(IntStream.rangeClosed(32, 126).toArray(), 0, 95);
        char[] ascii = charString.toCharArray();

        //Inputting string:
        System.out.println("Enter you password below:");
        String passString = scanner.nextLine();

        //Creating brute force:
        char[] passGuess = new char[passString.length()];
        char[] passChar = passString.toCharArray();
        long startTime = System.nanoTime();
        for (int i = 0; i < passString.length(); i++) {
            System.out.println(passGuess);
            for (int j = 0; j < ascii.length; j++) {
                if (passChar[i] == ascii[j]) {
                    passGuess[i] = passChar[i];
                    j = ascii.length;
                }
            }
        }
        long endTime = System.nanoTime() - startTime;

        System.out.println("I guess your password is: " + String.valueOf(passGuess));
        double convertion = (double) endTime/1_000_000_000;
        System.out.println("And it took this much time: " + convertion + "s");
        System.out.println("And it took this much time: " + TimeUnit.MICROSECONDS.convert(endTime, TimeUnit.NANOSECONDS) + " Microseconds");


    }
}
