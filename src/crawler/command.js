const yargs = require('yargs');

yargs.option('input-path', {
    alias: 'i', 
    describe: 'Text file path where usernames are located',
    type: 'string'
})
.option('output', {
    alias: 'o',
    describe: 'File path where entry json files will be downloaded',
    type: 'string',
    default: '../entries'
})
.option('format', {
    alias: 'f',
    describe: 'Output file format',
    type: 'string',
    default: 'json',
    choices: ['json', 'csv'],
    demandOption: false
})
.option('class', {
    alias: 'c',
    describe: 'Class of the MBTI personality type (i.e Diplomat, Analyst, Sentinel, Explorer)',
    type: 'string'
})
.demandOption(['input-path', 'class'])
.check((argv) => {
    let fileExtension = argv.i.split(".").pop();

    if(fileExtension !== "txt"){
        throw new Error(
            'Unsupported file extension !\n' + 
            `Expected txt but got ${fileExtension}`        
        );
    }

    return true;
})

exports.parameters = {
    inputFilePath: yargs.argv['input-path'],
    outputFolderPath: yargs.argv['output'],
    type: yargs.argv['type'],
    typeClass: yargs.argv['class']
};