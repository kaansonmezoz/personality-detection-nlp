const fs = require('fs');
const {getUserEntries} = require('./getAllUserEntries');
const yargs = require('yargs');

yargs.option('file-path', {
    alias: 'f', 
    describe: 'Text file path where usernames are located',
    type: 'string'
})
.option('output', {
    alias: 'o',
    describe: 'File path where entry json files will be downloaded',
    type: 'string',
    default: '../entries'
})
.demandOption(['file-path']);

process.setMaxListeners(120);

process.on('exit', (code) => {
    if(code === 99){
        console.log(`Wrong file format !\nInput file should be a text !\nExit code: ${code}`);
    }
})

const inputFilePath = yargs.argv['file-path'];
const outputFolderPath = yargs.argv['output'];

if(!inputFilePath.substring(inputFilePath.length-4).includes('.txt')){    
    process.exit(99);
}

if(!fs.existsSync(outputFolderPath)){
    fs.mkdirSync(outputFolderPath);
}

var lines = fs.readFileSync(inputFilePath, 'utf-8').split('\n');

lines.forEach((username, index) => {
    getUserEntries(username).then((entries) => {    
        let jsonString = JSON.stringify(entries, null, 2);
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