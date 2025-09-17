package in.ankit.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Citizen {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String gender;
    private String plan;
	private String status;
	private LocalDate start_date;
	private LocalDate end_date; //{yyyy-mm-dd}
	private Double benefitAmt;
	private String denail_Reason;
	private LocalDate terminated_date;
	private String termination_Reason;
}
