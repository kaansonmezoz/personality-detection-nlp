# PRE-REQUIREMENTS

* google drive içerisinde /mbti/all_users.csv yer almalıdır. Ya da ilgili kod kısmını kendinize göre değiştiriniz.
* stop_words_tr.txt adında Türkçe dili için "stop words" diye adlandırılan kelimelerin yer aldığı bir txt driveda mbti klasörünün altında olmalıdır.


## RESULTS ~ Based on Classes

- all_users_v1.csv used.

- max_features = 100

- no preprocessing made

- built-in nltk stop words have been used

- Accuracy : 0.4391385709189453

```
                                        Predicted 
         +-----------+-----------+-----------+-----------+-----------+
         |           | Analysts  | Diplomats | Explorers | Sentinels |
         +-----------+-----------+-----------+-----------+-----------+
         | Analysts  |   32029   |   23318   |     0     |     13    |
         +-----------+-----------+-----------+-----------+-----------+
ACTUAL   | Diplomats |   20189   |   38048   |     0     |     9     |
         +-----------+-----------+-----------+-----------+-----------+
         | Explorers |   6924    |   8326    |     16    |     8     |
         +-----------+-----------+-----------+-----------+-----------+
         | Sentinels |   14051   |   16777   |     0     |     73    |
         +-----------------------------------------------------------+

```
- all_users_v1.csv used.

- max_features = 1000

- no preprocessing made

- built-in nltk stop words have been used

- Accuracy : 0.4391385709189453


```
                                        Predicted 
         +-----------+-----------+-----------+-----------+-----------+
         |           | Analysts  | Diplomats | Explorers | Sentinels |
         +-----------+-----------+-----------+-----------+-----------+
         | Analysts  |   32029   |   23318   |     0     |     13    |
         +-----------+-----------+-----------+-----------+-----------+
ACTUAL   | Diplomats |   20189   |   38048   |     0     |     9     |
         +-----------+-----------+-----------+-----------+-----------+
         | Explorers |   6924    |   8326    |     16    |     8     |
         +-----------+-----------+-----------+-----------+-----------+
         | Sentinels |   14051   |   16777   |     0     |     73    |
         +-----------------------------------------------------------+

```

- all_users_v2.csv used.

- max_features = 1000

- no preprocessing made

- expanded stop words have been used

- Accuracy : 0.44630943358719827


```
                                        Predicted 
         +-----------+-----------+-----------+-----------+-----------+
         |           | Analysts  | Diplomats | Explorers | Sentinels |
         +-----------+-----------+-----------+-----------+-----------+
         | Analysts  |   50996   |   9180    |     2     |     9     |
         +-----------+-----------+-----------+-----------+-----------+
ACTUAL   | Diplomats |   34907   |   20744   |     2     |     12    |
         +-----------+-----------+-----------+-----------+-----------+
         | Explorers |   13169   |   3743    |     16    |     9     |
         +-----------+-----------+-----------+-----------+-----------+
         | Sentinels |   22922   |   5176    |     1     |     90    |
         +-----------------------------------------------------------+

```



Bu şu anlama geliyor tek başına yeterli değil yani preprocessing
kısmıyla alakalı bir durum var


## RESULTS ~ Based on Dimensions

- all_users_v1.csv used.

- max_features = 1000

- no preprocessing made

- built-in nltk stop words have been used

```

            Predicted                        

             +-------+-------+
             |   I   |   E   |
         +---+-------+-------+
ACTUAL   | I | 72120 | 10205 |              Accuracy : 0.5986193602493413
         +-----------+-------+
         | E | 53928 | 23528 |
         +-----------+-------+
         

            Predicted                        

             +----------+---------+
             |     N    |    S    |
         +---+----------+---------+
ACTUAL   | N |  113579  |    27   |              Accuracy : 0.71141750270683
         +---+----------+---------+
         | S |  46083   |    92   |
         +--------------+---------+


            Predicted                        

             +---------+---------+
             |    F    |    T    |
         +---+---------+---------+
ACTUAL   | F |  39202  |  41155  |              Accuracy : 0.6037451261414061
         +---+---------+---------+
         | T |  22159  |  57265  |
         +---+---------+---------+


            Predicted                        

             +---------+-------+
             |    P    |   J   |
         +---+---------+-------+
ACTUAL   | P |  62706  | 19379 |              Accuracy : 0.5851321496298058
         +---+---------+-------+
         | J |  46909  | 30787 |
         +---+---------+-------+
         
``` 
 
- all_users_v2.csv used

- max_features = 1000

- expanded stop_words used.

- no preprocessing step.
         


```

            Predicted                        

             +-------+-------+
             |   I   |   E   |
         +---+-------+-------+
ACTUAL   | I | 59510 | 20619 |              Accuracy : 0.6000136664637404
         +-----------+-------+
         | E | 43770 | 37079 |
         +-----------+-------+
         

            Predicted                        

             +----------+---------+
             |     N    |    S    |
         +---+----------+---------+
ACTUAL   | N |  115804  |    48   |              Accuracy : 0.7202723353501721
         +---+----------+---------+
         | S |  44982   |    144  |
         +--------------+---------+


            Predicted                        

             +---------+---------+
             |    F    |    T    |
         +---+---------+---------+
ACTUAL   | F |  22559  |  52718  |              Accuracy : 0.6084620258668887
         +---+---------+---------+
         | T |  10311  |  75390  |
         +---+---------+---------+


            Predicted                        

             +---------+-------+
             |    P    |   J   |
         +---+---------+-------+
ACTUAL   | P |  54549  | 28484 |              Accuracy : 0.5946775335760166
         +---+---------+-------+
         | J |  36764  | 41181 |
         +---+---------+-------+
         
``` 

