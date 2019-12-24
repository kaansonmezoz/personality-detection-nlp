# PRE-REQUIREMENTS

* google drive içerisinde /mbti/all_users.csv yer almalıdır. Ya da ilgili kod kısmını kendinize göre değiştiriniz.
* stop_words_tr.txt adında Türkçe dili için "stop words" diye adlandırılan kelimelerin yer aldığı bir txt driveda mbti klasörünün altında olmalıdır.


## RESULTS ~ Based on Classes

### Experiment - 1

- all_users_v2.csv used.

- random_state=42, test_split=0.20

- tf-idf denendi max_features = 5000, sublinear_tf=True, norm='l2', encoding='utf-8', ngram_range=(1, 2), analyzer = 'word', token_pattern=r'\w{1,}'

- no preprocessing made

- expanded stop words used

- Accuracy : 0.42656251213281254

! Shuffle denenmeli...

```
                                        Predicted 
         +-----------+-----------+-----------+-----------+-----------+
         |           | Analysts  | Diplomats | Explorers | Sentinels |
         +-----------+-----------+-----------+-----------+-----------+
         | Analysts  |   38435   |   9521    |     0     |     95    |
         +-----------+-----------+-----------+-----------+-----------+
ACTUAL   | Diplomats |   28056   |   16309   |     1     |     123   |
         +-----------+-----------+-----------+-----------+-----------+
         | Explorers |   10084   |   3348    |     0     |     47    |
         +-----------+-----------+-----------+-----------+-----------+
         | Sentinels |   17542   |   5030    |     2     |     190   |
         +-----------------------------------------------------------+

```

### Experiment - 2

- preprocessed_dataset_zemberek.csv used

- random_state=42, test_split=0.20

- tf-idf denendi max_features = 5000, sublinear_tf=True, norm='l2', encoding='utf-8', ngram_range=(1, 2), analyzer = 'word', token_pattern=r'\w{1,}'

- lemmatization, normalization made.

- expanded stop words used.

- accuracy : 0.42599632244357427


```
                                        Predicted 
         +-----------+-----------+-----------+-----------+-----------+
         |           | Analysts  | Diplomats | Explorers | Sentinels |
         +-----------+-----------+-----------+-----------+-----------+
         | Analysts  |   27004   |   10947   |     0     |     111   |
         +-----------+-----------+-----------+-----------+-----------+
ACTUAL   | Diplomats |   19543   |   17545   |     1     |     94    |
         +-----------+-----------+-----------+-----------+-----------+
         | Explorers |   7093    |   3804    |     1     |     45    |
         +-----------+-----------+-----------+-----------+-----------+
         | Sentinels |   12518   |   6092    |     0     |     163   |
         +-----------------------------------------------------------+

```

### Experiment - 3

- preprocessed_dataset_with_stemming.csv used

- random_state=42, test_split=0.20

- tf-idf denendi max_features = 5000, sublinear_tf=True, norm='l2', encoding='utf-8', ngram_range=(1, 2), analyzer = 'word', token_pattern=r'\w{1,}'

- expanded stop words used.

- accuracy : 0.4282733785534639


```
                                        Predicted 
         +-----------+-----------+-----------+-----------+-----------+
         |           | Analysts  | Diplomats | Explorers | Sentinels |
         +-----------+-----------+-----------+-----------+-----------+
         | Analysts  |   29431   |   8606    |     0     |     67    |
         +-----------+-----------+-----------+-----------+-----------+
ACTUAL   | Diplomats |   21938   |   15372   |     1     |     67    |
         +-----------+-----------+-----------+-----------+-----------+
         | Explorers |   7795    |   3153    |     0     |     29    |
         +-----------+-----------+-----------+-----------+-----------+
         | Sentinels |   13712   |   4646    |     0     |     152   |
         +-----------------------------------------------------------+

```

### Experiment - 4

- preprocessed_dataset_with_no_stemming.csv used

- random_state=42, test_split=0.20

- tf-idf denendi max_features = 5000, sublinear_tf=True, norm='l2', encoding='utf-8', ngram_range=(1, 2), analyzer = 'word', token_pattern=r'\w{1,}'

