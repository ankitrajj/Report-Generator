package in.ankit.repository;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import in.ankit.entity.Citizen;

public interface CitizenRepo extends CrudRepository<Citizen, Integer>{
    
	@Query("select distinct(plan) from Citizen")
	public List<String> getPlanName();
	
	@Query("select distinct(status) from Citizen")
	public List<String> getPlanStatus();

	public List<Citizen> findAll(Example<Citizen> of);
}
