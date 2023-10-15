from Crypto.Cipher import DES
from Crypto.Util.Padding import pad
from Crypto.Util.Padding import unpad
import binascii
from Crypto.Random import get_random_bytes

# pad will add extra bytes to fill blank space
# unpad will remove those extra bytes
# DES key 64 bit (8 bytes)
#
# "8 ' 8 ' 8 ' 3 + 5"


# size of the key must be 64 bits (8 bytes)
# each character is a byte
# private key has to be 8 bytes long
# solution 1 is to ask for a password but only use the first 8 bytes
# solution 2 transform password using SHA (hashing) into 8 byte key size
# b represents bytes
key = b'mysecret'
print("Secret Key: " + str(key))

################################
# DES ENCRYPTION
################################

# MODE is set to CBC: "Cipher Block Chaining" ->
# users a chaining mechanism that causes the decryption of a block of cipher text to depend
# on all the preceding cipher text
# iv stands for initialization vector
# if non is set it will be generated automatically
cipher = DES.new(key, DES.MODE_CBC)
print("Cipher initialization vector: " + str(cipher.iv))
print("Cipher block size: " + str(cipher.block_size))

# transform the plaintext into bytes
# plaintext will be split into chunks each chunk has to
# be 8 bytes in size that is where padding can be used to fill the empty space
# in this example we are seeing 0x06 -> 0x stands for hex values 06 stands for how many bytes are added for padding
plaintext = b'This is the secret message'
print("Plain text in bytes plus padding: " + str(pad(plaintext, DES.block_size)))
ciphertext = cipher.encrypt(pad(plaintext, DES.block_size))
# cipher text in bytes
print("Cipher text in bytes:" + str(ciphertext))
# transforms into ascii hex values
print("Cipher text in ascii:" + str(binascii.hexlify(ciphertext)))

################################
# DES DECRYPTION
################################
iv = cipher.iv
decrypt_cipher = DES.new(key, DES.MODE_CBC, iv)
original_plaintext = decrypt_cipher.decrypt(ciphertext)
print("Decrypted cipher text back to it's original value: " + str(original_plaintext))
original_plaintext_unpad = unpad(original_plaintext, DES.block_size)
# use decode to transform the bytes into text
print("Decrypted cipher text back to it's original value with unpad: " + original_plaintext_unpad.decode())


