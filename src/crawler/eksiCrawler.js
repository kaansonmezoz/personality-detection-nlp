const fs = require('fs');
const {getUserEntries} = require('./getAllUserEntries');
const {parameters} = require('./command');

process.setMaxListeners(120);

process.on('exit', (code) => {
    if(code === 99){
        console.log(`Wrong file format !\nInput file should be a text !\nExit code: ${code}`);
    }
})

const inputFilePath = parameters.inputFilePath;
const outputFolderPath = parameters.outputFolderPath;
const type = parameters.type;
const typeClass = parameters.typeClass;

if(!inputFilePath.substring(inputFilePath.length-4).includes('.txt')){    
    process.exit(99);
}

if(!fs.existsSync(outputFolderPath)){
    fs.mkdirSync(outputFolderPath);
}

var lines = fs.readFileSync(inputFilePath, 'utf-8').split('\n');

lines.forEach((username, index) => {
    getUserEntries(username).then((entries) => {    
        let json = {
            entries,
            type,
            typeClass
        };
        
        let jsonString = JSON.stringify(json, null, 2);
        console.log(`${username} : Entries has been writing to the file !`);
                
        if(!fs.existsSync(`${outputFolderPath}/${username}.json`)){
            fs.writeFileSync(`${outputFolderPath}/${username}.json`, jsonString,'utf8');
            console.log('Entries has already been downloaded !');    
        }
        else{
            console.log(`${username} exists ! `)
        }        
    }).catch((err) => {
            console.log(err);
    })
});