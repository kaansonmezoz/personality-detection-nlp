const fs = require('fs');

const jsonToCsv = () => {    
    let data = fs.readFileSync('./combinedDataset.json');
    let jsonData = JSON.parse(data);

    console.log(`Total user count: ${jsonData.datasetInfo.totalUserCount}`);
    console.log(`Total entry count: ${jsonData.datasetInfo.totalEntryCount}`);
    console.log(`Total word count: ${jsonData.datasetInfo.totalWordCount}`);
    console.log(`Total character count: ${jsonData.datasetInfo.totalCharacterCount}`);

    console.log('---------------------------------');
    console.log(`Analyst user count: ${jsonData.datasetInfo.analysts.userCount}`);
    console.log(`Analyst entry count: ${jsonData.datasetInfo.analysts.entryCount}`);
    console.log(`Analyst word count: ${jsonData.datasetInfo.analysts.wordCount}`);
    console.log(`Analyst character count: ${jsonData.datasetInfo.analysts.characterCount}`);

    console.log('---------------------------------');
    console.log(`Diplomat user count: ${jsonData.datasetInfo.diplomats.userCount}`);
    console.log(`Diplomat entry count: ${jsonData.datasetInfo.diplomats.entryCount}`);
    console.log(`Diplomat word count: ${jsonData.datasetInfo.diplomats.wordCount}`);
    console.log(`Diplomat character count: ${jsonData.datasetInfo.diplomats.characterCount}`);

    console.log('---------------------------------');
    console.log(`Explorer user count: ${jsonData.datasetInfo.explorers.userCount}`);
    console.log(`Explorer entry count: ${jsonData.datasetInfo.explorers.entryCount}`);
    console.log(`Explorer word count: ${jsonData.datasetInfo.explorers.wordCount}`);
    console.log(`Explorer character count: ${jsonData.datasetInfo.explorers.characterCount}`);

    console.log('---------------------------------');
    console.log(`Sentinels user count: ${jsonData.datasetInfo.sentinels.userCount}`);
    console.log(`Sentinels entry count: ${jsonData.datasetInfo.sentinels.entryCount}`);
    console.log(`Sentinels word count: ${jsonData.datasetInfo.sentinels.wordCount}`);
    console.log(`Sentinels character count: ${jsonData.datasetInfo.sentinels.characterCount}`);

    fs.appendFileSync('./combinedDataset.csv', 'user;entry;type;typeClass;I/E;S/N;T/F;J/P\n');

    let analysts = jsonData.analysts;
    let diplomats = jsonData.diplomats;
    let explorers = jsonData.explorers;
    let sentinels = jsonData.sentinels;

    analysts.users.forEach(user => {
        user.entries.forEach(entry => {
            let data = `${user.username};${entry.entryTitle} ${entry.entry};${user.type};analysts;` + 
            `${user.type.charAt(0)};${user.type.charAt(1)};${user.type.charAt(2)};${user.type.charAt(3)}\n`

            fs.appendFileSync('./combinedDataset.csv', data)
        });
    });

    diplomats.users.forEach(user => {
        user.entries.forEach(entry => {
            let data = `${user.username};${entry.entryTitle} ${entry.entry};${user.type};diplomats;` + 
            `${user.type.charAt(0)};${user.type.charAt(1)};${user.type.charAt(2)};${user.type.charAt(3)}\n`

            fs.appendFileSync('./combinedDataset.csv', data)
        });
    });

    explorers.users.forEach(user => {
        user.entries.forEach(entry => {
            let data = `${user.username};${entry.entryTitle} ${entry.entry};${user.type};explorers;` + 
            `${user.type.charAt(0)};${user.type.charAt(1)};${user.type.charAt(2)};${user.type.charAt(3)}\n`

            fs.appendFileSync('./combinedDataset.csv', data)
        });
    });

    sentinels.users.forEach(user => {
        user.entries.forEach(entry => {
            let data = `${user.username};${entry.entryTitle} ${entry.entry};${user.type};sentinels;` + 
            `${user.type.charAt(0)};${user.type.charAt(1)};${user.type.charAt(2)};${user.type.charAt(3)}\n`

            fs.appendFileSync('./combinedDataset.csv', data)
        });
    });

}

jsonToCsv();