- expanded stop words used.

- accuracy : 0.4276541422147702


```
                                        Predicted 
         +-----------+-----------+-----------+-----------+-----------+
         |           | Analysts  | Diplomats | Explorers | Sentinels |
         +-----------+-----------+-----------+-----------+-----------+
         | Analysts  |   29375   |   8644    |     0     |     85    |
         +-----------+-----------+-----------+-----------+-----------+
ACTUAL   | Diplomats |   21923   |   15377   |     1     |     76    |
         +-----------+-----------+-----------+-----------+-----------+
         | Explorers |   7800    |   3150    |     2     |     25    |
         +-----------+-----------+-----------+-----------+-----------+
         | Sentinels |   13750   |   4624    |     0     |     136   |
         +-----------------------------------------------------------+

```

### Experiment - 5

- preprocessed_dataset_with_no_stemming.csv used

- random_state=42, test_split=0.20

- tf used for feature extraction

- expanded stop words used.

- accuracy : 0.44398292813047785


```
                                        Predicted 
         +-----------+-----------+-----------+-----------+-----------+
         |           | Analysts  | Diplomats | Explorers | Sentinels |
         +-----------+-----------+-----------+-----------+-----------+
         | Analysts  |   30874   |   7230    |     0     |     0     |
         +-----------+-----------+-----------+-----------+-----------+
ACTUAL   | Diplomats |   21660   |   15716   |     0     |     1     |
         +-----------+-----------+-----------+-----------+-----------+
         | Explorers |   7959    |   3018    |     0     |     0     |
         +-----------+-----------+-----------+-----------+-----------+
         | Sentinels |   14195   |   4301    |     0     |     14    |
         +-----------------------------------------------------------+

```

### Experiment - 6

- preprocessed_dataset_with_stemming.csv used

- random_state=42, test_split=0.20

- tf used for feature extraction

- expanded stop words used.

- accuracy : 0.43932436552092063


```
                                        Predicted 
         +-----------+-----------+-----------+-----------+-----------+
         |           | Analysts  | Diplomats | Explorers | Sentinels |
         +-----------+-----------+-----------+-----------+-----------+
         | Analysts  |   30822   |   7281    |     0     |     1     |
         +-----------+-----------+-----------+-----------+-----------+
ACTUAL   | Diplomats |   22099   |   15277   |     0     |     1     |
         +-----------+-----------+-----------+-----------+-----------+
         | Explorers |   8077    |   2899    |     1     |     0     |
         +-----------+-----------+-----------+-----------+-----------+
         | Sentinels |   14256   |   4238    |     1     |     15    |
         +-----------------------------------------------------------+

```


### Experiment - 7

- preprocessed_dataset_with_zemberek.csv used

- random_state=42, test_split=0.20

- tf used for feature extraction

- expanded stop words used.

- accuracy : 0.4355141433484818


```
                                        Predicted 
         +-----------+-----------+-----------+-----------+-----------+
         |           | Analysts  | Diplomats | Explorers | Sentinels |
         +-----------+-----------+-----------+-----------+-----------+
         | Analysts  |   26812   |   11247   |     0     |     3     |
         +-----------+-----------+-----------+-----------+-----------+
ACTUAL   | Diplomats |   18295   |   18883   |     0     |     5     |
         +-----------+-----------+-----------+-----------+-----------+
         | Explorers |   6890    |   4047    |     3     |     3     |
         +-----------+-----------+-----------+-----------+-----------+
         | Sentinels |   12274   |   6485    |     1     |     14    |
         +-----------------------------------------------------------+

```

### Experiment - 8

- preprocessed_dataset_with_no_stemming.csv used

- random_state=42, test_split=0.20

- tf used for feature extraction

- equal entry count used for each class

- expanded stop words used.

- accuracy : 0.37360861350754593


