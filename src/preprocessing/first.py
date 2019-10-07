import os
import glob
import pandas as pd

path = '/home/clausewitz/Projects/PycharmProjects/mbtı/ıstp'
os.chdir(path)
extension = 'csv'
all_filenames = [i for i in glob.glob('*.{}'.format(extension))]
combined_csv = pd.concat([pd.read_csv(f) for f in all_filenames ]) #combine all files in the list
combined_csv = combined_csv.to_csv( "combined.csv", index=False, encoding='utf-8-sig') #export to csv

#print(combined_csv)




