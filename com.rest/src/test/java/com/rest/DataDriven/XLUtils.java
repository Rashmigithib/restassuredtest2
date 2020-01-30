package com.rest.DataDriven;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static Workbook wb;;
	public static Sheet ws;
	public static Row row;
	public static Cell cell;
	
	
	public static int getRowCount(String xlfile, String xlsheet) throws IOException {
		
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		int rowcount=ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
		
		
	}
	
	
public static int getCellCount(String xlfile, String xlsheet,int rownum) throws IOException {
		
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		int cellCount=row.getLastCellNum();
		wb.close();
		fi.close();
		return cellCount;
		
		
	}

public static String getCellData (String xlfile, String xlsheet ,int rownum, int cellnum) throws IOException {
	
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlsheet);
	row=ws.getRow(rownum);
	cell=row.getCell(cellnum);
	int cellCount=ws.getLastRowNum();
	wb.close();
	fi.close();
	String data;
	try {
		DataFormatter formatter=new DataFormatter();
		String cellData=formatter.formatCellValue(cell);
		return cellData;
		
	}catch (Exception e) {
		
		data="";
		// TODO: handle exception
	}
	
	return data;
	
	
}


public static void setCellData (String xlfile, String xlsheet ,int rownum, int cellnum,String data) throws IOException {
	
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlsheet);
	row=ws.getRow(rownum);
	cell=row.getCell(cellnum);
cell.setCellValue(data);
fo=new FileOutputStream(xlfile);
wb.write(fo);


	wb.close();
	fi.close();
	fo.close();
	
	
}
}
