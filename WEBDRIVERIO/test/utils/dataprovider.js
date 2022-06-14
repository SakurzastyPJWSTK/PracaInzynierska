'use strict';
const excelToJson = require('convert-excel-to-json');

export function getData(workbookPath, sheetName) {
    let data = excelToJson({
        sourceFile: workbookPath,
        header: {
            rows: 1
        },
        sheets: [sheetName]
    })

    return data[sheetName]
}