package Java.AES;

public class App {
    public static void main(String[] args) {

        AES aes = new AES();

        String text = "This is the secret message!!";
        String cipherText = aes.encrypt(text);
        String originalText = aes.decrypt(cipherText);
        System.out.println(cipherText);
        System.out.println(originalText);
    }
}
