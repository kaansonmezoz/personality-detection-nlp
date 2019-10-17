###### Required libraries ######
import pandas as pd
import re
import string
import nltk
from nltk.corpus import stopwords

###### Read data from the file ######
pd.options.display.max_colwidth = 800
path = "./Datasets/all_users.csv"
df = pd.read_csv(path, sep=';')
df = pd.DataFrame(data=df)
df = df.loc[:, ~df.columns.str.contains('^Unnamed')]

###### incorrectly drawn types ######
user = ['bencebuseferyazarim', 'nunavut','kendal','pier']
df = df[~df['user'].str.contains('|'.join(user))]

###### Raw data stats ######
df_raw_explorers = df.loc[df['type'] == "explorers"]
df_raw_analysts = df.loc[df['type'] == "analysts"]
df_raw_sentinels = df.loc[df['type'] == "sentinels"]
df_raw_diplomats = df.loc[df['type'] == "diplomats"]
print("----Raw data stats----")
print("Number of users of explorers: ", df_raw_explorers.user.nunique(),
      "\tNumber of entries of explorers: ",df['type'].value_counts()[3],
      "\nNumber of users of analysts : ", df_raw_analysts.user.nunique(),
      "\tNumber of entries of analysts : ",df['type'].value_counts()[1],
      "\nNumber of users of sentinels: ", df_raw_sentinels.user.nunique(),
      "\tNumber of entries of sentinels: ",df['type'].value_counts()[2],
      "\nNumber of users of diplomats: ", df_raw_diplomats.user.nunique(),
      "\tNumber of entries of diplomats: ",df['type'].value_counts()[0],
      "\nTotal number of users       : ",df.user.nunique(),
      "\tTotal number of entries       : ",df.shape[0])
df['RawDataTotalWords'] = [len(x.split()) for x in df['entry'].tolist()]
print("Total number of words       : ", df['RawDataTotalWords'].sum())

###### Data preprocessing ######
df.entry = df.entry.apply(lambda x: x.lower())

df.entry = df.entry.apply(lambda x: x.translate(str.maketrans('', '', '1234567890')))

# df.entry = df.entry.replace('\.' , ' ', regex=True).replace(',' , ' ', regex=True)

df.entry = df.entry.apply(lambda x: x.translate(str.maketrans('', '', string.punctuation)))

df.entry = df.entry.replace(r'http\S+', '', regex=True).replace(r'www\S+', '', regex=True)

searchfor = ['bkz', 'w', 'x', '--- spoiler ---', '#', '£', '€', 'have', 'love', 'trek', 'slam', 'grand']
df = df[~df.entry.str.contains('|'.join(searchfor))]

stop = stopwords.words('turkish')
df.entry = df.entry.apply(lambda x: ' '.join([word for word in x.split() if word not in (stop)]))

###### Post-processing stats ######
df_preprocessed_explorers = df.loc[df['type'] == "explorers"]
df_preprocessed_analysts = df.loc[df['type'] == "analysts"]
df_preprocessed_sentinels = df.loc[df['type'] == "sentinels"]
df_preprocessed_diplomats = df.loc[df['type'] == "diplomats"]
print("\n----Post-processing stats----")
print("Number of users of explorers: ", df_preprocessed_explorers.user.nunique(),
      "\tNumber of entries of explorers: ",df['type'].value_counts()[3],
      "\nNumber of users of analysts : ", df_preprocessed_analysts.user.nunique(),
      "\tNumber of entries of analysts : ",df['type'].value_counts()[1],
      "\nNumber of users of sentinels: ", df_preprocessed_sentinels.user.nunique(),
      "\tNumber of entries of sentinels: ",df['type'].value_counts()[2],
      "\nNumber of users of diplomats: ", df_preprocessed_diplomats.user.nunique(),
      "\tNumber of entries of diplomats: ",df['type'].value_counts()[0],
      "\nTotal number of users       : ",df.user.nunique(),
      "\tTotal number of entries       : ",df.shape[0])
df['preprocessedDataTotalWords'] = [len(x.split()) for x in df['entry'].tolist()]
print("Total number of words       : ", df['preprocessedDataTotalWords'].sum())

###### Filtered data between 10 to 150 words per entry ######
df_explorers = df.loc[(df['type'] == "explorers") &
                      (10 < df['preprocessedDataTotalWords']) &
                      (df['preprocessedDataTotalWords'] < 150)]
df_analysts = df.loc[(df['type'] == "analysts") &
                     (10 < df['preprocessedDataTotalWords']) &
                     (df['preprocessedDataTotalWords'] < 150)]
df_sentinels = df.loc[(df['type'] == "sentinels") &
                      (10 < df['preprocessedDataTotalWords']) &
                      (df['preprocessedDataTotalWords'] < 150)]
df_diplomats = df.loc[(df['type'] == "diplomats") &
                      (10 < df['preprocessedDataTotalWords']) &
                      (df['preprocessedDataTotalWords'] < 150)]
