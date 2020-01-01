# Derin Öğrenme İle Kişilik Tespiti

## İçerik
- [Proje Tanımı](https://gihub.com/kaansonmezoz/personality-prediction-nlp#proje-tanımı)
- [Projenin Genel Yapısı](https://github.com/kaansonmezoz/personality-detection-nlp#projenin-genel-yapısı)
- [Repository Hiyerarşisi](https://gihub.com/kaansonmezoz/personality-prediction-nlp#repository-hiyerarşisi)
- [Kullanılan Teknolojiler](https://gihub.com/kaansonmezoz/personality-prediction-nlp#kullanılan-teknolojiler)
- [Gereksinimler](https://gihub.com/kaansonmezoz/personality-prediction-nlp#gereksinimler)
- [Neden MBTI](https://gihub.com/kaansonmezoz/personality-prediction-nlp#neden-mbti)
- [Oluşturulan Veriseti](https://gihub.com/kaansonmezoz/personality-prediction-nlp#oluşturulan-veriseti)
- [Diğer Çalışmalar](https://gihub.com/kaansonmezoz/personality-prediction-nlp#diğer-çalışmalar)
- [Kamuya Açık Verisetleri](https://gihub.com/kaansonmezoz/personality-prediction-nlp#kamuya-açık-verisetleri)



## DERİN ÖĞRENME İLE KİŞİLİK TESPİTİ


## DATASETS;
- https://eksisozluk.com/16personalities-com--5123196?p=1 (yaklaşık 600 entry) 

- https://eksisozluk.com/sozlukculerin-kisilik-analizleri--4133116?p=6  (yaklaşık 60 entry)

- https://eksisozluk.com/16-personalities--4966174  (yaklaşık 30 entry)

- https://eksisozluk.com/myers-briggs-kisilik-gostergesi--797181?p=1  (yaklaşık 520 entry)

Yukarıda bulunan başlıkların altına insanlar internet üzerinden çözmüş oldukları MBTI kişilik testlerini paylaştılar. 
Bu verileri kullanarak paylaştıkları kendilerine ait olan kişilik özellikleri ve girmiş oldukları entry'ler toplanarak bunlarla etiketli bir veri seti elde etmiş olacağız.

Çözmüş oldukları MBTI testi sonucundan çıkan kişiliklerini belirtmiş
toplam 660 kullanıcılı bir veri setimiz oluşmuş durumdadır.

## RESOURCES

- Resources klasörü altında konularla ilgili makaleler, linkler yer almaktadır.

## pre-processed dataset links

https://drive.google.com/file/d/1VnGxj5JW3d-vXFj0dK6ZMB4hlX2jfPoS/view?usp=sharing

https://drive.google.com/file/d/1-07TqnUx7nQeivtZ539NsT9ocre9C8TC/view?usp=sharing

## Projenin Genel Yapısı

![Project-Phases](https://raw.githubusercontent.com/kaansonmezoz/personality-detection-nlp/0836b492d89fca540aa51effca5b5b8778e2c862/Project-Phases.png)

1. Crawling
    - Verisetinin oluşturulduğu aşamadır.
    - eksisozluk.com'dan daha önceden belirlenmiş olan kullanıcıların entryleri indirilir.
2. Elimination
    - Crawling sonucunda oluşan veriseti kullanılır.
    - bkz, spoiler ve  # içeren entryler silinir.  Bu kelimeler bir olayı olduğu gibi aktarmak için kullanılmaktadır. Herhangi bir öznel ifade içermediğinden kullanıcıların kişiliklerinin tahmin edilmesinde önemli bir rol oynamadıkları düşünülmüştür ve silinmişlerdir.

3. Pre-processing

4. Feature Extraction
    - TF
    - TF-IDF
    - LDA
    - Word vectors

5. Model Training

6. Model Evaluation

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
            ├── resources/                   
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

## Gereksinimler

## Neden MBTI

## Veri Seti

## Diğer Çalışmalar

## Kamuya Açık Verisetleri