```
                                        Predicted 
         +-----------+-----------+-----------+-----------+-----------+
         |           | Analysts  | Diplomats | Explorers | Sentinels |
         +-----------+-----------+-----------+-----------+-----------+
         | Analysts  |   26812   |   11247   |     0     |     3     |
         +-----------+-----------+-----------+-----------+-----------+
ACTUAL   | Diplomats |   18295   |   18883   |     0     |     5     |
         +-----------+-----------+-----------+-----------+-----------+
         | Explorers |   6890    |   4047    |     3     |     3     |
         +-----------+-----------+-----------+-----------+-----------+
         | Sentinels |   12274   |   6485    |     1     |     14    |
         +-----------------------------------------------------------+

```



### Experiment - 9

- preprocessed_dataset_with_stemming.csv used

- random_state=42, test_split=0.20

- tf used for feature extraction

- equal entry count used for each class

- expanded stop words used.

- accuracy : 0.3643896109808563


```
                                        Predicted 
         +-----------+-----------+-----------+-----------+-----------+
         |           | Analysts  | Diplomats | Explorers | Sentinels |
         +-----------+-----------+-----------+-----------+-----------+
         | Analysts  |   4506    |   1092    |    1859   |    3379   |
         +-----------+-----------+-----------+-----------+-----------+
ACTUAL   | Diplomats |   2867    |   2449    |    1947   |    3755   |
         +-----------+-----------+-----------+-----------+-----------+
         | Explorers |   2844    |   1089    |    3373   |    3724   |
         +-----------+-----------+-----------+-----------+-----------+
         | Sentinels |   2675    |   1016    |    1676   |    5680   |
         +-----------------------------------------------------------+

```

### Experiment - 10

- preprocessed_dataset_with_zemberek.csv used

- random_state=42, test_split=0.20

- tf used for feature extraction

- equal entry count used for each class

- normalization and lemmatization applied.

- expanded stop words used.

- accuracy : 0.3539267015706806


```
                                        Predicted 
         +-----------+-----------+-----------+-----------+-----------+
         |           | Analysts  | Diplomats | Explorers | Sentinels |
         +-----------+-----------+-----------+-----------+-----------+
         | Analysts  |   4002    |   1497    |    2291   |    3335   |
         +-----------+-----------+-----------+-----------+-----------+
ACTUAL   | Diplomats |   2543    |   2718    |    2266   |    3367   |
         +-----------+-----------+-----------+-----------+-----------+
         | Explorers |   2501    |   1492    |    3689   |    3252   |
         +-----------+-----------+-----------+-----------+-----------+
         | Sentinels |   2471    |   1295    |    2072   |    5139   |
         +-----------------------------------------------------------+

```



## RESULTS ~ Based on Dimensions

### Experiment - 1

- all_users_v2.csv used.

- random_state=42, test_split=0.20

- tf-idf denendi max_features = 5000, sublinear_tf=True, norm='l2', encoding='utf-8', ngram_range=(1, 2), analyzer = 'word', token_pattern=r'\w{1,}'

- no preprocessing made

- expanded stop words used

! k-fold cross-validation denenmeli

```

            Predicted                        

             +-------+-------+
             |   I   |   E   |
         +---+-------+-------+
ACTUAL   | I | 58867 | 21303 |              Accuracy : 0.5671209730522183
         +-----------+-------+
         | E | 48381 | 32427 |
         +-----------+-------+
         

            Predicted                        

             +----------+---------+
             |     N    |    S    |
         +---+----------+---------+
ACTUAL   | N |  115527  |    25   |              Accuracy : 0.7178744921666315
         +---+----------+---------+
         | S |  45391   |    35   |
         +--------------+---------+


            Predicted                        

             +---------+---------+
             |    F    |    T    |
         +---+---------+---------+
ACTUAL   | F |  23204  |  51749  |              Accuracy : 0.5870181018524271
         +---+---------+---------+
         | T |  14732  |  71293  |
         +---+---------+---------+


            Predicted                        

             +---------+-------+
             |    P    |   J   |
         +---+---------+-------+
ACTUAL   | P |  53471  | 29220 |              Accuracy : 0.5638285976965797
         +---+---------+-------+
         | J |  40994  | 37293 |
         +---+---------+-------+
         
``` 

### Experiment - 2

- preprocessed_dataset_zemberek.csv used

- random_state=42, test_split=0.20

- tf-idf denendi max_features = 5000, sublinear_tf=True, norm='l2', encoding='utf-8', ngram_range=(1, 2), analyzer = 'word', token_pattern=r'\w{1,}'

