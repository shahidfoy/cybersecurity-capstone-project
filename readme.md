# Symmetric Encryption Analysis: AES & DES

Capstone project for AES & DES analysis. This project explores the differences between AES & DES symmetric encryption. These libraries provide methods to encrypt and decrypt plaintext messageing in Java & Python. The following are the encryption methods:

- AES
- DES
- CaesarCipher
- VigenereCipher

For the project an attempt is made to identify a 64-bit symmetric key. Since there are 2^64 possibilities and a short amount of time for the project a limitation was added to only test 64-bit keys that contain only lowercase alphabets. within the range `aaaaaaaa` to `zzzzzzzz`. Another limitation that was added to the scope for this project is identifying the secret key. The `symmetrickey.decryptor` package is provided with the known secret key and compares it with the output it is producing. 

In a real world senario the generated key produced by `symmetrickey.decryptor` would have to be changed to run the encrypted message with the generated key and the desired decryption method to compare the decrypted text with a known decrypted text or a language detection tool to see if they match.

Below is the processing time for the decryptor when trying to locate the symmetric key value of `mysecret`.

|process start time |process end time   |total attempts |Totoal time to process in seconds|
|-------------------|-------------------|---------------|---------------------------------|
|2023-09-23 04:50 PM|2023-09-29 05:58 PM|104_011_440_175|508457                           |


# Notes
## Confusion and Diffusion (Claude Shannon)
  - Confusion: each binary digit of the ciphertext should depend on several digits of the private key
  - Diffusion: if we change a single bit in the input (plaintext) then half of the digits in the output (ciphertext) should change

randomness means perfect secrecy 

python lib to use `pycryptodome`

## Wiki sources
https://en.wikipedia.org/wiki/DES_supplementary_material \
https://en.wikipedia.org/wiki/Advanced_Encryption_Standard \
https://en.wikipedia.org/wiki/Block_cipher_mode_of_operation 

## DES

DES keyspace = 2^56 \
DES can be broken by brute force due to the key only having 2^56 possible values. \
DES can be broken by Linear Linear cryptanalysis \
DES can be broken by Differential cryptanalysis 


## AES

AES keyspace = 2^256 \
AES has excellent confusion as well as diffusion properties \
AES is protected against linear and differential cryptanalysis \
AES output is random so frequency analysis will not work \
AES cannot be broken by brute force even with super computers within a reasonable amount of time




## Cracking DES with  16 GB RAM and  6 core processes

Breaking a 56-bit DES (Data Encryption Standard) key using a classical computer with 16 GB of RAM and 6 processor cores is feasible and can be done relatively quickly.
The time it takes to break a DES key using a brute-force attack on a classical computer depends on various factors:

*Key Space Size*: DES has a key space of 2^56 possible keys since it uses 56-bit keys. \
*Processing Speed*: The speed at which your computer can test different keys per second. \
*Parallelism*: The extent to which the task can be parallelized using multiple processor cores. \
*Algorithm Efficiency*: How efficiently the key testing algorithm is implemented.

Without knowing the exact processing speed of your computer, it's challenging to provide an exact time frame. However, as a rough estimate, 
let's assume your computer can test 1 million keys per second per core (this depends on the specific software and hardware optimizations). 
With 6 processor cores, you'd be able to test 6 million keys per second.
To calculate the time it would take to exhaust the entire DES key space (2^56 keys), you can use the following formula:

Time (in seconds) = (Number of Keys) / (Keys Tested per Second) \
Time = (2^56) / (6,000,000 keys/second) \
Now, calculating this: \
Time ≈ 1.2 x 10^15 seconds

This is an enormous number of seconds. To put it in perspective, it's roughly on the order of tens of millions of years.

Please note that DES is considered insecure for modern cryptography due to its relatively short key length. More secure encryption algorithms like AES with longer key lengths (e.g., AES-256) 
are recommended for current cryptographic applications. 
The calculation here is purely hypothetical and not a practical or recommended approach to cryptography.


Seconds in an hour: 3600 \
Seconds in a year: 31536000 \
12009599006.321 seconds = (2^56) / (6,000,000 keys/second) \
Total amount of years to crack = 38051750 years

# Ciphey notes
Another test done on the capstone was to see if the Ciphey python library could be used to identify encryption messages and keys.

https://github.com/Ciphey/Ciphey \
https://github.com/Ciphey/Ciphey/wiki

The following commands can be used to run ciphey on docker.

run docker image:
``` bash
sudo docker run -it --rm remnux/ciphey
```


run ciphey decrypt:
``` bash
sudo docker run -it --rm remnux/ciphey "68ed3aeb7175dcc290007b9d2347a4fd0b6463b7a0ea1e7b91b47d8e4c822fff"
```