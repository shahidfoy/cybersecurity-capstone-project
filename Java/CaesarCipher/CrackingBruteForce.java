package Java.CaesarCipher;

public class CrackingBruteForce {

    private String ALPHABET = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public void crack(String cipherText) {

        for (int key = 0; key < ALPHABET.length(); key++) {
            String plainText = "";
            for (int i = 0; i < cipherText.length(); i++) {
                char character = cipherText.charAt(i);
                int charIndex = ALPHABET.indexOf(character);
                // int decryptedIndex = (charIndex - key) % ALPHABET.length();
                int decryptedIndex = Math.floorMod(charIndex - key, ALPHABET.length());
                plainText += ALPHABET.charAt(decryptedIndex);
            }
            System.out.format("Cracking Caesar-Cipher with %s key the result is: %s%n",
                 key, plainText);
        }
    }
}