- lemmatization, normalization made.

- expanded stop words used.


```

            Predicted                        

             +-------+-------+
             |   I   |   E   |
         +---+-------+-------+
ACTUAL   | I | 35954 | 28884 |                 Accuracy : 0.5687523816782257
         +-----------+-------+
         | E | 29026 | 37337 |
         +-----------+-------+
         

            Predicted                        

             +----------+---------+
             |     N    |    S    |
         +---+----------+---------+
ACTUAL   | N |  93999   |   103   |             Accuracy : 0.7192515814343419
         +---+----------+---------+
         | S |  37001   |   98    |
         +--------------+---------+


            Predicted                        

             +---------+---------+
             |    F    |    T    |
         +---+---------+---------+
ACTUAL   | F |  24569  |  37928  |              Accuracy : 0.586740954718333
         +---+---------+---------+
         | T |  16292  |  52412  |
         +---+---------+---------+


            Predicted                        

             +---------+-------+
             |    P    |   J   |
         +---+---------+-------+
ACTUAL   | P |  44226  | 29583 |              Accuracy : 0.5625643097232491
         +---+---------+-------+
         | J |  34736  | 22656 |
         +---+---------+-------+
         
``` 


### Experiment - 3

- preprocessed_dataset_with_stemming.csv used

- random_state=42, test_split=0.20

- tf-idf denendi max_features = 5000, sublinear_tf=True, norm='l2', encoding='utf-8', ngram_range=(1, 2), analyzer = 'word', token_pattern=r'\w{1,}'

- lemmatization, normalization made.

- expanded stop words used.


```

            Predicted                        

             +-------+-------+
             |   I   |   E   |
         +---+-------+-------+
ACTUAL   | I | 47682 | 17122 |                 Accuracy : 0.5700099077814191
         +-----------+-------+
         | E | 39462 | 26944 |
         +-----------+-------+
         

            Predicted                        

             +----------+---------+
             |     N    |    S    |
         +---+----------+---------+
ACTUAL   | N |  94329   |   44    |             Accuracy : 0.7171972774597755
         +---+----------+---------+
         | S |  36809   |   28    |
         +--------------+---------+


            Predicted                        

             +---------+---------+
             |    F    |    T    |
         +---+---------+---------+
ACTUAL   | F |  21885  |  40584  |              Accuracy : 0.5892919746970505
         +---+---------+---------+
         | T |  13305  |  55436  |
         +---+---------+---------+


            Predicted                        

             +---------+-------+
             |    P    |   J   |
         +---+---------+-------+
ACTUAL   | P |  41202  | 25896 |              Accuracy : 0.5651550948860605
         +---+---------+-------+
         | J |  31160  | 32952 |
         +---+---------+-------+
         
``` 


### Experiment - 4

- preprocessed_dataset_with_no_stemming.csv used

- random_state=42, test_split=0.20

- tf-idf denendi max_features = 5000, sublinear_tf=True, norm='l2', encoding='utf-8', ngram_range=(1, 2), analyzer = 'word', token_pattern=r'\w{1,}'

- lemmatization, normalization made.

- expanded stop words used.


```

            Predicted                        

             +-------+-------+
             |   I   |   E   |
         +---+-------+-------+
ACTUAL   | I | 45999 | 18805 |                 Accuracy : 0.5586161690840771
         +-----------+-------+
         | E | 37614 | 28792 |
         +-----------+-------+
         

            Predicted                        

             +----------+---------+
             |     N    |    S    |
         +---+----------+---------+
ACTUAL   | N |  94317   |   40    |             Accuracy : 0.7191601249904733
         +---+----------+---------+
         | S |  36809   |   44    |
         +--------------+---------+


            Predicted                        

             +---------+---------+
             |    F    |    T    |
         +---+---------+---------+
ACTUAL   | F |  21647  |  40822  |              Accuracy : 0.588407895739654
         +---+---------+---------+
         | T |  13183  |  55558  |
         +---+---------+---------+


            Predicted                        

             +---------+-------+
             |    P    |   J   |
         +---+---------+-------+
ACTUAL   | P |  41170  | 25928 |              Accuracy : 0.564431064705434
         +---+---------+-------+
         | J |  31223  | 32889 |
         +---+---------+-------+
         
``` 




