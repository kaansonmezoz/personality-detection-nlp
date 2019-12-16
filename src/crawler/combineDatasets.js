const fs = require('fs');

let combinedDatasets = {
    "analysts" : {"users": []},
    "diplomats": {"users": []},
    "explorers": {"users": []},
    "sentinels": {"users": []},
    
    "datasetInfo": {
        "totalUserCount": 0,        
        "totalEntryCount": 0,
        "totalWordCount": 0,
        "totalCharacterCount": 0,
        
        "analysts":  {"userCount": 0, "entryCount": 0, "wordCount": 0, "characterCount": 0},
        "diplomats": {"userCount": 0, "entryCount": 0, "wordCount": 0, "characterCount": 0},
        "explorers": {"userCount": 0, "entryCount": 0, "wordCount": 0, "characterCount": 0},
        "sentinels": {"userCount": 0, "entryCount": 0, "wordCount": 0, "characterCount": 0},
        
        "dimensionCounts": {
            "I": {"userCount": 0, "entryCount": 0, "wordCount": 0, "characterCount": 0},
            "E": {"userCount": 0, "entryCount": 0, "wordCount": 0, "characterCount": 0},
            "J": {"userCount": 0, "entryCount": 0, "wordCount": 0, "characterCount": 0},
            "P": {"userCount": 0, "entryCount": 0, "wordCount": 0, "characterCount": 0},
            "S": {"userCount": 0, "entryCount": 0, "wordCount": 0, "characterCount": 0},
            "N": {"userCount": 0, "entryCount": 0, "wordCount": 0, "characterCount": 0},
            "T": {"userCount": 0, "entryCount": 0, "wordCount": 0, "characterCount": 0},
            "F": {"userCount": 0, "entryCount": 0, "wordCount": 0, "characterCount": 0},
        }
    }
};

let datasetPaths = ['./analysts', './diplomats', './explorers', './sentinels'];

const getFilePaths = (folderPath) => {
    let filePaths = [];

    fs.readdirSync(folderPath).forEach(file => {
        filePaths.push(`${folderPath}/${file}`);
    })

    return filePaths;
}

const getAllFilePaths = () => {
    let filePaths = [];

    datasetPaths.forEach(datasetPath => {
        filePaths = filePaths.concat(getFilePaths(datasetPath));
    })

    return filePaths;
}

const combineDatasets = () => {
    return new Promise((resolve, reject) => {
        let filePaths = getAllFilePaths();

        filePaths.forEach((filePath, i, filePaths) => {
            fs.readFile(filePath, (err, data) => {            
                let jsonData = JSON.parse(data);
            
                let characterCount = jsonData.characterCount;
                let wordCount = jsonData.wordCount;
                let entryCount = jsonData.entryCount;
                let type = jsonData.type;
                let typeClass = jsonData.typeClass;

                combinedDatasets[typeClass].users.push({
                    'entries': jsonData.entries,
                    'username': jsonData.username,
                    'type': type
                });
                
                for(let i = 0; i < type.length; i++){
                    combinedDatasets.datasetInfo.dimensionCounts[type.charAt(i)].userCount += 1;
                    combinedDatasets.datasetInfo.dimensionCounts[type.charAt(i)].entryCount += entryCount;
                    combinedDatasets.datasetInfo.dimensionCounts[type.charAt(i)].wordCount += wordCount;
                    combinedDatasets.datasetInfo.dimensionCounts[type.charAt(i)].characterCount += characterCount;    
                }
        
                combinedDatasets.datasetInfo[typeClass].userCount += 1;
                combinedDatasets.datasetInfo[typeClass].entryCount += entryCount;
                combinedDatasets.datasetInfo[typeClass].wordCount += wordCount;
                combinedDatasets.datasetInfo[typeClass].characterCount += characterCount;
        
                combinedDatasets.datasetInfo.totalUserCount += 1;
                combinedDatasets.datasetInfo.totalEntryCount += entryCount;
                combinedDatasets.datasetInfo.totalWordCount += wordCount;
                combinedDatasets.datasetInfo.totalCharacterCount += characterCount;

                if(i === filePaths.length-1){
                    resolve();
                }
            });        
        })
    });
}

combineDatasets().then(() => {
    fs.writeFileSync('./combinedDataset.json', JSON.stringify(combinedDatasets, null, 2));
    console.log("Done !");
});