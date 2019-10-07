import pandas as pd
import re

pd.options.display.max_colwidth = 800
path = "/home/clausewitz/Projects/PycharmProjects/mbtı/merged.csv"
df = pd.read_csv(path)

#-----------------to lower case-------------------------

lowerCaseData = df.applymap(str.lower)

# ----------------to remove numbers---------------------

df['entry'] = df['entry'].str.replace('\d+', '')

# ----------------to remove punctions-------------------

def remove_punctuation(pattern, phrase):
    for pat in pattern:
        return (re.findall(pat, phrase))
        return ('\n')

pattern = ['[^,”!.?“@}*\'({:?\).$%;_]+']
#print("".join(remove_punctuation(pattern, df.entry[3])))
df.entry[3] = "".join(remove_punctuation(pattern, df.entry[3]))

# ----------to remove stopwords and tokenization---------

import nltk
from nltk.tokenize import word_tokenize

stop_words = nltk.corpus.stopwords.words('turkish')
tokens = word_tokenize(df.entry[3])
tokenizedWords = [i for i in tokens if not i in stop_words]
#print(tokenizedWords)

# ----------to tokenizedWords count----------------------

from collections import Counter

tokenizedWordsCounts = Counter(tokenizedWords)
tokenizedWordsCounts = tokenizedWordsCounts.most_common()

#print(tokenizedWordsCounts)



