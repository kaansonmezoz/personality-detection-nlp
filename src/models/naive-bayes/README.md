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
ACTUAL   | I | 35954 | 28884 |                 Accuracy : 0.5586161690840771
         +-----------+-------+
         | E | 29026 | 37337 |
         +-----------+-------+
         

            Predicted                        

             +----------+---------+
             |     N    |    S    |
         +---+----------+---------+
ACTUAL   | N |  93999   |   103   |             Accuracy : 0.7171972774597755
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