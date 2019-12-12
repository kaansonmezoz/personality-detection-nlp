const puppeteer = require('puppeteer');
const {PendingXHR} = require('pending-xhr-puppeteer');

const loadAllEntries = (username) => {
    return new Promise((resolve, reject) => {
        let htmlPage = "";
        
        puppeteer.launch({args: ['--unlimited-storage', '--full-memory-crash-report']}).then(async browser => {
            const page =  await browser.newPage();
            const pendingXHR = new PendingXHR(page);    
            
            let url = `https://eksisozluk.com/biri/${encodeURIComponent(username)}`
            
            console.log('Link: ' + url);
            
            await page.setDefaultNavigationTimeout(0);             
            await page.setDefaultTimeout(0);

            await page.goto(url, { waitUntil: 'networkidle0'});        
            await pendingXHR.waitForAllXhrFinished();
            
            let entryCount = await page.$eval('div#profile-stats-sections small', (element) => {
                return parseInt(element.textContent.replace('(', '').replace(')',''));  
            })
            
            console.log(`${username} entryCount: ${entryCount}`);

            const maxEntryPerLoad = 10;
            const maxPageCount = (entryCount * 1.0) / maxEntryPerLoad;        
            
            for(let pageCount = 1; pageCount < maxPageCount; pageCount++){
                await page.click('a.load-more-entries');
                await pendingXHR.waitForAllXhrFinished();               
                
                htmlPage = await page.content();
                console.log(`Total heap: ${process.memoryUsage().heapTotal}`)
                console.log(`Used heap: ${process.memoryUsage().heapUsed}`)
                console.log(`${username} pageCount: ${pageCount} maxPageCount: ${maxPageCount}`)
            }                
            browser.close();        
            resolve(htmlPage);
        }).catch((err) => {
            console.log(err)
            reject(err);
        })
    });
}

module.exports = {
    loadAllEntries
};