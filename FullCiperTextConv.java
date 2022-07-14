import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FullCiperTextConv {

    public static String Encrypt(int a, int b, String text, String lang) {
        int one = 1; // Greates Common Divisor also known as GCD
        for (int i = 1; i <= a && i <= lang.length(); i++) {
            if (a % i == 0 && lang.length() % i == 0)
                one = i;
        }

        if (one != 1) {
            System.out.println("The value of 'a' is invalid");
            return "";
        }

        String txt = "";
        for (char itemOne : text.toCharArray()) {
            if (itemOne != ' ') {
                txt += lang.charAt((a * lang.indexOf(itemOne) + b) % lang.length());
            } else {
                txt += itemOne;
            }
        }

        return txt;
    }

    public static String Decrypt(int a, int b, String cipher, String lang) {
        int one = 1;
        for (int i = 1; i <= a && i <= lang.length(); i++) {
            if (a % i == 0 && lang.length() % i == 0)
                one = i;
        }

        if (one != 1) {
            System.out.println("The value of 'a' is invalid");
            return "";
        }

        int c = 0, f = 0;
        for (int i = 0; i < lang.length(); i++) {
            f = (a * i) % lang.length();
            if (f == 1) {
                c = i;
            }
        }

        String textadd = "";
        for (char item : cipher.toCharArray()) {
            if (item != ' ') {
                int index = (c * (lang.indexOf(item) - b)) % lang.length();
                index = index < 0 ? index + lang.length() : index;
                textadd = textadd + lang.charAt(index);
            } else {
                textadd = textadd + item;
            }
        }

        return textadd;
    }

    public static void main(String[] args) {
        String plainText = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int a = 7, b = 20;

        try {
            String lang = Files.readString(Path.of("inputTaken.txt"));
            String c = Encrypt(a, b, plainText.toUpperCase(), lang);
            System.out.println(c);

            String text = Decrypt(a, b, c, lang);
            System.out.println(text);
        } catch (IOException exc) {
            System.out.println(exc.toString());
        }
    }

}