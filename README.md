

```
@INPROCEEDINGS{9302239,
  author={Sönmezöz, Kaan and Uğur, Özgür and Diri, Banu},
  booktitle={2020 28th Signal Processing and Communications Applications Conference (SIU)}, 
  title={MBTI Personality Prediction With Machine Learning}, 
  year={2020},
  volume={},
  number={},
  pages={1-4},
  doi={10.1109/SIU49456.2020.9302239}}
```


## İçerik
- [Proje Tanımı](https://github.com/kaansonmezoz/personality-detection-nlp#proje-tanımı)
- [Projenin Genel Yapısı](https://github.com/kaansonmezoz/personality-detection-nlp#projenin-genel-yapısı)
- [Repository Hiyerarşisi](https://github.com/kaansonmezoz/personality-detection-nlp#repository-hiyerarşisi)
- [Kullanılan Teknolojiler](https://github.com/kaansonmezoz/personality-detection-nlp#kullanılan-teknolojiler)
- [Gereksinimler](https://github.com/kaansonmezoz/personality-detection-nlp#gereksinimler)
- [Neden MBTI](https://github.com/kaansonmezoz/personality-detection-nlp#neden-mbti)
- [Oluşturulan Veriseti](https://github.com/kaansonmezoz/personality-detection-nlp#oluşturulan-veriseti)
- [Diğer Çalışmalar](https://github.com/kaansonmezoz/personality-detection-nlp#diğer-çalışmalar)
- [Kamuya Açık Verisetleri](https://github.com/kaansonmezoz/personality-detection-nlp#kamuya-açık-verisetleri)


## Projenin Genel Yapısı

![Project-Phases](https://raw.githubusercontent.com/kaansonmezoz/personality-detection-nlp/0836b492d89fca540aa51effca5b5b8778e2c862/Project-Phases.png)

1. Crawling
    - Verisetinin oluşturulduğu aşamadır.
    - eksisozluk.com'dan daha önceden belirlenmiş olan kullanıcıların entryleri indirilir.
2. Elimination
    - Crawling sonucunda oluşan veriseti kullanılır.
    - **bkz**, **spoiler** ve  **#** içeren entryler silinir.  Bu kelimeler bir olayı olduğu gibi aktarmak için kullanılmaktadır. Herhangi bir öznel ifade içermediğinden kullanıcıların kişiliklerinin tahmin edilmesinde önemli bir rol oynamadıkları düşünülmüştür ve silinmişlerdir.

3. Pre-processing
    - Üç farklı şekilde preprocessing yapılmıştır. Python dilinde Normalizasyon ve Stemming ile alakalı yeterli destek olmadığı için Zemberek kütüphanesi kullanıldı.
    
    - Temelde yapılan pre-processing aşamaları
        - Uppercase to lowercase
        - Linklerin silinmesi
        - Rakamların silinmesi
        - Noktalama işaretlerinin silinmesi
        - Stop words çıkarılması

    - Snowball Stemmer'ın kullanılması
        - Yukarıdakilere ek olarak Python dili için geliştirilmiş olan SnowballStemmer içerisindeki TurkishStemmer kullanıldı.
            - Snowball Stemmer
    
    - Zemberek
        - Temelde yapılan işlemlere ek olarak:
            - Normalizasyon
            - Lemmatization

4. Feature Extraction
    - TF
    - TF-IDF
    - LDA
    - Word vectors

5. Model Training
    - Naive Bayes
    - SVM
    - RandomForest
    - fastText Classification

6. Model Evaluation
    - Confussion Matrix
    - Accuracy
    - Precision
    - Recall
    - F-Score

## Repository Hiyerarşisi
```

            .
            ├── data/                                   
            |    ├── eliminated_data/
            |    |   └── eliminated_all_users_v2.zip
            |    ├── preprocessed_data/
            |    |   ├── python/
            |    |   |   └── preprocessed_dataset.zip
            |    |   └── zemberek/
            |    |       └── preprocessed_dataset_zemberek.zip
            |    ├── raw_data/
            |    |   ├── dataset_v1/
            |    |   |   └── dataset_v1_structured.zip
            |    |   └── dataset_v2/
            |    |       ├── all_users_v2.csv
            |    |       ├── all_users_v2.zip
            |    |       └── dataset_v2_structured.zip
            |    ├── README.md
            |    ├── splitted_data_660_user_from_all_headlines.xlsx
            |    └── stop_words_tr.txt
            ├── resources/ # Bu klasör altında bu proje ile alakalı makaleler ve yararlanıbilecek kaynaklar yer alır.        
            ├── src/
            |   ├── crawler/
            |   ├── elimination/
            |   ├── feature-extraction/
            |   ├── models/
            |   ├── preprocessing/
            |   ├── count_words.py
            |   └── README.md
            ├── .gitattributes                 
            ├── .gitignore
            └── README.md


```

## Kullanılan Teknolojiler
- NodeJS
- Java
- Python
- npm
- Google Colab

## Gereksinimler
- Veri setini baştan kendiniz oluşturacaksanız
    - NodeJS'in bilgisayarınızda kurulu olması gerekmektedir. Bilgisayarınızda kurulu olup olmadığını anlamak için:
        
        ```node --version``` 

      komutunu çalıştırın. **v10.16.3** (yüklü olan sürüm versiyonu) gibi bir çıktıyla karşılaşıyorsanız NodeJS bilgisayarınızda yüklüdür.
    
    - NodeJS için gerekli paketlerin yönetilmesini sağlayan npm'in de kurulu olması gerekmektedir. Npm'in kurulu olup olmadığını anlamak için

        ```npm --version```
    
    komutunu çalıştırın. **6.9.0** (kurulu olan versiyon numarası) gibi bir çıktıyla karşılaşıyorsanız npm yüklüdür. Bazı NodeJS sürümlerinde npm içerisinde gelmektedir. O yüzden npm'i direkt kurmadan önce bir kontrol etmenizde yarar var.

    - Veri setini tekrardan oluşturmayacaksanız, ```/data/raw_data/dataset_v2/all_users_v2.zip``` veri setini kullanabilirsiniz.

-  Zemberek pre-processing ile ilgili adımları kendiniz tekrar etmek istiyorsanız JDK'nın bilgisayarınızda kurulu olduğundan emin olun.

    - Veri setini tekrardan kendiniz oluşturduysanız bu adımı da kendinizin tekrardan çalıştırması gerekmektedir.

    - Bu adımı tekrar etmek istemiyorsanız, ```data/preprocessed_data/zemberek/preprocessed_dataset_zemberek.zip``` veri setini kullanabilirsiniz.

    - Zemberek ile ilgili dependency'ler pom.xml ile yönetilmektedir. Sizin tek yapmanız gereken kullanıldığınız IDE yardımıyla bu dependency'lerin indirilmesini sağlamaktır.
        
        - Zemberek **Normalizasyon** ve **Lemmatization** aşamalarında ekstradan iki tane dosyaya ihtiyaç duymaktadır.
        Onları ```src/preprocessing/dependencies``` alt ında bulabilirsiniz. Bu dosyaları indirdiğiniz zaman kodda da ilgili path'lerin değiştirildiğinden emin olun.

- Pre-processing işlemlerinde kullanılan stop words bir dosyadan okunmaktadır. Bunun sebebi stop words'un internetten araştırmalar yapılarak genişletilmiş bir halde olmasıdır. NLTK ve Zemberek içerisindeki kelimeler dışında ekstradan kelimeler bulunmaktadır. Ayrıca ```src/count_words.py``` ile veri setlerinde geçen en çok 1000 kelimenin listesinin çıkarılması ve bu kelimelerin bazılarının stop words dosyasına dahil edilmesi mümkündür.

- Anaconda ortamı kullanılarak proje geliştirilmiştir. Bu sayede ihtiyaç duyulan çoğu gereksinim Anaconda tarafından çözülmüştür.


## Neden MBTI

## Veri Seti

- https://eksisozluk.com/16personalities-com--5123196?p=1 (yaklaşık 600 entry) 

- https://eksisozluk.com/sozlukculerin-kisilik-analizleri--4133116?p=6  (yaklaşık 60 entry)

- https://eksisozluk.com/16-personalities--4966174  (yaklaşık 30 entry)

- https://eksisozluk.com/myers-briggs-kisilik-gostergesi--797181?p=1  (yaklaşık 520 entry)

Yukarıda bulunan başlıkların altına insanlar internet üzerinden çözmüş oldukları MBTI kişilik testlerini paylaştılar. 
Bu verileri kullanarak paylaştıkları kendilerine ait olan kişilik özellikleri ve girmiş oldukları entry'ler toplanarak bunlarla etiketli bir veri seti elde etmiş olacağız.

Çözmüş oldukları MBTI testi sonucundan çıkan kişiliklerini belirtmiş
toplam 660 kullanıcılı bir veri setimiz oluşmuş durumdadır.


## Diğer Çalışmalar

## Kamuya Açık Verisetleri
