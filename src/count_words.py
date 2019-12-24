import pandas as pd
from collections import Counter

RAW_DATASET_PATH = '../data/raw_data/dataset_v2/all_users_v2.csv'
ELIMINATED_DATASET_PATH = '../data/eliminated_data/eliminated_all_users_v2.csv'
PREPROCESSED_ZEMBEREK_DATASET_PATH = '../data/preprocessed_data/zemberek/zemberek_lemmatization.csv'
PREPROCESSED_NO_STEMMING_DATASET_PATH = '../data/preprocessed_data/python/preprocessed_dataset_no_stemming.csv'
PREPROCESSED_WITH_STEMMING_DATASET_PATH = '../data/preprocessed_data/python/preprocessed_dataset_with_stemming.csv'


def count_words_in_file(file_path):
    df = pd.read_csv(RAW_DATASET_PATH, sep = ';', header = 0)
    entries = df['entry'].str.lower()

    return Counter(" ".join(entries).split(" "))

def save_most_common_words(word_counts, file_path, top = 1000):
    with open(file_path, 'a') as file:
        for word, count in word_counts.most_common(top):
            file.write("word: {} count: {}\n\n".format(word, count))
            
print("Words in file {} counted !".format(RAW_DATASET_PATH))
word_counts = count_words_in_file(RAW_DATASET_PATH)
save_most_common_words(word_counts, './raw_dataset_top_1000_words.txt')

print("Words in file {} counted !".format(ELIMINATED_DATASET_PATH))
word_counts = count_words_in_file(ELIMINATED_DATASET_PATH)
save_most_common_words(word_counts, './eliminated_dataset_top_1000_words.txt')

print("Words in file {} counted !".format(PREPROCESSED_ZEMBEREK_DATASET_PATH))
word_counts = count_words_in_file(PREPROCESSED_ZEMBEREK_DATASET_PATH)
save_most_common_words(word_counts, './preprocessed_zemberek_dataset_top_1000_words.txt')

print("Words in file {} counted !".format(PREPROCESSED_NO_STEMMING_DATASET_PATH))
word_counts = count_words_in_file(PREPROCESSED_NO_STEMMING_DATASET_PATH)
save_most_common_words(word_counts, './preprocessed_no_stemming_dataset_top_1000_words.txt')

print("Words in file {} counted !".format(PREPROCESSED_WITH_STEMMING_DATASET_PATH))
word_counts = count_words_in_file(PREPROCESSED_WITH_STEMMING_DATASET_PATH)
save_most_common_words(word_counts, './preprocessed_with_stemming_dataset_top_1000_words.txt')