### Experiment - 5

- preprocessed_dataset_with_no_stemming.csv used

- random_state=42, test_split=0.20

- tf used for feature extraction

- expanded stop words used.


```

            Predicted                        

             +-------+-------+
             |   I   |   E   |
         +---+-------+-------+
ACTUAL   | I | 44307 | 20497 |                 Accuracy : 0.5986129106013262
         +-----------+-------+
         | E | 32169 | 34237 |
         +-----------+-------+
         

            Predicted                        

             +----------+---------+
             |     N    |    S    |
         +---+----------+---------+
ACTUAL   | N |  94356   |   1     |             Accuracy : 0.7193125523969209
         +---+----------+---------+
         | S |  36828   |   25    |
         +--------------+---------+


            Predicted                        

             +---------+---------+
             |    F    |    T    |
         +---+---------+---------+
ACTUAL   | F |  20039  |  42430  |              Accuracy : 0.6062495236643548
         +---+---------+---------+
         | T |  9234   |  59507  |
         +---+---------+---------+


            Predicted                        

             +---------+-------+
             |    P    |   J   |
         +---+---------+-------+
ACTUAL   | P |  46024  | 21074 |              Accuracy : 0.5884612453319107
         +---+---------+-------+
         | J |  32924  | 31188 |
         +---+---------+-------+
         
``` 

### Experiment - 6

- preprocessed_dataset_with_stemming.csv used

- random_state=42, test_split=0.20

- tf used for feature extraction

- expanded stop words used.


```

            Predicted                        

             +-------+-------+
             |   I   |   E   |
         +---+-------+-------+
ACTUAL   | I | 46161 | 18643 |                 Accuracy : 0.5907857632802378
         +-----------+-------+
         | E | 35050 | 31356 |
         +-----------+-------+
         

            Predicted                        

             +----------+---------+
             |     N    |    S    |
         +---+----------+---------+
ACTUAL   | N |  94354   |   3     |             Accuracy : 0.7193125523969209
         +---+----------+---------+
         | S |  36826   |   27    |
         +--------------+---------+


            Predicted                        

             +---------+---------+
             |    F    |    T    |
         +---+---------+---------+
ACTUAL   | F |  20182  |  42287  |              Accuracy : 0.6028656352412164
         +---+---------+---------+
         | T |  9821   |  58920  |
         +---+---------+---------+


            Predicted                        

             +---------+-------+
             |    P    |   J   |
         +---+---------+-------+
ACTUAL   | P |  46130  | 20968 |              Accuracy : 0.5823946345552931
         +---+---------+-------+
         | J |  33826  | 30286 |
         +---+---------+-------+
         
``` 

### Experiment - 7

- preprocessed_dataset_with_zemberek.csv used

- random_state=42, test_split=0.20

- tf used for feature extraction

- expanded stop words used.


```

            Predicted                        

             +-------+-------+
             |   I   |   E   |
         +---+-------+-------+
ACTUAL   | I | 32964 | 31874 |                 Accuracy : 0.5789894894093796
         +-----------+-------+
         | E | 23363 | 43000 |
         +-----------+-------+
         

            Predicted                        

             +----------+---------+
             |     N    |    S    |
         +---+----------+---------+
ACTUAL   | N |  94092   |   10    |             Accuracy : 0.7173192277497885
         +---+----------+---------+
         | S |  37078   |   21    |
         +--------------+---------+


            Predicted                        

             +---------+---------+
             |    F    |    T    |
         +---+---------+---------+
ACTUAL   | F |  24909  |  37588  |              Accuracy : 0.6007499942835801
         +---+---------+---------+
         | T |  14794  |  53910  |
         +---+---------+---------+


            Predicted                        

             +---------+-------+
             |    P    |   J   |
         +---+---------+-------+
ACTUAL   | P |  47931  | 18951 |              Accuracy : 0.5745992789689103
         +---+---------+-------+
         | J |  36862  | 27457 |
         +---+---------+-------+
         
``` 

