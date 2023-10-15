import matplotlib.pylab as plt

ALPHABET = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'

def frequency_analysis(text):
    text = text.upper()
    letter_frequencies = {}

    for letter in ALPHABET:
        letter_frequencies[letter] = 0

    for letter in text:
        if letter in ALPHABET:
            letter_frequencies[letter] += 1

    return letter_frequencies

def plot_distribution(frequencies):
    plt.bar(frequencies.keys(), frequencies.values())
    plt.show()

def caesar_crack(cipher_text):
    # find the most common letter, in the english language the letter `e` appears most often
    freq = frequency_analysis(cipher_text)
    print(freq)
    plot_distribution(freq)
    freq = sorted(freq.items(), key=lambda x: x[1], reverse=True)
    # find the most common letter in cipher text and substract its position from the position of `e`
    print("The possible key value: %s" % (ALPHABET.find(freq[0][0]) - ALPHABET.find('E')))

if __name__ == '__main__':
    plain_text = "random text message can you read this"
    freq = frequency_analysis(plain_text)
    plot_distribution(freq)

    cipher_text = "ZHOFRPHAWRAFDHVDUAFLSKHUB"
    caesar_crack(cipher_text)
