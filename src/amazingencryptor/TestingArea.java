package amazingencryptor;

import java.security.NoSuchAlgorithmException;
import java.util.*;

public class TestingArea {
    public static void main(String args[]) throws NoSuchAlgorithmException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        List<Character> charList = new ArrayList<Character>();
        for(char code = 0; code < 256; code++) {
            charList.add(code);
        }
        char[] ascii = new char[charList.size()];
        for (int i = 0; i < ascii.length; i++) {
            ascii[i] = charList.get(i);
        }
        //Inputing string
        System.out.println("Enter you password below:");
        String passString = scanner.nextLine();
        //creating brute force
        char[] passGuess = new char[passString.length()];
        char[] passChar = new char[passString.length()];
        for (int i = 0; i < passString.length(); i++) {
            passChar[i] = passString.charAt(i);
        }
        for (int i = 0; i < passString.length(); i++) {
            System.out.println(passGuess);
            for (int j = 0; j < charList.size(); j++) {
                if (passChar[i] == ascii[j]) {
                    passGuess[i] = passChar[i];
                    j = charList.size();
                }
            }
        }
        System.out.println(passGuess);
        System.out.println(new StringBuilder().append("I guess your password is: ").append(passGuess).toString());
    }
}
