Bu dosya ön işleme adımlarını içermektedir.

    first.py:   ISTP kişilik tipine sahip kullanıcıları tek bir csv dosyasında topluyor.ISTP
               klasörünün altında "combined.csv" isimli dosyadır.
    
    second.py: Pandas kütüphanesinin DataFrame fonksiyonunu kullanarak veriyi username 
               ve entry olmak üzere iki sütuna indirgeyip kullanıcının entry'lerini birleştiriyor.
               (özel karekter kullanmadan)
                
    third.py:  Ön işleme adımlarını içeriyor. Fakat DataFrame'i itere edemediğim için tek bir 
               kullanıcının entry'leri üzerinde işlem yapılmıştır.
               
Kullanılan kütüphaneler requirements.txt dosyasına kilitlenmiştir.

    pip install -r requirements.txt
    
nltk'nın Türkçe için sağladığı stopwords listesinde "53" kelime bulunuyordu. 
Bu liste "285" kelimeye çıkarıldı.
               
