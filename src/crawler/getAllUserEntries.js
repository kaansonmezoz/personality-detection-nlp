const cheerio  = require('cheerio');

const {loadAllEntries} = require('./loadAllUserEntries');

const extractData = ($, element) => {
    let entryTitle = $(element).find('h1').attr('data-title');
    let entryTitleId = $(element).find('h1').attr('data-id');
    let entryId = $(element).find('li').attr('data-id');
    let username = $(element).find('li').attr('data-author');
    let userId = $(element).find('li').attr('data-author-id');
    let entry = $(element).find('.content').text().trim();
    
    let entryDate = $(element).find('footer')
                              .find('div.info')
                              .find('a.entry-date.permalink')
                              .text()
                              .trim();

    return {
        username,
        userId,
        entryTitle,
        entryTitleId,
        entryId,
        entry,
        entryDate
    };
}

const getUserEntries = (username) => {
    return new Promise((resolve, reject) => {
        console.log('Entries have been downloading !');
        loadAllEntries(username).then((htmlPage) => {
            let entryArray = []
            var $ = cheerio.load(htmlPage);
            var entries = $('.topic-item');
        
            entries.each((index, element) => {    
                entryArray.push(extractData($, element));
            });
            console.log('Entries have been downloaded !');        
            
            resolve(entryArray);
        })
        .catch((err) => {
            reject(err);
        })    
    })
}
    
module.exports = {
    getUserEntries
};