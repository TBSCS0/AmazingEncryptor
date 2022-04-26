package amazingencryptor;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TestingArea {
    public static void main(String args[]) throws NoSuchAlgorithmException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        List<Character> characters = new ArrayList<Character>();
        for(char code = 0; code < 123; code++) {
            if (code > 47 && code < 58) {
                characters.add(code);
            }else if(code > 96){
                characters.add(code);
            }
        }

        //Inputing string
        System.out.println("Enter you password below:");
        String passwordString = scanner.next();

//        System.out.println("Your password: "+AmazingEncryptor.toHexString(AmazingEncryptor.getSHA(passwordString)));
//        System.out.println(characters);

        //Creating brute force
        char[] passwordGuess = new char[64];
        boolean cracked = true;
        while(cracked) {
            for (int i = 0; i < 64; i++) {
                int randomInt = random.nextInt(characters.size());
                passwordGuess[i] = characters.get(randomInt);
            }
            System.out.println("Guess: "+new String(passwordGuess));
            if (AmazingEncryptor.toHexString(AmazingEncryptor.getSHA(passwordString)).equals(new String(passwordGuess))){
                cracked = false;
                System.out.println("Password found: " + new String(passwordGuess));
            }else{
                cracked = true;
            }
        }

        // library to calculate time
        // brute force attack sha256
    }
}
