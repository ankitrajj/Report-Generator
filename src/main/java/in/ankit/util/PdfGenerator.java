package in.ankit.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import in.ankit.entity.Citizen;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class PdfGenerator {
	
  public void generatePdf(HttpServletResponse response, List<Citizen> plans, File file) throws Exception {
	Document document = new Document();
	PdfWriter.getInstance(document, response.getOutputStream());
	PdfWriter.getInstance(document, new FileOutputStream(file));
	document.open();
	
	Paragraph paragraph = new Paragraph("Citizen plan");
	paragraph.setAlignment(Paragraph.ALIGN_CENTER);
	document.add(paragraph);
	
	PdfPTable table = new PdfPTable(6); // 6 columns
	table.setWidthPercentage(100); 
	table.setSpacingBefore(10f);
	
	table.addCell("Id");
	table.addCell("Name");
	table.addCell("Plan");
	table.addCell("Status");
	table.addCell("Start Date");
	table.addCell("End Date");
	
	for(Citizen plan:plans) {
		table.addCell(String.valueOf(plan.getId()));
		table.addCell(plan.getName());
		table.addCell(plan.getPlan());
		table.addCell(plan.getStatus());
		table.addCell(plan.getStart_date()+"");
		table.addCell(plan.getEnd_date()+"");
	}
	document.add(table);
	document.close();
	
	}
}