pdList_filtered = [df_explorers, df_analysts, df_sentinels , df_diplomats]
df_filtered = pd.concat(pdList_filtered)
print("\n----Filtered data between 10 to 150 words per entry----")
print("Number of users of explorers  : ", df_explorers.user.nunique(),
      "\tNumber of entries of explorers: ", df_explorers.shape[0],
      "\nNumber of users of analysts   : ", df_analysts.user.nunique(),
      "\tNumber of entries of analysts : ", df_analysts.shape[0],
      "\nNumber of users of sentinels  : ", df_sentinels.user.nunique(),
      "\tNumber of entries of sentinels: ", df_sentinels.shape[0],
      "\nNumber of users of diplomats  : ", df_diplomats.user.nunique(),
      "\tNumber of entries of diplomats: ", df_diplomats.shape[0],
      "\nTotal number of users         : ",df.user.nunique(),
      "\tTotal number of entries       : ",(df_explorers.shape[0]+df_analysts.shape[0]+
                                            df_sentinels.shape[0]+df_diplomats.shape[0]))
df_filtered['filteredDataTotalWords'] = [len(x.split()) for x in df_filtered['entry'].tolist()]
print("Total number of words         : ", df_filtered['filteredDataTotalWords'].sum())

###### Equal entries for each class ######
###### EE => Equal Entry ######
df_explorers_EE = df_explorers.head(df_preprocessed_explorers.shape[0])
df_analysts_EE = df_analysts.head(df_preprocessed_explorers.shape[0])
df_sentinels_EE = df_sentinels.head(df_preprocessed_explorers.shape[0])
df_diplomats_EE = df_diplomats.head(df_preprocessed_explorers.shape[0])
pdList_equalEntry = [df_explorers_EE, df_analysts_EE, df_diplomats_EE , df_diplomats_EE]
df_equalEntry = pd.concat(pdList_equalEntry)
print("\n----Equal entries for each class----")
print("Number of users of explorers  : ", df_explorers_EE.user.nunique(),
      "\tNumber of entries of explorers: ", df_explorers.shape[0],
      "\nNumber of users of analysts   : ", df_analysts_EE.user.nunique(),
      "\tNumber of entries of analysts : ", df_explorers.shape[0],
      "\nNumber of users of sentinels  : ", df_sentinels_EE.user.nunique(),
      "\tNumber of entries of sentinels: ", df_explorers.shape[0],
      "\nNumber of users of diplomats  : ", df_diplomats_EE.user.nunique(),
      "\tNumber of entries of diplomats: ", df_explorers.shape[0],
      "\nTotal number of users         : ",(df_explorers_EE.user.nunique()+df_analysts_EE.user.nunique()+
                                           df_sentinels_EE.user.nunique()+ df_diplomats_EE.user.nunique()),
      "\tTotal number of entries       : ",(df_explorers.shape[0]*4))
df_equalEntry['equalEntryDataTotalWords'] = [len(x.split()) for x in df_equalEntry['entry'].tolist()]
print("Total number of words         : ", df_equalEntry['equalEntryDataTotalWords'].sum())

###### Equal users for each class ######
###### EU => Equal User ###### #
df_explorers_EU = df_explorers.head(32757)
df_analysts_EU = df_analysts.head(44100)
df_sentinels_EU = df_sentinels.head(36500)
df_diplomats_EU = df_diplomats.head(40000)
pdList_equalUser = [df_explorers_EU, df_analysts_EU, df_sentinels_EU , df_diplomats_EU]
df_equalUser = pd.concat(pdList_equalUser)
print("\n----Equal users for each class----")
print("Number of users of explorers  : ", df_explorers.user.nunique(),
      "\tNumber of entries of explorers: ", df_explorers_EU.shape[0],
      "\nNumber of users of analysts   : ", df_explorers.user.nunique(),
      "\tNumber of entries of analysts : ", df_analysts_EU.shape[0],
      "\nNumber of users of sentinels  : ", df_explorers.user.nunique(),
      "\tNumber of entries of sentinels: ", df_sentinels_EU.shape[0],
      "\nNumber of users of diplomats  : ", df_explorers.user.nunique(),
      "\tNumber of entries of diplomats: ", df_diplomats_EU.shape[0],
      "\nTotal number of users         : ",(df_explorers.user.nunique()*4),
      "\tTotal number of entries       : ",(df_explorers_EU.shape[0]+df_analysts_EU.shape[0]+
                                           df_sentinels_EU.shape[0]+df_diplomats_EU.shape[0]))
df_equalUser['equalEntryDataTotalWords'] = [len(x.split()) for x in df_equalUser['entry'].tolist()]
print("Total number of words         : ", df_equalUser['equalEntryDataTotalWords'].sum())

###### Write to csv for Equal users and Equal entries for each class ######
pdList_EE = [df_explorers_EE, df_analysts_EE, df_sentinels_EE , df_diplomats_EE]
pdList_EU = [df_explorers_EU, df_analysts_EU, df_sentinels_EU , df_diplomats_EU]
df_EE = pd.concat(pdList_EE)
df_EU = pd.concat(pdList_EU)
df_EE.to_csv( "./Datasets/EqualEntry/equal_entries.csv",
              index=False, encoding='utf-8-sig')
df_EU.to_csv( "./Datasets/EqualUser/equal_users.csv",
              index=False, encoding='utf-8-sig')




