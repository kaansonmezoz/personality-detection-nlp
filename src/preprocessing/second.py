import pandas as pd

pd.options.display.max_colwidth = 800


path = "/home/clausewitz/Projects/PycharmProjects/mbtı/ıstp/combined.csv"

df = pd.read_csv(path)

df = df.groupby('username')['entry'].apply(' '.join).reset_index()

df.to_csv('merged.csv', index=False)