package org.com.AmazonAuto.TestComponents;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Excel_utils {
    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    private static XSSFCell cell;

    public void ExcelFile() throws IOException {
        File file = new File(System.getProperty("user.dir")+"//Data//Amazon Register.xlsx");
        FileInputStream fis = new FileInputStream(file);
        workbook = new XSSFWorkbook(fis);
         int sheets=workbook.getNumberOfSheets();
        }
    public String getCellData(int rowNumber,int cellNumber){
        //getting the cell value from rowNumber and cell Number
        cell =sheet.getRow(rowNumber).getCell(cellNumber);

        //returning the cell value as string
        return cell.getStringCellValue();
    }

    }

