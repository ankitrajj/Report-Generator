package in.ankit.request;
import lombok.Data;

@Data
public class SearchRequest {	
    private String plan;
	private String status;
	private String gender;	
	private String start_date;  // Date comes in "string" format form UI.
	private String end_date;
}
