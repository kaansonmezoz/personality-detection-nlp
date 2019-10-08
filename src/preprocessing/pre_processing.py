import pandas as pd
import re
import string
import nltk
from nltk.corpus import stopwords
#nltk.download('stopwords') # indirdikten sonra preprocessing altındaki stopwords dosyası ile güncelleyin.

pd.options.display.max_colwidth = 800
path = "/home/clausewitz/Projects/PycharmProjects/preprocessing/combined.csv"
df = pd.read_csv(path, delimiter = ',')

df=df.filter(['username','entry'])

df['subType'] = 'ISTP'
df['type'] = 'Explorers'

#########  küçük harfe çevirme
df.entry = df.entry.apply(str.lower)
#########  http/https/www ie başlayan linkleri kaldırma
df.entry = df.entry.replace(r'http\S+', '', regex=True).replace(r'www\S+', '', regex=True)
######### ingilizce karakterleri ve sözlük özelinde kullanılan keywordleri kaldırma
searchfor = ['bkz','w','x','--- spoiler ---','#']
df = df[~df.entry.str.contains('|'.join(searchfor))]
#########  sayıları kaldırma
df.entry = df.entry.str.replace('\d+', '')
#########  noktalama işaretlerini kaldırma
df.entry = df.entry.str.replace('|'
                                .join([re.escape(x) for x in string.punctuation]), " ")
######### tokenize ediyor
df.entry = df.apply(lambda row: nltk.word_tokenize(row['entry']), axis=1)

######### stopwords'leri siliyor
stop = stopwords.words('turkish')
df.entry = df.entry.apply(lambda x: [item for item in x if item not in stop])


pre_data = df.to_csv( "pre_data.csv", index=False, encoding='utf-8-sig') #export to csv

