package Java.CaesarCipher;

public class App {
    public static void main(String[] args) {
        // tip use long message to statisically increase the amount of letters what will show up to get more accurate answer
        String text = "I am the cipher message eeeeee";

        CaesarCipher cipher = new CaesarCipher();
        String cipherText = cipher.enrypt(text, 3);

        System.out.println(cipherText);
        String plainText = cipher.decrypt(cipherText, 3);
        System.out.println(plainText);

        FrequencyAnalysis analysis = new FrequencyAnalysis();
        analysis.showFrequencies(text);
        analysis.showFrequencies(cipherText);

        CrackingFrequencyAnalysis cracker = new CrackingFrequencyAnalysis();
        cracker.crackCaesar(cipherText);
    }
}