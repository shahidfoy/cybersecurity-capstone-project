package Java.CaesarCipher;

import java.util.Map;

import static Java.CaesarCipher.Constants.ALPHABET;

public class CrackingFrequencyAnalysis {

    private FrequencyAnalysis frequencyAnalysis;

    public CrackingFrequencyAnalysis() {
        frequencyAnalysis = new FrequencyAnalysis();
    }

    public void crackCaesar(String cipherText) {
        Map<Character, Integer> frequencies = frequencyAnalysis.run(cipherText);
        Map.Entry<Character, Integer> maxEntry = null;

        for (Map.Entry<Character, Integer> entry: frequencies.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }

        char mostFrequentChar = maxEntry.getKey();
        System.out.println("=====");
        System.out.println(mostFrequentChar);
        System.out.println("=====");
        // find the most common letter in cipher text and substract its position from the position of `e`
        int approximatedKey = ALPHABET.indexOf(mostFrequentChar) - ALPHABET.indexOf('E');
        System.out.println("The key is: " + approximatedKey);
    }
}
