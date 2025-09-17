package in.ankit.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.ankit.entity.Citizen;
import in.ankit.repository.CitizenRepo;

@Component
public class LoadData implements CommandLineRunner {
    
	@Autowired
	private CitizenRepo repo;
	
	public void run(String... args) throws Exception {
		
		 repo.deleteAll();
		 
		 Citizen c1 = new Citizen();
		 c1.setName("Ankit");
		 c1.setGender("M");
		 c1.setPlan("Cash");
		 c1.setStatus("Approved");
		 c1.setStart_date(LocalDate.now());
		 c1.setEnd_date(LocalDate.now().plusMonths(6));
		 c1.setBenefitAmt(5000.00);
		 
		 Citizen c2 = new Citizen();
		 c2.setName("Baby");
		 c2.setGender("F");
		 c2.setPlan("Cash");
		 c2.setStatus("Terminated");
		 c2.setStart_date(LocalDate.now());
		 c2.setEnd_date(LocalDate.now().plusMonths(7));
		 c2.setBenefitAmt(3000.00);
		 c2.setTerminated_date(LocalDate.now().plusMonths(1));
		 c1.setTermination_Reason("Govt Job");
		 
		 Citizen c3 = new Citizen();
		 c3.setName("Chris");
		 c3.setGender("M");
		 c3.setPlan("Employeement");
		 c3.setStatus("Denied");
		 c3.setStart_date(LocalDate.now());
		 c3.setEnd_date(LocalDate.now().plusMonths(4));
		 c3.setBenefitAmt(2000.00);
		 c3.setDenail_Reason("Property Income");
		 
		 
		 Citizen c4 = new Citizen();
		 c4.setName("Doris");
		 c4.setGender("F");
		 c4.setPlan("Food");
		 c4.setStatus("Approved");
		 c4.setStart_date(LocalDate.now());
		 c4.setEnd_date(LocalDate.now().plusMonths(4));
		 c4.setBenefitAmt(1000.00);
		 
		 Citizen c5 = new Citizen();
		 c5.setName("Eric");
		 c5.setGender("M");
		 c5.setPlan("Medical");
		 c5.setStatus("Approved");
		 c5.setStart_date(LocalDate.now());
		 c5.setEnd_date(LocalDate.now().plusMonths(4));
		 c5.setBenefitAmt(3000.00);
		 
		 
		 List<Citizen> list = Arrays.asList(c1,c2,c3,c4,c5);
		 repo.saveAll(list);
	}

}
