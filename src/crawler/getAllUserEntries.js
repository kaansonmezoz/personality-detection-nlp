const cheerio  = require('cheerio');

const {loadAllEntries} = require('./loadAllUserEntries');

const extractData = ($, element) => {
    let entryTitle = $(element).find('h1').attr('data-title');
    let entryTitleId = $(element).find('h1').attr('data-id');
    let entryId = $(element).find('li').attr('data-id');
    //let username = $(element).find('li').attr('data-author');
    let userId = $(element).find('li').attr('data-author-id');
    
    let entry = $(element).find('.content').text().trim();
    entry = entry.replace(/[~`!@$%^&*(){}\[\];:"'<,.>?\/\\|_+=-]/g, ' ');
    
    let entryDate = $(element).find('footer')
                              .find('div.info')
                              .find('a.entry-date.permalink')
                              .text()
                              .trim();

    return {
        //username,
        userId,
        wordCount: entry.split(" ").length,
        characterCount: entry.length,
        'entryData': {
            entryTitle,
            entryTitleId,
            entryId,
            entry,
            entryDate
        }
    };
}

const getUserEntries = (username) => {
    return new Promise((resolve, reject) => {
        console.log(`${username} : Entries have been downloading !`);
        
        loadAllEntries(username).then((htmlPage) => {
            let wordCount = 0;
            let characterCount = 0;
            let entryArray = []
            var $ = cheerio.load(htmlPage);
            var entries = $('.topic-item');
            let userId = 0;

            entries.each((index, element) => {    
                let data = extractData($, element);
                wordCount += data.wordCount;
                userId = data.userId;
                characterCount += data.characterCount;
                entryArray.push(data.entryData);
            });            
            
            resolve({
                'entries': entryArray,
                userId,
                wordCount,
                characterCount
            });
        })
        .catch((err) => {
            reject(err);
        })    
    })
}
    
module.exports = {
    getUserEntries
};