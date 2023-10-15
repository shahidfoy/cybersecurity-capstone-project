package Java.DES;

public class App {
    public static void main(String[] args) {

        DES des = new DES();

        String text = "This is the secret message";

        String cipherText = des.encrypt(text);
        System.out.println("DES cipher text: " + cipherText);
        System.out.println("DES original text: " + des.decrypt(cipherText));
    }
}
