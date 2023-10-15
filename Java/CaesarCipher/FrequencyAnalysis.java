package Java.CaesarCipher;

import java.util.HashMap;
import java.util.Map;

import static Java.CaesarCipher.Constants.ALPHABET;

public class FrequencyAnalysis {
//    private String ALPHABET = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public Map<Character, Integer> run(String text) {
        text = text.toUpperCase();

        Map<Character, Integer> frequencies = new HashMap<>();

        for (int i = 0; i < ALPHABET.length(); i++) {
            frequencies.put(ALPHABET.charAt(i), 0);
        }

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (ALPHABET.indexOf(c) != -1) {
                frequencies.put(c, frequencies.get(c) + 1);
            }
        }

        return frequencies;
    }

    public void showFrequencies(String text) {
        Map<Character, Integer> frequencies = run(text);

        for (Map.Entry<Character, Integer> entry: frequencies.entrySet()) {
            System.out.format("Character %s has frequency: %s%n", entry.getKey(), entry.getValue());
        }
    }
}
