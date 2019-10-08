dataset_structured_2.zip'ten sınıflarına göre ayrılmış olan json dosyalarının csv formatına dönüştürülmüş hali all_users.zip'tir.
Bu dönüşüm esnasında -- spoiler --, # içeren entryler verisetinden çıkarılmış noktalama işaretleri temizlenmiştir.
-- spoiler -- iceren entrylerin büyük bir çoğunluğu yaşanmış olan bir olayı anlatmasından ötürü ya da girilen metnin büyük bir kısmı olayı anlatmasından ötürü yazara ait herhangi bir yorum ya da davranış sergilememesinin modelin başarı oranına olumsuz etki yaratabilecek olması nedeniyle çıkarılmıştır.
Aynı şekilde #12341234 (#entry_id) şeklinde olan ifadelerde de daha önceden girilmiş olan bir entry ile ilgili yorum ya da "#1241234  burada bahsettim" tarzında içerikler olmasından ötürü çıkartıldı. 

Çıkartılan entry sayıları :
  * analysts: 7567 (eski verisetinde analyst sınıfının %3,3'ü csilindi)
  * diplomats: 5946 (eski verisetinde diplomats sınıfının %2,49'u silindi)
  * explorers: 1319 (eski verisetinde explorers sınıfının %2,097'i silindi)
  * sentinels: 3881 (eski verisetinde sentinels sınıfının %3,04'ü silindi)
  * toplamda: 18713 (eski verisetinde denk düştüğü oran: %2,84)


* Veriseti ile ilgili döküman linki
    - https://docs.google.com/document/d/1qCqujSW5WKHYRtsIDh3yLetbFqcpsyI7kJDlVK3RQ94/edit?usp=sharing

## Veriseti Özellikleri

* ### Four Classes

|   Class        | User Count  | Entry Count  | Word Count      | Character Count  |
|----------------|-------------|--------------|-----------------|------------------|
| **Sentinels**  | 	  *127*     |  *127,253*   |   *4,831,985*   |	*3,0792,924*   |
| **Explorers**| 	  *80*     |   *62,872*   |   *2,258,837*   |	*18,561,433*   |
| **Diplomats**| *212*     |   *238,750*	|  *1,0452,644*	  |   *43,208,252*   |
| **Analysts** |    *241*    |   *228,962*	|  *9,923,600*	  |   *63,614,274*   |
| **overall**| 	  *660*     |  *657,837*   |   *17,014,422*   |	*125,383,959*   |

	

    		




* #### Sentinels

| Type       | User Count  | Entry Count  | Word Count      | Character Count  |
|------------|-------------|--------------|-----------------|------------------|
| **esfj**   |    *24*     |   *30,105*   |   *1,067,112*   |   *6,837,943*    |
| **estj**   |    *44*     |   *30,334*   |   *1,466,861*   |   *9,253,381*    |
| **isfj**   |    *26*     |   *21,845*   |    *848,315*    |   *5,419,113*    |
| **istj**   |    *33*     |   *44,969*   |   *1,449,697*   |   *9,282,487*    |
| **overall**| 	  *127*     |  *127,253*   |   *4,831,985*   |	*3,0792,924*   |

* #### Explorers

| Type       | User Count  | Entry Count  | Word Count      | Character Count  |
|------------|-------------|--------------|-----------------|------------------|
|  **esfp**  |    *28*     |   *22,079*   |    *793,793*    |   *3,384,592*    |
|  **estp**  |    *23*     |   *14,240*   |    *538,813*    |   *9,253,381*    |
|  **isfp**  |    *16*     |   *17,103*   |    *587,420*    |   *3,801,567*    |
|  **istp**  |    *13*     |    *9,450*   |    *338,811*    |   *2,121,893*    |
| **overall**| 	  *80*     |   *62,872*   |   *2,258,837*   |	*18,561,433*   |

* #### Diplomats

| Type     | User Count  | Entry Count  | Word Count      | Character Count  |
|----------|-------------|--------------|-----------------|------------------|
| **enfj** |    *46*     |   *54,205*   |  *1,817,885*    |   *11,917,810*   |
| **enfp** |    *50*     |   *56,722*   |  *3,071,384*    |   *19,683,151*   |
| **infj** |    *48*     |   *41,180*   |  *1,837,375*    |   *11,607,291*   |
| **infp** |    *68*     |   *86,643*   |  *3,726,000*    |   *2,4100,166*   |
|          |   *212*     |   *238,750*	|  *1,0452,644*	  |   *43,208,252*   |


* #### Analysts


| Type     | User Count  | Entry Count  | Word Count      | Character Count  |
|----------|-------------|--------------|-----------------|------------------|
| **entj** |    *39*     |   *46,859*   |  *2,081,245*    |   *13,161,073*   |
| **entp** |    *59*     |   *63,987*   |  *2,803,450*    |   *17,977,038*   |
| **intj** |    *72*     |   *50,184*   |  *2,104,194*    |   *13,530,641*   |
| **intp** |    *71*     |   *67,932*   |  *2,934,711*    |   *18,945,522*   |
|          |    *241*    |   *228,962*	|  *9,923,600*	  |   *63,614,274*   |

### Silinen kullanıcılar:
    * snowdiyebiri*
    * synallagmatique
    * flaminis

#### NOTLAR
- CSV dosyasındaki özel karakter:    |~|~|     (başında ve sonunda space var.)
