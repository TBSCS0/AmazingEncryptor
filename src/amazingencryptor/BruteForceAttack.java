package amazingencryptor;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class BruteForceAttack {
    public static void main(String[] args) {

        //Inputing password to be h@ck3d!
        System.out.println("Enter a password below:");
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        char[] pswFound = new char[password.length()];
        char[] passwordCharacters = password.toCharArray();

        //Creation of Ascii Characters Array:
        String asciiCodes = new String(IntStream.rangeClosed(32, 126).toArray(), 0, 95);
        /* note!
        "IntStream.rangeClosed(32 , 126)" Is being used to set the starting digit of the string called asciiCodes. So the string will start at 32 and shall ent in 126,
        for example:
        asciiCodes = "3233343536...124125126".
        If we change the 32 for 35, the string will be some like: asciiCodes = "353637...124125126". Also, same thing for the 126. If we change it to 123 but didn't
        change the 32, the string will be something like: asciiCodes = "323334...121122123". In addition, the "offset" and the "count", are used to create the total
        length of the string, if we change those values we would change the total length. For now, we have a string that will continue until 95 elements, and those
        elements are the digits being inputted by the "IntStream.rangeClosed(32,126)". This is used so when we break the string, the program knows were each element
        are located, otherwise the program will get each single integer and count as a single element for the whole string, creating a MASSIVE ARRAY
        that don't have the number of elements that we want. If we broke the string into an array with these values, the array should look something like:
        arr = { 32 , 33 , 34 ,..., 124 , 125 , 126 }
        without the offset and the count, the array would look like:
        arr = { 3 , 2 , 3 , 3 , 3 , 3 ,... , 1 , 2 , 5 , 1 , 2 , 6 }
        if we change only the offset to 3, the array would look like:
        arr = { 35 , 36 , 37 ,..., 124 , 125 , 126 }
        if we change only the count to 93, the array would look like:
        arr = { 32 , 33 , 34 ,..., 122 , 123 , 124 }
        if we changed both for "offset:3, count:93", the array would look like:
        arr = { 35 , 36 , 37 ,..., 122 , 123 , 124 }
        IMPORTANT NOTICE -> The string used on the examples of array above, is the string created by: "IntStream.rangeClosed(32, 12)", so: string = "32333435...124125126"
         */
        char[] asciiCharacters = asciiCodes.toCharArray();
        /* note!
        Afterwards we break the string created in the variable "asciiCodes" into the array above. We don't need to translate each integer for their representative in
        the ascii table because the library "char" that stands out for "characters", already knows the code for each character in the ascii table. Hence, automatically
        translating it.
         */

        //System.out.println(asciiCharacters);
        System.out.println("checking.... please wait!");

        //Recursion method for "hacking" the password entered by the user
        double startTime = System.nanoTime();
        System.out.println("It is: " + Arrays.toString(
                bruteForce(pswFound, passwordCharacters, asciiCharacters, 0)) + ". Isn't it?");
        double endTime = System.nanoTime() - startTime;
        /* note!
        The variables "startTime" and "endTime" are used to gather the time taken to the program to process the "hacking", and this time will be measured by
        nanoseconds. For this simulation we shall use "nanoTime()" function of java for greater precision and accuracy of time.

        Just for measure:
                1 nanosecond = 0.000000001 seconds or 1E-8 seconds
         */

        System.out.println("You dumb dumb, your password is weak!");
        System.out.println("It took " + endTime/1_000_000_000 + "seconds");
    }

    public static char[] bruteForce(char[] pswFound, char[] password, char[] asciiCharacters, int index){

        //Creating brute force
        for (int i = index; i < pswFound.length; i++) {

            for (int j = 0; j < asciiCharacters.length; j++) {

                if(!Arrays.equals(pswFound,password)){
                    /* note!
                    It needs to check if the password DOESN'T match, because if you check If it matches and invert this If parameters, the password
                    will pass through the program, and it will not acknowledge it. Making the loop go through all characters from our asciiCharacters
                    list, and eventually giving a answer that will only have ) or ~, that is the last character from our ascii Table
                     */
                    pswFound[i] = asciiCharacters[j];
                    bruteForce(pswFound, password, asciiCharacters, index+1);
                    /* note!
                    (as sir to help explain the recursion above :< )
                    Also, we will need to use recursion for this simulation because of the limitations of interactive methods. Mainly because when
                    you try to break an 8 digit password, for example, you will need to create 8 for loops for each character. This problem scales
                    even more when you try to break a Hash of a password that has 64 characters. As now, you would need 64 interaction structures
                    to find the combination of the Hash.
                     */

                }else{
                    i = pswFound.length;
                    j = 95;
                }
            }
        }

        return pswFound;

    }
}