package springBoot_CollageProject.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springBoot_CollageProject.Dto.Principal;
import springBoot_CollageProject.Repo.PrincipalRepo;

@Repository
public class PrincipalDao {

	@Autowired
	PrincipalRepo principalRepo;
	
	public Principal insert(Principal principal)
	{
		return principalRepo.save(principal);
	}
	
	public List<Principal> findAll(Principal principal)
	{
		return principalRepo.findAll();
	}
	
	public Principal findById(int principalId) {
		Optional<Principal> principal = principalRepo.findById(principalId);
		if (principal.isPresent())
		{
			return principal.get();
		}
		else
		{
			return null;
		}
	}
	
	public Principal update(int principalId, Principal principal) {
		Optional<Principal> principal2 = principalRepo.findById(principalId);
		if (principal2.isPresent()) {
			principal.setPrincipalId(principalId);
			return this.insert(principal);
		}
		else
		{
			return null;
		}
	}
	
	public Principal delete(int principalId) {
		Optional<Principal> principal = principalRepo.findById(principalId);
		if (principal.isPresent()) {
			principalRepo.deleteById(principalId);
			return principal.get();
		}
		else
		{
			return null;
		}
	}
}
