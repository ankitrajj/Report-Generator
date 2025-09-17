package in.ankit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.ankit.entity.Citizen;
import in.ankit.request.SearchRequest;
import in.ankit.service.ReportService;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ReportController {

	@Autowired
	private ReportService service;
	
	@GetMapping("/excel")
	public void excelExport(HttpServletResponse response) throws Exception {
		response.setContentType("application/octet-stream"); 
        response.addHeader("Content-Disposition", "attachment; filename=plans.xls");
        service.exportExcel(response);		
	}
	
	@GetMapping("/pdf")
	public void pdfExport(HttpServletResponse response) throws Exception {
		response.setContentType("application/pdf"); 
        response.addHeader("Content-Disposition", "attachment; filename=plans.pdf");
        service.exportPdf(response);		
	}
	
	
	@PostMapping("/search")
	public String handleSearch(@ModelAttribute("search") SearchRequest request, Model model) { // @ModelAttribute("search") contains the previous search request data. 
		List<Citizen> lists = service.search(request);
		model.addAttribute("lists",lists);
		init(model);
		return "index";	
	}
	
	@GetMapping("/")
	public String indexpage(Model model) {	
		model.addAttribute("search", new SearchRequest());
		init(model);
		return "index";
	}

	/* Init Binding: After reloading the same page, data is available now. {Go to Refactor -> Extract Method (type init)} */
	private void init(Model model) {
		model.addAttribute("names",service.getPlan());
		model.addAttribute("statuses",service.getStatus());
	}
	
}
