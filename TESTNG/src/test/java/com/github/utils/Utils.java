package com.github.utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;

public class Utils {

    private static XSSFWorkbook xssfWorkbook;
    private static XSSFSheet xssfSheet;
    private static XSSFCell xssfCell;

    public static Object[][] getWorksheetData(String path, String sheetName) {
        String[][] dataArray;

        try{
            FileInputStream file = new FileInputStream(path);
            xssfWorkbook = new XSSFWorkbook(file);
            xssfSheet = xssfWorkbook.getSheet(sheetName);
            int countRows = xssfSheet.getLastRowNum();
            int countColumns = xssfSheet.getRow(countRows).getLastCellNum();
            dataArray = new String[countRows][countColumns];
            for (int i = 1; i<=countRows; i++){
                for(int j = 0; j <countColumns; j++){
                    dataArray[i-1][j] = getCellData(i,j);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return dataArray;
    }

    public static String getCellData(int row, int col){
        try {
            xssfCell = xssfSheet.getRow(row).getCell(col, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            return xssfCell.getStringCellValue();
        }catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }
}


