###### Required libraries ######
import pandas as pd

###### Read data from the file ######
pd.options.display.max_colwidth = 800
path_ee = "./Datasets/EqualEntry/equal_entries.csv"
ddf_EE = pd.read_csv(path_ee, sep = ',')
ddf_EE = pd.DataFrame(data = ddf_EE)

path_eu = "./Datasets/EqualUser/equal_users.csv"
ddf_EU = pd.read_csv(path_eu, sep = ',')
ddf_EU = pd.DataFrame(data = ddf_EU)

###### For fasttext pereprocessing ######
ddf_EE_fasttext = ddf_EE.drop(ddf_EE.columns[[0, 3, 4, 5, 6, 7,8,9]], axis=1)
cols_ee = ddf_EE_fasttext.columns.tolist()
cols_ee = cols_ee[-1:] + cols_ee[:-1]
ddf_EE_fasttext = ddf_EE_fasttext[cols_ee]
ddf_EE_fasttext['type'] = '__label__' + ddf_EE_fasttext['type'].astype(str)

ddf_EU_fasttext = ddf_EU.drop(ddf_EU.columns[[0, 3, 4, 5, 6, 7,8,9]], axis=1)
cols_eu = ddf_EU_fasttext.columns.tolist()
cols_eu = cols_eu[-1:] + cols_eu[:-1]
ddf_EU_fasttext = ddf_EU_fasttext[cols_eu]
ddf_EU_fasttext['type'] = '__label__' + ddf_EU_fasttext['type'].astype(str)

###### Export to csv ######
ddf_EE_fasttext.to_csv( "./Datasets/Fasttext/equal_entries_fasttext.csv", header=False,
                        index=False, sep='\t', encoding='utf-8-sig', line_terminator="\n")
ddf_EU_fasttext.to_csv( "./Datasets/Fasttext/equal_users_fasttext.csv", header=False,
                        index=False, sep='\t', encoding='utf-8-sig', line_terminator="\n")