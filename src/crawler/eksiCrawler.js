const fs = require('fs');
const {getUserEntries} = require('./getAllUserEntries');
const {parameters} = require('./command');

process.setMaxListeners(120);

const inputFilePath = parameters.inputFilePath;
const outputFolderPath = parameters.outputFolderPath;
const typeClass = parameters.typeClass;

if(!fs.existsSync(outputFolderPath)){
    fs.mkdirSync(outputFolderPath);
}

var lines = fs.readFileSync(inputFilePath, 'utf-8').split('\n');


const downloadAllUserEntries = (lines) => {    
        lines.forEach((line, index) => {
            let username = line.split(";")[0];
            let type = line.split(";")[1];
            
            if(!fs.existsSync(`${outputFolderPath}/${username}.json`)){        
                getUserEntries(username).then((data) => {    
                    let entries = data.entries;


                    let userData = {
                        username,
                        'userId': data.userId,
                        'characterCount': data.characterCount,
                        'wordCount': data.wordCount,
                        'entryCount': entries.length,
                        type,
                        typeClass,
                        entries,
                    }
    
                    let jsonString = JSON.stringify(userData, null, 2);                            
                    console.log(`${username} : Entries have been written to the file !`);
                    fs.writeFileSync(`${outputFolderPath}/${username}.json`, jsonString, 'utf8');
                }).catch((err) => {
                    console.log(err);
                })
            }
            else{
                console.log(`${username} exists ! `);
            }
        });     
}

downloadAllUserEntries(lines);