### Experiment - 8

- preprocessed_dataset_with_no_stemming.csv used

- equal entry count used for the classes

- random_state=42, test_split=0.20

- tf used for feature extraction

- expanded stop words used.


```

            Predicted                        

             +-------+-------+
             |   I   |   E   |
         +---+-------+-------+
ACTUAL   | I | 48891 | 15956 |                 Accuracy : 0.5789894894093796
         +-----------+-------+
         | E | 35945 | 28639 |
         +-----------+-------+
         

            Predicted                        

             +----------+---------+
             |     N    |    S    |
         +---+----------+---------+
ACTUAL   | N |  20850   |  16208  |             Accuracy : 0.59900642040933
         +---+----------+---------+
         | S |  13086   |  23708  |
         +--------------+---------+


            Predicted                        

             +---------+---------+
             |    F    |    T    |
         +---+---------+---------+
ACTUAL   | F |  27815  |  34898  |              Accuracy : 0.5999311509794975
         +---+---------+---------+
         | T |  15075  |  47123  |
         +---+---------+---------+


            Predicted                        

             +---------+-------+
             |    P    |   J   |
         +---+---------+-------+
ACTUAL   | P |  35290  | 28835 |              Accuracy : 0.5925995404023824
         +---+---------+-------+
         | J |  23287  | 40526 |
         +---+---------+-------+
         
``` 



### Experiment - 9

- preprocessed_dataset_with_stemming.csv used

- equal entry count used for the classes

- random_state=42, test_split=0.20

- tf used for feature extraction

- expanded stop words used.


```

            Predicted                        

             +-------+-------+
             |   I   |   E   |
         +---+-------+-------+
ACTUAL   | I | 50353 | 14428 |                 Accuracy : 0.592640093949672
         +-----------+-------+
         | E | 38297 | 26353 |
         +-----------+-------+
         

            Predicted                        

             +----------+---------+
             |     N    |    S    |
         +---+----------+---------+
ACTUAL   | N |  19920   |  17123  |             Accuracy : 0.5963007095271624
         +---+----------+---------+
         | S |  12691   |  24118  |
         +--------------+---------+


            Predicted                        

             +---------+---------+
             |    F    |    T    |
         +---+---------+---------+
ACTUAL   | F |  27122  |  35503  |              Accuracy : 0.5942150811377701
         +---+---------+---------+
         | T |  15184  |  47102  |
         +---+---------+---------+


            Predicted                        

             +---------+-------+
             |    P    |   J   |
         +---+---------+-------+
ACTUAL   | P |  35397  | 28721 |              Accuracy : 0.5869874470446622
         +---+---------+-------+
         | J |  24119  | 39701 |
         +---+---------+-------+
         
``` 


### Experiment - 10

- preprocessed_dataset_with_zemberek.csv used

- random_state=42, test_split=0.20

- tf used for feature extraction

- equal entry count used for each class

- normalization and lemmatization applied.

- expanded stop words used.


```

            Predicted                        

             +-------+-------+
             |   I   |   E   |
         +---+-------+-------+
ACTUAL   | I | 38389 | 26043 |                 Accuracy : 0.5812767535658543
         +-----------+-------+
         | E | 28149 | 36841 |
         +-----------+-------+
         

            Predicted                        

             +----------+---------+
             |     N    |    S    |
         +---+----------+---------+
ACTUAL   | N |  20400   |  16442  |             Accuracy : 0.5872579553148274
         +---+----------+---------+
         | S |  14039   |  22969  |
         +--------------+---------+


            Predicted                        

             +---------+---------+
             |    F    |    T    |
         +---+---------+---------+
ACTUAL   | F |  32997  |  29313  |              Accuracy : 0.5895487734580157
         +---+---------+---------+
         | T |  21954  |  40640  |
         +---+---------+---------+


            Predicted                        

             +---------+-------+
             |    P    |   J   |
         +---+---------+-------+
ACTUAL   | P |  39369  | 24634 |              Accuracy : 0.5746032986789651
         +---+---------+-------+
         | J |  29787  | 34140 |
         +---+---------+-------+
         
``` 