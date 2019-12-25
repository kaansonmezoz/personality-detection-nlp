import pandas as pd

RAW_DATASET_PATH = '../data/raw_data/dataset_v2/all_users_v2.csv'
ELIMINATED_DATASET_PATH = '../data/eliminated_data/eliminated_all_users_v2.csv'
PREPROCESSED_ZEMBEREK_DATASET_PATH = '../data/preprocessed_data/zemberek/preprocessed_dataset_zemberek.csv'
PREPROCESSED_NO_STEMMING_DATASET_PATH = '../data/preprocessed_data/python/preprocessed_dataset_no_stemming.csv'
PREPROCESSED_WITH_STEMMING_DATASET_PATH = '../data/preprocessed_data/python/preprocessed_dataset_with_stemming.csv'


def count_words_in_file(file_path):
    word_counts = {}
    
    df = pd.read_csv(file_path, sep = ';', header = 0)
    df['entry'] = df['entry'].str.lower()
    
    for index, row in df.iterrows():
        entry = row['entry']
        count_words_in_entry(word_counts, entry)
    
    return word_counts
    
def count_words_in_entry(word_counts, entry):
    words = str(entry).split()
    
    for word in words:
        if word in word_counts:
            word_counts[word] += 1
        else:
            word_counts[word] = 1

def get_sorted_word_counts_dict(word_counts):
    return sorted(word_counts.items(), key = lambda item: item[1], reverse = True)

def save_most_common_words(word_counts, file_path, top = 1000):
    sorted_keys = []
    
    for word, count in get_sorted_word_counts_dict(word_counts):
        sorted_keys.append(word)
    
    with open(file_path, 'w') as file:
        for i in range(top):
            word = sorted_keys[i]
            count = word_counts[word]
            
            file.write("{}  :  {}\n".format(word, count))
          
print("Counting file {} !".format(RAW_DATASET_PATH))
word_counts = count_words_in_file(RAW_DATASET_PATH)
save_most_common_words(word_counts, './raw_dataset_top_1000_words.txt')
print("Done !")

print("Counting file {} !".format(ELIMINATED_DATASET_PATH))
word_counts = count_words_in_file(ELIMINATED_DATASET_PATH)
save_most_common_words(word_counts, './eliminated_dataset_top_1000_words.txt')
print("Done !")

print("Counting file {} !".format(PREPROCESSED_ZEMBEREK_DATASET_PATH))
word_counts = count_words_in_file(PREPROCESSED_ZEMBEREK_DATASET_PATH)
save_most_common_words(word_counts, './preprocessed_zemberek_dataset_top_1000_words.txt')
print("Done !")


print("Counting file {} !".format(PREPROCESSED_NO_STEMMING_DATASET_PATH))
word_counts = count_words_in_file(PREPROCESSED_NO_STEMMING_DATASET_PATH)
save_most_common_words(word_counts, './preprocessed_no_stemming_dataset_top_1000_words.txt')
print("Done !")

print("Counting file {} !!".format(PREPROCESSED_WITH_STEMMING_DATASET_PATH))
word_counts = count_words_in_file(PREPROCESSED_WITH_STEMMING_DATASET_PATH)
save_most_common_words(word_counts, './preprocessed_with_stemming_dataset_top_1000_words.txt')
print("Done !")