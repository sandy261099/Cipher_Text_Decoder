public class InputTextConversion {

    public static String Encryption(int a, int b, String input) {
        int count = 1; // Greates Common Divisor also known as GCD
        for (int i = 1; i <= a && i <= 26; i++) {
            if (a % i == 0 && 26 % i == 0)
                count = i;
        }

        if (count != 1) {
            System.out.println("The value of 'a' is invalid");
            return "";
        }

        String one = "";
        for (char items : input.toCharArray()) {
            if (items != ' ') {
                one += (char) ((a * (items - 'A') + b) % 26 + 'A');
            } else {
                one += items;
            } // Encryption is done here
        }

        return one;
    }

    public static String Dencryption(int a, int b, String cipher) {
        int count = 1;
        for (int i = 1; i <= a && i <= 26; i++) {
            if (a % i == 0 && 26 % i == 0)
                count = i;
        }

        if (count != 1) {
            System.out.println("The value of 'a' is invalid");
            return "";
        }

        int c = 0;
        int flag = 0;
        for (int i = 0; i < 26; i++) {
            flag = (a * i) % 26;
            if (flag == 1) {
                c = i;
            }
        }

        String texta = "";
        for (char item : cipher.toCharArray()) {
            if (item != ' ') {
                texta += (char) (((c * ((item + 'A' - b)) % 26)) + 'A');
            } else {
                texta += item;
            }
        }

        return texta;
    }

    public static void main(String[] args) {
        String plainText = "THIS TEXT IS FOR TESTING"; // Input Text given by us
        int a = 7; // Given by us
        int b = 20;
        String encryText = Encryption(a, b, plainText);
        System.out.println(encryText);

        String decryText = Dencryption(a, b, encryText);
        System.out.println(decryText);
    }

}