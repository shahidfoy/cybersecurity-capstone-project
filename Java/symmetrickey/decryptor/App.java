package Java.symmetrickey.decryptor;

public class App {

    /**
     * Demo of cracking DES 64-bit lowercase alphabet secret key
     * @param args N/A
     */
    public static void main(String[] args) {

        long startTime = System.nanoTime();
        SymmetricKeyGenerator symmetricKeyGenerator = new SymmetricKeyGenerator();
        symmetricKeyGenerator.locateLowerCaseAlphabet64BitKey();
        long endTime = System.nanoTime();

        long timeElapsedNano = endTime - startTime;
        long timeElapsedMilli = timeElapsedNano / 1_000_000;
        long timeElapsedSeconds = timeElapsedMilli / 1_000;

        System.out.println("Total time to process: " + timeElapsedSeconds);
    }
}
