* Node ve npm'in bilgisayarınızda kurulu olması gerekmektedir. Crawler'ı çalıştırmadan önce eksiCrawler.js'ın oldugu konuma terminalden cd komutuyla gelmelisiniz. Sonrasında ise npm install ile crawler için gerekli paketlerin indirilmesini sağlamanız gerekmektedir.

* Crawlerı çalıştırmak için:
    
    `node eksiCrawler.js -f folder_path/file_name.txt`

* -f (veya --file-path) ile kullanıcı isimlerinin bulunmuş olduğu dosyanın konumunu vermeniz gerekiyor. Vermezseni crawler çalışmayacaktır. Dosya formatının text olması gerekmektedir.

* İndirilecek olan entrylerin hangi klasöre kaydedilmesini istiyorsanız onu --output ya da -o optionları ile belirtebilirsiniz. Belirtmezseniz ../entries klasörü altına indirilecektir. Örnek kullanım:
    
    `node eksiCrawler.js -f folder_path/file_name.txt -o ../entries`

* Crawler ile ilgili diğer gelişmeleri [github.com/kaansonmezoz/eksi-crawler](url) adresinden takip edebilirsiniz.

* İndireceğiniz kullanıcı entryleri eğer çok fazla ise bu durumda memoryden kaynaklı olarak sorun yaşayabilirsiniz. Bunu aşmak için:
    ` --max-old-space-size=8192 ` gibi bir optional parametre geçebilirsiniz programı çalıştırırken.
    `node --max-old-space-size=8192 eksiCrawler.js -f folder_path/file_name.txt -o ../entries`
