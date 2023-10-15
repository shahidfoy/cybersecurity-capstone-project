package Java.symmetrickey.decryptor;

import java.util.ArrayList;
import java.util.List;

/**
 * Symmetric Key Generator
 * Used for a capstone project to learn if a 64-bit secret key can be generated
 * and located using a personal computer.
 * To simplify the project, it is assumed that the target secret keys
 * are all lowercase letters that exist in the english alphabet.
 * @author Mohammad Shahid Foy
 */
public class SymmetricKeyGenerator {

    private static final String TARGET_KEY = "mysecret";
    List<Character> potentialSecretKeyArr = new ArrayList<>();


    /**
     * Generates possible lower case alphabet 64-bit long keys. Compares the generated key to
     * see if it is correct.
     */
    public void locateLowerCaseAlphabet64BitKey() {

        long counter = 0;
        boolean keyLocated;

        // initial list ["a", "a", "a", "a", "a", "a", "a", "a"]
        potentialSecretKeyArr.add('a');
        potentialSecretKeyArr.add('a');
        potentialSecretKeyArr.add('a');
        potentialSecretKeyArr.add('a');
        potentialSecretKeyArr.add('a');
        potentialSecretKeyArr.add('a');
        potentialSecretKeyArr.add('a');
        potentialSecretKeyArr.add('a');

        String result = this.buildKeyResult();
        keyLocated = this.isTargetKey(result);

        int lastItemInList = potentialSecretKeyArr.size() - 1;
        int rightPointer = potentialSecretKeyArr.size() - 1;

        // count up from a - z
        while (!result.equals("zzzzzzzz") && !keyLocated) {

            if (potentialSecretKeyArr.get(rightPointer) != 'z') {
                potentialSecretKeyArr.set(
                        rightPointer,
                        this.incrementLetter(potentialSecretKeyArr.get(rightPointer))
                );
            } else {
                this.resetBaseCount(rightPointer - 1, lastItemInList);
            }

            result = this.buildKeyResult();
            System.out.println(result);
            counter += 1;

            if (this.isTargetKey(result)) {
                System.out.println("The 64-bit key has been identified.");
                System.out.println("It took " + counter + " attempts.");
                keyLocated = true;
            }
        }

        System.out.println("==== final result");
        System.out.println("Key located: " + keyLocated);
        System.out.println(result);

    }

    /**
     * Combines the current list of letters into a string result
     * @return string result
     */
    private String buildKeyResult() {
        // output
        StringBuilder stringBuilder = new StringBuilder();
        potentialSecretKeyArr.forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

    /**
     * Increments a letter up one value. Uses Unicode values to increment.
     * @param letter letter to increment
     * @return the incremented letter
     */
    private char incrementLetter(char letter) {
        if (letter < 'z') letter += 1;
        return letter;
    }

    /**
     * Initialize the alphabet count back to 'a' when the letter 'z' is located.
     * @param letter letter to initialize
     * @return the initialized letter
     */
    private Character initializeFirstLetter(char letter) {
        if (letter == 'z') letter = 'a';
        return letter;
    }

    /**
     * Checks to see if the generated result key matches the target key.
     * This method is for demonstration purposes to show that the
     * target key can be generated.
     * To improve this method the encrypted results would have to be compared with
     * the encrypted output created by the generated key to see if they match.
     * @param result generated result
     * @return true if key matches
     */
    private boolean isTargetKey(String result) {
        return result.equals(TARGET_KEY);
    }

    /**
     * Uses base 26 number pattern to increment letters in the list
     * @param rightPointer right pointer
     * @param lastItemInList last item in the list
     */
    private void resetBaseCount(int rightPointer, int lastItemInList) {
        while (rightPointer < lastItemInList) {
            if (potentialSecretKeyArr.get(rightPointer) == 'z') {
                rightPointer -= 1;
            } else if (potentialSecretKeyArr.get(rightPointer + 1) == 'z') {
                // increment next letter
                potentialSecretKeyArr.set(
                        rightPointer,
                        this.incrementLetter(potentialSecretKeyArr.get(rightPointer))
                );

                // initialize all values to the right of the right pointer to 'a'
                rightPointer += 1;
                for (int i = rightPointer; i <= lastItemInList; i++) {
                    potentialSecretKeyArr.set(i, this.initializeFirstLetter(potentialSecretKeyArr.get(i)));
                }
            } else {
                break;
            }
        }
    }
}
