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
.option('type', {
    alias: 't',
    describe: 'MBTI personality type (i.e INTJ, ESTP ...) ',
    type: 'string'
})
.option('class', {
    alias: 'c',
    describe: 'Class of the MBTI personality type (i.e Diplomat, Analyst, Sentinel, Explorer)',
    type: 'string'
})
.demandOption(['file-path', 'type', 'class']);

exports.parameters = {
    inputFilePath: yargs.argv['file-path'],
    outputFolderPath: yargs.argv['output'],
    type: yargs.argv['type'],
    typeClass: yargs.argv['class']
};