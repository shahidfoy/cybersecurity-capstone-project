# Symmetric Encryption Analysis: AES & DES

Capstone project for AES & DES analysis. This project explores the differences between AES & DES symmetric encryption. These libraries provide methods to encrypt and decrypt plaintext messageing in Java & Python. The following are the encryption methods:

- AES
- DES
- CaesarCipher
- VigenereCipher

For the project an attempt is made to identify a 64-bit symmetric key. Since there are 2^64 possibilities and a short amount of time for the project a limitation was added to only test 64-bit keys that contain only lowercase alphabets. within the range `aaaaaaaa` to `zzzzzzzz`. Another limitation that was added to the scope for this project is identifying the secret key. The `symmetrickey.decryptor` package is provided with the known secret key and compares it with the output it is producing. 

In a real world senario the generated key produced by `symmetrickey.decryptor` would have to be changed to run the encrypted message with the generated key and the desired decryption method to compare the decrypted text with a known decrypted text or a language detection tool to see if they match.