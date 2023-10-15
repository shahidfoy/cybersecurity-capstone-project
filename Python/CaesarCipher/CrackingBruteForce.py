ALPHABET = ' ABCDEFGHIJKLMNOPQRSTUVWXYZ'
KEY = 0

def crack_caesar(cipher_text):
    for key in range(len(ALPHABET)):
        plain_text = ''
        for c in cipher_text:
            index = ALPHABET.find(c)
            index = (index - key) % len(ALPHABET)
            plain_text = plain_text + ALPHABET[index]
        print('with key %s, the result is: %s' % (key, plain_text))

if __name__ == '__main__':
    encrypted_text = 'LCDPCWKHCFLSKHUCPHVVDJH'
    crack_caesar(encrypted_text)
