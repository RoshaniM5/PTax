package com.mpro.ptax.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel {
	
	 private Workbook workbook;

	    public ReadExcel(String excelPath) throws IOException {
	    	workbook = WorkbookFactory.create(new FileInputStream(excelPath));
	    }																																						
	   

	    public String getCellData(String sheetName, int rowNum, int colNum) {
	        Sheet sheet = workbook.getSheet(sheetName);
	        if (sheet == null) return "";
	        Row row = sheet.getRow(rowNum);
	        if (row == null) return "";
	        Cell cell = row.getCell(colNum);
	        if (cell == null) return "";
	        return new DataFormatter().formatCellValue(cell);
	    }

	    public int getRowCount(String sheetName) {
	        Sheet sheet = workbook.getSheet(sheetName);
	        return (sheet != null) ? sheet.getPhysicalNumberOfRows() : 0;
	    }

	    public int getColumnCount(String sheetName) {
	        Sheet sheet = workbook.getSheet(sheetName);
	        Row row = (sheet != null) ? sheet.getRow(0) : null;
	        return (row != null) ? row.getPhysicalNumberOfCells() : 0;
	    }

	    public void closeWorkbook() throws IOException {
	        if (workbook != null) workbook.close();
	    }
	    
	    // Method 4: Get all rows as List<Map<column, value>>
	    public List<Map<String, String>> getData(String sheetName) {
	        List<Map<String, String>> dataList = new ArrayList<>();
	        Sheet sheet = workbook.getSheet(sheetName);
	        if (sheet == null) return dataList;

	        Row header = sheet.getRow(0);
	        if (header == null) return dataList;

	        int cols = header.getPhysicalNumberOfCells();
	        DataFormatter formatter = new DataFormatter();

	        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
	            Row row = sheet.getRow(i);
	            if (row == null || isRowEmpty(row, formatter)) continue;

	            Map<String, String> data = new LinkedHashMap<>();
	            for (int j = 0; j < cols; j++) {
	                String key = formatter.formatCellValue(header.getCell(j)).trim();
	                String value = formatter.formatCellValue(row.getCell(j)).trim();
	                data.put(key, value);
	            }
	            dataList.add(data);
	        }
	        return dataList;
	    }

	    // Utility: Check if a row is empty
	    private boolean isRowEmpty(Row row, DataFormatter formatter) {
	        for (Cell cell : row) {
	            if (!formatter.formatCellValue(cell).trim().isEmpty()) return false;
	        }
	        return true;
	    
	}
}