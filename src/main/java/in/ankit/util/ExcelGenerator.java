package in.ankit.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Component;

import in.ankit.entity.Citizen;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ExcelGenerator {
	
	public void generateExcel(HttpServletResponse response, List<Citizen> plans, File file) throws IOException {
		
		 HSSFWorkbook workbook = new HSSFWorkbook();
		 HSSFSheet sheet = workbook.createSheet("Data Sheet");
		 
		 HSSFRow headerRow = sheet.createRow(0);
		 headerRow.createCell(0).setCellValue("ID");
		 headerRow.createCell(1).setCellValue("Name");
		 headerRow.createCell(2).setCellValue("Plan");
		 headerRow.createCell(3).setCellValue("Status");
		 headerRow.createCell(4).setCellValue("Start Date");
		 headerRow.createCell(5).setCellValue("End Date");
		 headerRow.createCell(6).setCellValue("Benefit Amount");
		
		 int rowNo = 1;
		 for(Citizen plan:plans) {
			 HSSFRow dataRow = sheet.createRow(rowNo++);
		     dataRow.createCell(0).setCellValue(plan.getId());
		     dataRow.createCell(1).setCellValue(plan.getName());
		     dataRow.createCell(2).setCellValue(plan.getPlan());
		     dataRow.createCell(3).setCellValue(plan.getStatus());
		     dataRow.createCell(4).setCellValue(plan.getStart_date()+"");
		     dataRow.createCell(5).setCellValue(plan.getEnd_date()+"");
		     if(plan.getBenefitAmt()!=null) {
		     dataRow.createCell(6).setCellValue(plan.getBenefitAmt());
		     }else {
		    	 dataRow.createCell(6).setCellValue("N/A");
		     }
		 }
		 
		 workbook.write(response.getOutputStream());
	     
	     FileOutputStream fos = new FileOutputStream(file);
	     workbook.write(fos);
	     workbook.close();
	}
	
	

}
