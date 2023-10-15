package Java.VigenereCipher;

public class VigenereCipher {

    private static final String ALPHABET = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String encrypt(String plainText, String key) {
        plainText = plainText.toUpperCase();
        key = key.toUpperCase();

        StringBuilder cipherText = new StringBuilder();
        int keyIndex = 0;

        for (int i = 0; i < plainText.length(); i++) {
            char c = plainText.charAt(i);
            int index = Math.floorMod(ALPHABET.indexOf(c) + ALPHABET.indexOf(key.charAt(keyIndex)), ALPHABET.length());

            cipherText.append(ALPHABET.charAt(index));
            keyIndex++;

            if (keyIndex == key.length()) {
                keyIndex = 0;
            }
        }

        return cipherText.toString();
    }

    public String decrypt(String cipherText, String key) {
        cipherText = cipherText.toUpperCase();
        key = key.toUpperCase();

        StringBuilder plainText = new StringBuilder();
        int keyIndex = 0;

        for (int i = 0; i < cipherText.length(); i++) {
            char c = cipherText.charAt(i);
            int index = Math.floorMod(ALPHABET.indexOf(c) - ALPHABET.indexOf(key.charAt(keyIndex)), ALPHABET.length());

            plainText.append(ALPHABET.charAt(index));
            keyIndex++;

            if (keyIndex == key.length()) {
                keyIndex = 0;
            }
        }

        return plainText.toString();
    }
}
