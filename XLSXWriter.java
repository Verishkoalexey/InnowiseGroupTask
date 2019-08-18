package poi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.User;


public class XLSXWriter {
	
	private String filePath;

	public XLSXWriter(String filePath) {
		this.filePath = filePath;
	}

	public List<User> setUsers(List<User> us) throws IOException {

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Clients sheet");
      
		List<User> list = us;
		 
	        int rownum = 0;
	        Cell cell;
	        Row row;
	        
	        row = sheet.createRow(rownum);
	 
	        // Number
	        cell = row.createCell(0, CellType.STRING);
	        cell.setCellValue("ID");

	        // First Name
	        cell = row.createCell(1, CellType.STRING);
	        cell.setCellValue("First_Name");
	        // Last Name
	        cell = row.createCell(2, CellType.STRING);
	        cell.setCellValue("Last_Name");
	        // Gender
	        cell = row.createCell(3, CellType.STRING);
	        cell.setCellValue("Email");
	        // Country
	        cell = row.createCell(4, CellType.STRING);
	        cell.setCellValue("Phone_Number");
	        // Age
	        cell = row.createCell(5, CellType.STRING);
	        cell.setCellValue("Role");

	        
	        //Data
	        for (User users : list) {
				rownum++;
				row = sheet.createRow(rownum);
				
				 // Number (A)
	            cell = row.createCell(0, CellType.NUMERIC);
	            cell.setCellValue(users.getId());
	            // First Name (B)
	            cell = row.createCell(1, CellType.STRING);
	            cell.setCellValue(users.getName());
	            // Last Name (C)
	            cell = row.createCell(2, CellType.STRING);
	            cell.setCellValue(users.getLastName());
	            // Gender (D)
	            cell = row.createCell(3, CellType.STRING);
	            cell.setCellValue(users.getEmail());
	            // Country (E)
	            cell = row.createCell(4, CellType.STRING);
	            cell.setCellValue(users.getNumberPhone());
	            // Age (F)
	            cell = row.createCell(5, CellType.STRING);
	            cell.setCellValue(users.getRole());
	           
			}
	        File file = new File(filePath);
	        file.getParentFile().mkdirs();
	 
	        FileOutputStream outFile = new FileOutputStream(file);
	        workbook.write(outFile);
	        System.out.println("Created file: " + file.getAbsolutePath());
	        workbook.close();
			return list;
	        
		}
		

	}

