package springBoot_CollageProject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import springBoot_CollageProject.Dao.PrincipalDao;
import springBoot_CollageProject.Dto.Principal;
import springBoot_CollageProject.ExceptionHandiling.PrincipalIdNotFound;
import springBoot_CollageProject.Util.ResponseStructure;

@Service
public class PrincipalService {

	@Autowired
	PrincipalDao principalDao;
	
	public ResponseStructure<Principal> insert(Principal principal)
	{
		ResponseStructure<Principal> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("successfully inserted");
		responseStructure.setData(principalDao.insert(principal));
		return responseStructure;
	}
	
	public ResponseStructure<Principal> findAll(Principal principal)
	{
		ResponseStructure<Principal> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("fetch successfully ");
		responseStructure.setData(principalDao.insert(principal));
		return responseStructure;
	}
	
	public ResponseEntity<ResponseStructure<Principal>> fetchById(int princilapId)
	{
		ResponseStructure<Principal> responseStructure = new ResponseStructure<>();
		Principal principal2 = principalDao.findById(princilapId);
		if (principal2!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("fetch successfully");
			responseStructure.setData(principalDao.findById(princilapId));
			return new ResponseEntity<ResponseStructure<Principal>>(responseStructure,HttpStatus.FOUND);			
		}
		else
		{
			throw new PrincipalIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Principal>> update(int princilapId,Principal principal)
	{
		ResponseStructure<Principal> responseStructure = new ResponseStructure<>();
		Principal principal2 = principalDao.update(princilapId, principal);
		if (principal2!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("successfully inserted");
			responseStructure.setData(principalDao.insert(principal));
			return new ResponseEntity<ResponseStructure<Principal>>(responseStructure,HttpStatus.OK);			
		}
		else
		{
			throw new PrincipalIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Principal>> delete(int princilapId)
	{
		ResponseStructure<Principal> responseStructure = new ResponseStructure<>();
		Principal principal2 = principalDao.delete(princilapId);
		if (principal2!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("successfully inserted");
			responseStructure.setData(principalDao.delete(princilapId));
			return new ResponseEntity<ResponseStructure<Principal>>(responseStructure,HttpStatus.OK);			
		}
		else
		{
			throw new PrincipalIdNotFound();
		}
	}
	
}
