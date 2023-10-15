package Java.VigenereCipher;

public class App {

    public static void main(String[] args) {
        VigenereCipher cipher = new VigenereCipher();

        String cipherText = cipher.encrypt("cryptography is important", "table");
        System.out.println(cipherText);
        System.out.println(cipher.decrypt(cipherText, "table"));
    }
}
