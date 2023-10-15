from Crypto.Cipher import AES
from Crypto.Util.Padding import pad
from Crypto.Util.Padding import unpad
import binascii
from Crypto.Random import get_random_bytes

# plain text blocks requires 16 bytes or 128 bits

# private key of AES (used for encryption and decryption)
# key must be 128 bits (16 bytes)
# size of the key must be 128 bits (16 bytes)
# each character is a byte
# private key has to be 16 bytes long
# solution 1 is to ask for a password but only use the first 16 bytes
# solution 2 transform password using SHA (hashing) into 16 byte key size
# b represents bytes
# key = get_random_bytes(16)
key = b'mysecretpassword'


################################
# AES ENCRYPTION
################################
# if initialization vector is not defined here it will be generated automatically
cipher = AES.new(key, AES.MODE_CBC)
# initialization vector
print(cipher.iv)
# 16 bytes block
print(cipher.block_size)

plaintext = b'This is the secret message'
print(plaintext)
print(pad(plaintext, AES.block_size))

ciphertext = cipher.encrypt(pad(plaintext, AES.block_size))
# cipher text in bytes
print("Cipher text in bytes:" + str(ciphertext))
# transforms into ascii hex values
print("Cipher text in ascii:" + str(binascii.hexlify(ciphertext)))

################################
# AES DECRYPTION
################################
iv = cipher.iv
decrypt_cipher = AES.new(key, AES.MODE_CBC, iv)
original_text = unpad(decrypt_cipher.decrypt(ciphertext), AES.block_size)

# convert bytes back into string
print(original_text.decode())

