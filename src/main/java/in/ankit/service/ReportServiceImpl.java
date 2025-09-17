package in.ankit.service;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.ankit.entity.Citizen;
import in.ankit.repository.CitizenRepo;
import in.ankit.request.SearchRequest;
import in.ankit.util.EmailSender;
import in.ankit.util.ExcelGenerator;
import in.ankit.util.PdfGenerator;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReportServiceImpl implements ReportService {
   
	@Autowired
	private CitizenRepo repo;
	
	@Autowired
	private ExcelGenerator excelGenerator;
	
	@Autowired
	private PdfGenerator pdfGenerator;
	
	@Autowired
	private EmailSender emailSender;
	
	@Override
	public List<String> getPlan() {
		return repo.getPlanName();
	}

	@Override
	public List<String> getStatus() {
		return repo.getPlanStatus();
	}

	@Override
	public List<Citizen> search(SearchRequest request) {	
		Citizen entity = new Citizen(); // Create an object for identity class and set the searching request variables.
		
		if(null != request.getPlan() && !"".equals(request.getPlan())) {
			entity.setPlan(request.getPlan());
		}
		
		if(null != request.getStatus() && !"".equals(request.getStatus())) {
			entity.setStatus(request.getStatus());
		}
		
		if(null != request.getGender() && !"".equals(request.getGender())) {  //Check for null and empty, then provide the request.
			entity.setGender(request.getGender());
		}
		
		if(null != request.getStart_date()  && !"".equals(request.getStart_date())) {
	
		/* {If the date in the Search request is in the string format.*/	
			String start_date = request.getStart_date();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); //converts string date to LocalDate
			LocalDate sDate = LocalDate.parse(start_date,formatter);
			entity.setStart_date(sDate);
		}
		
		if(null != request.getEnd_date() && !"".equals(request.getEnd_date())) {
			String end_date = request.getEnd_date();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate eDate = LocalDate.parse(end_date,formatter);
			entity.setEnd_date(eDate);
		}
		return repo.findAll(Example.of(entity));  // Use QBE for dynamic search with findAll() method.
	}

	
	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		File file = new File("plans.pdf");
		
		List<Citizen> plans = (List<Citizen>) repo.findAll();
		pdfGenerator.generatePdf(response, plans, file);
		
		String subject = "Citizen Plan";
		String body = "Attachemnt for the citizen plan is below:";
		String toEmail = "manisha181121@gmail.com";
		
		emailSender.sendMailWithAttachment(toEmail,subject,body,file);
		file.delete();
		return true;
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {	
		File file = new File("plans.xls");
		
		List<Citizen> plans = (List<Citizen>) repo.findAll();
		excelGenerator.generateExcel(response,plans,file);
		
		String subject = "Citizen Plan";
		String body = "Attachemnt for the citizen plan is below:";
		String toEmail = "manisha181121@gmail.com";
		
		emailSender.sendMailWithAttachment(toEmail,subject,body,file);
		file.delete(); // delete the file from the local system after sending to the gmail. 
		return true;
	}

}
