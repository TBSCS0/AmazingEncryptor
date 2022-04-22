package amazingencryptor;

public class TestingArea {
    public static void main(String args[]){
        String password = "M@cb3th";
        char[] characters = new char[password.length()];
        int[] ascii = new int[password.length()];
        for (int i = 0; i < password.length(); i++) {
            characters[i] = password.charAt(i);
            ascii[i] = (int) characters[i];
        }

        for (int i = 0; i < password.length(); i++) {
            for (int j = 0; j < 99999999; j++) {
                //System.out.println(j);
                if (j == ascii[i]) {
                    System.out.println("Gotcha! " + j);
                    System.out.println(ascii[i] + " = " + characters[i] + " = " + j);
                }
            }
        }
    }
}
