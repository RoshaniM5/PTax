package com.mpro.ptax.Utils;


import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.mpro.ptax.model.WIFlat;
import com.mpro.ptax.model.WiData;


	public class ReadExcel{
		
		public static Iterator<WiData> getWIData() {
	
			File file = new File(System.getProperty("user.dir")
            + "/src/test/resources/WI Data.xlsx");

    List<WiData> wiList = new ArrayList<>();

    DataFormatter formatter = new DataFormatter();
    
    try (XSSFWorkbook workbook = new XSSFWorkbook(file)) {

        XSSFSheet sheet = workbook.getSheet("Sheet1");
        Iterator<Row> rows = sheet.iterator();
        rows.next(); // skip header

        while (rows.hasNext()) {

            Row row = rows.next();

            WiData data = new WiData(
            		 formatter.formatCellValue(row.getCell(0)),
                     formatter.formatCellValue(row.getCell(1)),
                     formatter.formatCellValue(row.getCell(2)),
                     formatter.formatCellValue(row.getCell(3)),
                     formatter.formatCellValue(row.getCell(4)),
                     formatter.formatCellValue(row.getCell(5)),
                     formatter.formatCellValue(row.getCell(6)),
                     formatter.formatCellValue(row.getCell(7)),
                     formatter.formatCellValue(row.getCell(8)),
                     formatter.formatCellValue(row.getCell(9))            );

            wiList.add(data);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return wiList.iterator();
 }
	
		
		public static Iterator<WIFlat> getFlatData() {

			File file = new File(System.getProperty("user.dir")
		            + "/src/test/resources/WI New Flat Details.xlsx");

		    List<WIFlat> wiList1 = new ArrayList<>();
		    DataFormatter formatter = new DataFormatter();
		    
		    
		    try (XSSFWorkbook workbook = new XSSFWorkbook(file)) {

		        XSSFSheet sheet = workbook.getSheet("Sheet1");
		        Iterator<Row> rows = sheet.iterator();
		        rows.next(); // skip header

		        while (rows.hasNext()) {

		            Row row = rows.next();

	            WIFlat data1 = new WIFlat(

	            		    formatter.formatCellValue(row.getCell(0)),
	                        formatter.formatCellValue(row.getCell(1)),
	                        formatter.formatCellValue(row.getCell(2)),
	                        formatter.formatCellValue(row.getCell(3)),
	                        formatter.formatCellValue(row.getCell(4)),
	                        formatter.formatCellValue(row.getCell(5)),
	                        formatter.formatCellValue(row.getCell(6)),
	                        formatter.formatCellValue(row.getCell(7)),
	                        formatter.formatCellValue(row.getCell(8)),
	                        formatter.formatCellValue(row.getCell(9)),
	                        formatter.formatCellValue(row.getCell(10)),
	                        formatter.formatCellValue(row.getCell(11)),
	                        formatter.formatCellValue(row.getCell(12)),
	                        formatter.formatCellValue(row.getCell(13))
	                );

	            wiList1.add(data1);
	    }

	    } catch (Exception e) {
	            e.printStackTrace();
	}

	      return wiList1.iterator();
	 }
}
		
	